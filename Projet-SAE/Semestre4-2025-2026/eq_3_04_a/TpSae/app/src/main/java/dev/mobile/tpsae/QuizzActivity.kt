package dev.mobile.tpsae

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dev.mobile.tpsae.ui.theme.TpSaeTheme
import dev.mobile.tpsae.ui.viewmodel.MovieViewModel
import dev.mobile.tpsae.ui.viewmodel.SerieViewModel
import dev.mobile.tpsae.ui.views.CommonDetailsView
import dev.mobile.tpsae.ui.views.QuizzView

class QuizzActivity : ComponentActivity() {

    private val movieViewModel: MovieViewModel by viewModels { MovieViewModel.factory }
    private val serieViewModel: SerieViewModel by viewModels { SerieViewModel.factory }

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            TpSaeTheme {
                val navController = rememberNavController()

                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = { Text(stringResource(R.string.quizz_title)) },
                            navigationIcon = {
                                IconButton(onClick = {
                                    if (!navController.popBackStack()) {
                                        finish()
                                    }
                                }) {
                                    Icon(
                                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                        contentDescription = stringResource(R.string.details_back)
                                    )
                                }
                            }
                        )
                    }
                ) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = "quizz_home",
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable("quizz_home") {
                            QuizzView(
                                navController = navController,
                                movieViewModel = movieViewModel,
                                serieViewModel = serieViewModel,
                                isStandaloneActivity = true
                            )
                        }

                        composable("details/{id}") { backStackEntry ->
                            val id = backStackEntry.arguments?.getString("id")?.toIntOrNull() ?: -1
                            val movie = movieViewModel.getMovieById(id)

                            if (movie != null) {
                                CommonDetailsView(
                                    title = movie.title,
                                    overview = movie.overview ?: "",
                                    imageUrl = movie.imageUrl,
                                    rating = movie.rate,
                                    nbVote = movie.nbVote,
                                    popularity = movie.popularity,
                                    genres = movie.genres,
                                    onBackClick = { navController.popBackStack() }
                                )
                            }
                        }

                        composable("detailsSerie/{id}") { backStackEntry ->
                            val id = backStackEntry.arguments?.getString("id")?.toIntOrNull() ?: -1
                            val serie = serieViewModel.getSerieById(id)

                            if (serie != null) {
                                CommonDetailsView(
                                    title = serie.name,
                                    overview = serie.overview ?: "",
                                    imageUrl = serie.imageUrl,
                                    rating = serie.rate,
                                    nbVote = serie.nbVote,
                                    popularity = serie.popularity,
                                    genres = serie.genres,
                                    onBackClick = { navController.popBackStack() }
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}