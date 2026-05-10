package dev.mobile.tpsae.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import dev.mobile.tpsae.data.Resource
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import dev.mobile.tpsae.MyApp
import dev.mobile.tpsae.data.model.Serie
import dev.mobile.tpsae.data.repo.SerieRepo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

sealed interface SerieScreenState {
    object Idle : SerieScreenState
    object Loading : SerieScreenState
    data class SuccessSerie(val series: List<Serie>) : SerieScreenState
    data class Error(val message: String) : SerieScreenState
}

class SerieViewModel(private val repo : SerieRepo) : ViewModel(){
    private val _uiState = MutableStateFlow<SerieScreenState>(SerieScreenState.Idle)
    val uiState = _uiState.asStateFlow()

    private val _genres = MutableStateFlow<List<String>>(emptyList())
    val genres = _genres.asStateFlow()

    private var currentSerie: List<Serie> = emptyList()
    private var currentSort: String = "default"

    private var selectedGenres: List<String> = listOf("All")

    private var currentPage = 1
    private var currentQuery: String? = null
    private var isLastPage = false
    private var isFetching = false

    init {
        searchSeries("")
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
            currentSerie
        } else {
            currentSerie.filter { serie ->
                selectedGenres.all { genre -> serie.genres.contains(genre) }
            }
        }

        val sortedList = when (currentSort){
            "popular" -> list.sortedByDescending { it.popularity }
            "top-rated" -> list.sortedByDescending { it.rate }
            "recent" -> list.sortedByDescending { it.date }
            else -> list
        }
        _uiState.value = SerieScreenState.SuccessSerie(sortedList)
    }

    fun searchSeries(query: String = ""){
        viewModelScope.launch {
            _uiState.value = SerieScreenState.Loading
            currentPage = 1
            isLastPage = false
            currentQuery = query.ifEmpty { null }
            val res = if (query.isEmpty()) repo.getPopularSeries(1) else repo.searchSeries(query,1)

            when(res){
                is Resource.Success -> {
                    currentSerie = res.data
                    _genres.value = listOf("All") + res.data.flatMap { it.genres }.distinct().sorted()
                    sortAndPublish()
                }
                is Resource.Error -> {
                    _uiState.value = SerieScreenState.Error(res.message)
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
            val res = if (currentQuery == null) repo.getPopularSeries(nextPage) else repo.searchSeries(currentQuery!!, nextPage)

            if (res is Resource.Success) {
                if (res.data.isEmpty()) {
                    isLastPage = true
                } else {
                    currentPage = nextPage
                    currentSerie = currentSerie + res.data
                    sortAndPublish()
                }
            }
            isFetching = false
        }
    }
    fun getSerieById(id: Int): Serie? = currentSerie.find { it.id == id }

    companion object{
        val factory : ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val app = (this[APPLICATION_KEY] as MyApp)
                SerieViewModel(repo = app.repoS)
            }
        }
    }
}