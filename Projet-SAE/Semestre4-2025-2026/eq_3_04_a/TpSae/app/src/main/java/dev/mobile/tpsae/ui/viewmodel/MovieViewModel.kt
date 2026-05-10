package dev.mobile.tpsae.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import dev.mobile.tpsae.data.Resource
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import dev.mobile.tpsae.MyApp
import dev.mobile.tpsae.data.model.Movie
import dev.mobile.tpsae.data.repo.MovieRepo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

sealed interface ScreenState {
    object Idle : ScreenState
    object Loading : ScreenState
    data class SuccessMovie(val movies: List<Movie>) : ScreenState
    data class Error(val message: String) : ScreenState
}

class MovieViewModel(private val repo : MovieRepo) : ViewModel(){
    private val _uiState = MutableStateFlow<ScreenState>(ScreenState.Idle)
    val uiState = _uiState.asStateFlow()

    private val _genres = MutableStateFlow<List<String>>(emptyList())
    val genres = _genres.asStateFlow()

    private var currentMovies: List<Movie> = emptyList()
    private var currentSort: String = "default"
    private var selectedGenres: List<String> = listOf("All")

    private var currentPage = 1
    private var currentQuery: String? = null
    private var isLastPage = false
    private var isFetching = false

    init {
        searchMovies("")
    }

    fun applyFilter(sort: String){
        currentSort = sort
        sortAndPublish()
    }
    fun applyGenres(genres: List<String>) {
        selectedGenres = genres
        sortAndPublish()
    }

    private fun sortAndPublish() {
        val list = if (selectedGenres.contains("All")) {
            currentMovies
        } else {
            currentMovies.filter { movie ->
                selectedGenres.all { genre -> movie.genres.contains(genre) }
            }
        }

        val sortedList = when (currentSort){
            "popular" -> list.sortedByDescending { it.popularity }
            "top-rated" -> list.sortedByDescending { it.rate }
            "recent" -> list.sortedByDescending { it.date }
            else -> list
        }
        _uiState.value = ScreenState.SuccessMovie(sortedList)
    }

    fun searchMovies(query: String = ""){
        viewModelScope.launch {
            _uiState.value = ScreenState.Loading
            currentPage = 1
            isLastPage = false
            currentQuery = query.ifEmpty { null }
            val res = if (query.isEmpty()) repo.getPopularMovies(1) else repo.searchMovies(query,1)

            when(res){
                is Resource.Success -> {
                    currentMovies = res.data
                    _genres.value = listOf("All") + res.data.flatMap { it.genres }.distinct().sorted()
                    sortAndPublish()
                }
                is Resource.Error -> {
                    _uiState.value = ScreenState.Error(res.message)
                }
                else -> {}
            }
        }
    }

    fun loadNextPage() {
        if (isFetching || isLastPage) return

        viewModelScope.launch {
            isFetching = true
            val nextPage = currentPage + 1
            val res = if (currentQuery == null) repo.getPopularMovies(nextPage) else repo.searchMovies(currentQuery!!, nextPage)

            if (res is Resource.Success) {
                if (res.data.isEmpty()) {
                    isLastPage = true
                } else {
                    currentPage = nextPage
                    currentMovies = currentMovies + res.data
                    sortAndPublish()
                }
            }
            isFetching = false
        }
    }

    fun getMovieById(id: Int): Movie? = currentMovies.find { it.id == id }

    companion object{
        val factory : ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val app = (this[APPLICATION_KEY] as MyApp)
                MovieViewModel(repo = app.repo)
            }
        }
    }
}