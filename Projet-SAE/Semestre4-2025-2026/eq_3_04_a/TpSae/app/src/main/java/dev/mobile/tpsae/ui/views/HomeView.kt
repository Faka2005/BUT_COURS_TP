package dev.mobile.tpsae.ui.views

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import dev.mobile.tpsae.R
import dev.mobile.tpsae.data.model.Movie
import dev.mobile.tpsae.data.model.Serie
import dev.mobile.tpsae.ui.compo.MovieCard
import dev.mobile.tpsae.ui.compo.SerieCard
import dev.mobile.tpsae.ui.viewmodel.MovieViewModel
import dev.mobile.tpsae.ui.viewmodel.ScreenState
import dev.mobile.tpsae.ui.viewmodel.SerieScreenState
import dev.mobile.tpsae.ui.viewmodel.SerieViewModel
@Composable
fun HomeView(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: MovieViewModel = viewModel(factory = MovieViewModel.factory),
    viewModelS: SerieViewModel = viewModel(factory = SerieViewModel.factory)
) {
    val uiState by viewModel.uiState.collectAsState()
    val uiStateS by viewModelS.uiState.collectAsState()

    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = MaterialTheme.colorScheme.background
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(24.dp),
            contentPadding = PaddingValues(bottom = 24.dp)
        ) {
            item {
                Text(
                    text = stringResource(R.string.titre_home),
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(16.dp)
                )
            }
            item {
                Text(
                    text = stringResource(R.string.soustitre_home_films),
                    fontSize = 22.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
            }

            when (val state = uiState) {
                is ScreenState.Loading -> item { Box(Modifier.fillMaxWidth()) { CircularProgressIndicator(Modifier.align(Alignment.Center)) } }
                is ScreenState.SuccessMovie -> {
                    item {
                        MovieSection(
                            title = stringResource(R.string.sort_popular),
                            movies = state.movies.sortedByDescending { it.popularity }.take(40)
                        )
                    }
                    item {
                        MovieSection(
                            title = stringResource(R.string.sort_top_rated),
                            movies = state.movies.sortedByDescending { it.rate }.take(40)
                        )
                    }
                    item {
                        MovieSection(
                            title = stringResource(R.string.sort_latest),
                            movies = state.movies.sortedByDescending { it.date }.take(40)
                        )
                    }
                }
                is ScreenState.Error -> item { Text(state.message, color = MaterialTheme.colorScheme.error) }
                else -> {}
            }

            item { Spacer(modifier = Modifier.height(8.dp)) }

            item {
                Text(
                    text = stringResource(R.string.soustitre_home_serie),
                    fontSize = 22.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = MaterialTheme.colorScheme.secondary,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
            }

            when (val stateS = uiStateS) {
                is SerieScreenState.Loading -> item { Box(Modifier.fillMaxWidth()) { CircularProgressIndicator(Modifier.align(Alignment.Center)) } }
                is SerieScreenState.SuccessSerie -> {
                    item {
                        SerieSection(
                            title = stringResource(R.string.sort_popular),
                            series = stateS.series.sortedByDescending { it.popularity }.take(40)
                        )
                    }
                    item {
                        SerieSection(
                            title = stringResource(R.string.sort_top_rated),
                            series = stateS.series.sortedByDescending { it.rate }.take(40)
                        )
                    }
                    item {
                        SerieSection(
                            title = stringResource(R.string.sort_latest),
                            series = stateS.series.sortedByDescending { it.date }.take(40)
                        )
                    }
                }
                is SerieScreenState.Error -> item { Text(stateS.message, color = MaterialTheme.colorScheme.error) }
                else -> {}
            }
        }
    }
}

@Composable
fun MovieSection(
    title: String,
    movies: List<Movie>
) {
    Column {
        Text(
            text = title,
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
        )
        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(movies) { movie ->
                MovieCard(
                    movie = movie,
                    modifier = Modifier
                        .width(150.dp)
                        .height(230.dp)
                )
            }
        }
    }
}

@Composable
fun SerieSection(
    title: String,
    series: List<Serie>
) {
    Column {
        Text(
            text = title,
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
        )
        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(series) { serie ->
                SerieCard(
                    serie = serie,
                    modifier = Modifier
                        .width(150.dp)
                        .height(230.dp)
                )
            }
        }
    }
}