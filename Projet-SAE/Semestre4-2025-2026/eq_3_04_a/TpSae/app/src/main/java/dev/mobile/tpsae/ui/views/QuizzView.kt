package dev.mobile.tpsae.ui.views

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import dev.mobile.tpsae.data.model.Movie
import dev.mobile.tpsae.data.model.Serie
import dev.mobile.tpsae.ui.compo.MovieCard
import dev.mobile.tpsae.ui.compo.SerieCard
import dev.mobile.tpsae.ui.viewmodel.MovieViewModel
import dev.mobile.tpsae.ui.viewmodel.ScreenState
import dev.mobile.tpsae.ui.viewmodel.SerieScreenState
import dev.mobile.tpsae.ui.viewmodel.SerieViewModel
import dev.mobile.tpsae.R

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun QuizzView(
    modifier: Modifier = Modifier,
    navController: NavController,
    movieViewModel: MovieViewModel,
    serieViewModel: SerieViewModel,
    isStandaloneActivity: Boolean = false
) {
    val movieState by movieViewModel.uiState.collectAsState()
    val serieState by serieViewModel.uiState.collectAsState()

    val labelAll = stringResource(R.string.quizz_type_all)
    val labelMovies = stringResource(R.string.soustitre_home_films)
    val labelSeries = stringResource(R.string.soustitre_home_serie)
    val labelPopBlock = stringResource(R.string.quizz_pop_blockbuster)
    val labelPopHidden = stringResource(R.string.quizz_pop_hidden)
    val labelPopAny = stringResource(R.string.quizz_pop_any)


    var minRate by rememberSaveable { mutableFloatStateOf(6f) }
    var selectedType by rememberSaveable { mutableStateOf(labelAll) }
    var popularityFilter by rememberSaveable { mutableStateOf(labelPopAny) }
    var selectedGenre by rememberSaveable { mutableStateOf(labelAll) }

    var refreshTrigger by rememberSaveable { mutableIntStateOf(0) }
    var showResult by rememberSaveable { mutableStateOf(false) }

    val allGenres = remember(movieState, serieState, labelAll) {
        val mG = (movieState as? ScreenState.SuccessMovie)?.movies?.flatMap { it.genres } ?: emptyList()
        val sG = (serieState as? SerieScreenState.SuccessSerie)?.series?.flatMap { it.genres } ?: emptyList()
        (listOf(labelAll) + (mG + sG).distinct().sorted()).take(15)
    }

    val recommendedItems = remember(showResult, minRate, selectedType, popularityFilter, selectedGenre, refreshTrigger, movieState, serieState) {
        if (!showResult) return@remember emptyList()

        val movies = if (selectedType == labelSeries) emptyList() else (movieState as? ScreenState.SuccessMovie)?.movies ?: emptyList()
        val series = if (selectedType == labelMovies) emptyList() else (serieState as? SerieScreenState.SuccessSerie)?.series ?: emptyList()
        val combined = (movies.map { it to "movie" } + series.map { it to "serie" })

        combined.filter { (item, type) ->
            val rate = if (type == "movie") (item as Movie).rate else (item as Serie).rate
            val pop = if (type == "movie") (item as Movie).popularity else (item as Serie).popularity
            val genres = if (type == "movie") (item as Movie).genres else (item as Serie).genres

            rate >= minRate &&
                    (selectedGenre == labelAll || genres.contains(selectedGenre)) &&
                    when(popularityFilter) {
                        labelPopBlock -> pop > 500
                        labelPopHidden -> pop <= 500
                        else -> true
                    }
        }.shuffled().take(10)
    }

    Column(
        modifier = modifier.fillMaxSize().padding(16.dp).verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(text = stringResource(R.string.quizz_title), fontSize = 32.sp, fontWeight = FontWeight.ExtraBold, color = MaterialTheme.colorScheme.primary)

        QuizzCard(stringResource(R.string.quizz_q1)) {
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
                listOf(labelMovies, labelSeries, labelAll).forEach { type ->
                    FilterChip(selected = selectedType == type, onClick = { selectedType = type; showResult = false }, label = { Text(type) })
                }
            }
        }

        QuizzCard(stringResource(R.string.quizz_q2, minRate.toInt())) {
            Slider(value = minRate, onValueChange = { minRate = it; showResult = false }, valueRange = 0f..10f, steps = 9)
        }

        QuizzCard(stringResource(R.string.quizz_q3)) {
            listOf(labelPopBlock, labelPopHidden, labelPopAny).forEach { p ->
                Row(verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(selected = popularityFilter == p, onClick = { popularityFilter = p; showResult = false })
                    Text(p)
                }
            }
        }

        QuizzCard(stringResource(R.string.quizz_q4)) {
            ScrollableTabRow(
                selectedTabIndex = allGenres.indexOf(selectedGenre).coerceAtLeast(0),
                edgePadding = 0.dp,
                containerColor = Color.Transparent,
                divider = {}
            ) {
                allGenres.forEach { genre ->
                    Tab(selected = selectedGenre == genre, onClick = { selectedGenre = genre; showResult = false }, text = { Text(genre) })
                }
            }
        }

        Button(
            onClick = { showResult = true; refreshTrigger++ },
            modifier = Modifier.fillMaxWidth().height(60.dp),
            shape = RoundedCornerShape(16.dp)
        ) {
            Icon(Icons.Default.Refresh, null)
            Spacer(Modifier.width(8.dp))
            Text(
                text = if (showResult) stringResource(R.string.quizz_btn_reroll) else stringResource(R.string.quizz_btn_launch),
                fontSize = 18.sp
            )
        }

        AnimatedVisibility(visible = showResult) {
            Column(modifier = Modifier.padding(bottom = 24.dp)) {
                Text(stringResource(R.string.quizz_results), fontWeight = FontWeight.Bold, fontSize = 20.sp, modifier = Modifier.padding(vertical = 8.dp))

                if (recommendedItems.isEmpty()) {
                    Text(stringResource(R.string.quizz_no_results))
                } else {
                    LazyRow(horizontalArrangement = Arrangement.spacedBy(12.dp), modifier = Modifier.height(280.dp)) {
                        items(recommendedItems) { (item, type) ->
                            val cardModifier = Modifier.width(160.dp)
                            if (type == "movie") MovieCard(movie = item as Movie, modifier = cardModifier)
                            else SerieCard(serie = item as Serie, modifier = cardModifier)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun QuizzCard(title: String, content: @Composable () -> Unit) {
    Card(modifier = Modifier.fillMaxWidth(), elevation = CardDefaults.cardElevation(2.dp)) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(title, fontWeight = FontWeight.Bold, fontSize = 16.sp)
            Spacer(Modifier.height(8.dp))
            content()
        }
    }
}