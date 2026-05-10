package dev.mobile.tpsae.ui.views

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import dev.mobile.tpsae.R
import dev.mobile.tpsae.data.model.Movie
import dev.mobile.tpsae.data.model.Serie
import dev.mobile.tpsae.ui.compo.MovieCard
import dev.mobile.tpsae.ui.compo.SerieCard
import dev.mobile.tpsae.ui.compo.FilterSection
import dev.mobile.tpsae.ui.viewmodel.MovieViewModel
import dev.mobile.tpsae.ui.viewmodel.ScreenState
import dev.mobile.tpsae.ui.viewmodel.SerieViewModel
import dev.mobile.tpsae.ui.viewmodel.SerieScreenState

@Composable
fun CatalogView(
    modifier: Modifier = Modifier,
    navController: NavController,
    movieViewModel: MovieViewModel = viewModel(factory = MovieViewModel.factory),
    serieViewModel: SerieViewModel = viewModel(factory = SerieViewModel.factory)
) {
    val movieUiState by movieViewModel.uiState.collectAsStateWithLifecycle()
    val movieGenres by movieViewModel.genres.collectAsStateWithLifecycle()
    val serieUiState by serieViewModel.uiState.collectAsStateWithLifecycle()
    val serieGenres by serieViewModel.genres.collectAsStateWithLifecycle()

    var currentCategory by remember { mutableStateOf("movie") }
    var query by remember { mutableStateOf("") }
    var currentSort by remember { mutableStateOf("default") }

    Column(modifier = modifier.fillMaxSize()) {

        Row(modifier = Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
            TextField(
                value = query,
                onValueChange = { query = it },
                modifier = Modifier.weight(1f),
                placeholder = { Text(stringResource(R.string.search_placeholder)) },
                singleLine = true,
                shape = RoundedCornerShape(12.dp),
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
                keyboardActions = KeyboardActions(onSearch = {
                    if (currentCategory == "movie" || currentCategory == "both") movieViewModel.searchMovies(query)
                    if (currentCategory == "tv" || currentCategory == "both") serieViewModel.searchSeries(query)
                })
            )
        }

        FilterSection(
            genres = when (currentCategory) {
                "movie" -> movieGenres
                "tv" -> serieGenres
                else -> (movieGenres + serieGenres).distinct().sorted()
            },
            onSortSelected = { sort ->
                currentSort = sort
                movieViewModel.applyFilter(sort)
                serieViewModel.applyFilter(sort)
            },
            onGenresSelected = { genres ->
                movieViewModel.applyGenres(genres)
                serieViewModel.applyGenres(genres)
            },
            onCategorySelected = { category ->
                currentCategory = category
                if (category == "movie" || category == "both") movieViewModel.searchMovies(query)
                if (category == "tv" || category == "both") serieViewModel.searchSeries(query)
            }
        )

        when (currentCategory) {
            "movie" -> {
                when (val state = movieUiState) {
                    is ScreenState.Loading -> LoadingBox()
                    is ScreenState.SuccessMovie -> MovieGrid(state.movies, movieViewModel)
                    is ScreenState.Error -> ErrorBox(state.message)
                    else -> {}
                }
            }
            "tv" -> {
                when (val stateS = serieUiState) {
                    is SerieScreenState.Loading -> LoadingBox()
                    is SerieScreenState.SuccessSerie -> SerieGrid(stateS.series, serieViewModel)
                    is SerieScreenState.Error -> ErrorBox(stateS.message)
                    else -> {}
                }
            }
            "both" -> {
                BothGrid(movieUiState, serieUiState, movieViewModel, serieViewModel, currentSort)
            }
        }
    }
}

@Composable
fun BothGrid(
    mState: ScreenState,
    sState: SerieScreenState,
    mVM: MovieViewModel,
    sVM: SerieViewModel,
    sortOrder: String
) {
    val movies = (mState as? ScreenState.SuccessMovie)?.movies ?: emptyList()
    val series = (sState as? SerieScreenState.SuccessSerie)?.series ?: emptyList()

    val combinedList = (movies.map { it to "movie" } + series.map { it to "serie" })

    val sortedList = when (sortOrder) {
        "popular" -> combinedList.sortedByDescending { (item, _) ->
            if (item is Movie) item.popularity else (item as Serie).popularity
        }
        "top-rated" -> combinedList.sortedByDescending { (item, _) ->
            if (item is Movie) item.rate else (item as Serie).rate
        }
        "recent" -> combinedList.sortedByDescending { (item, _) ->
            if (item is Movie) item.date else (item as Serie).date
        }
        else -> combinedList
    }

    if (sortedList.isEmpty() && (mState is ScreenState.Loading || sState is SerieScreenState.Loading)) {
        LoadingBox()
    } else {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            itemsIndexed(sortedList) { index, (item, type) ->
                if (index >= sortedList.size - 5) {
                    mVM.loadNextPage()
                    sVM.loadNextPage()
                }
                if (type == "movie") {
                    MovieCard(
                        movie = item as Movie,
                        modifier = Modifier.height(300.dp)
                    )
                } else {
                    SerieCard(
                        serie = item as Serie,
                        modifier = Modifier.height(300.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun LoadingBox() {
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        CircularProgressIndicator()
    }
}

@Composable
fun ErrorBox(message: String) {
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(message, color = MaterialTheme.colorScheme.error, modifier = Modifier.padding(16.dp))
    }
}

@Composable
fun MovieGrid(movies: List<Movie>, movieViewModel: MovieViewModel) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        itemsIndexed(movies) { index, movie ->
            if (index >= movies.size - 5) movieViewModel.loadNextPage()
            MovieCard(
                movie = movie,
                modifier = Modifier.fillMaxWidth().height(300.dp)
            )
        }
    }
}

@Composable
fun SerieGrid(series: List<Serie>, serieViewModel: SerieViewModel) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        itemsIndexed(series) { index, serie ->
            if (index >= series.size - 5) serieViewModel.loadNextPage()
            SerieCard(
                serie = serie,
                modifier = Modifier.fillMaxWidth().height(300.dp)
            )
        }
    }
}