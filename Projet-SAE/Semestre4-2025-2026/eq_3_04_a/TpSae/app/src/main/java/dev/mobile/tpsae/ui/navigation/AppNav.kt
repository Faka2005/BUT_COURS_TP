package dev.mobile.tpsae.ui.navigation

import android.content.Intent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import dev.mobile.tpsae.QuizzActivity
import dev.mobile.tpsae.ui.viewmodel.MovieViewModel
import dev.mobile.tpsae.ui.viewmodel.SerieViewModel
import dev.mobile.tpsae.ui.views.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppNav(modifier: Modifier, viewModel: MovieViewModel, viewModelS : SerieViewModel) {
    val navController = rememberNavController()
    val context = LocalContext.current

    val items = listOf(
        Triple("home", "Home", Icons.Filled.Home),
        Triple("catalog", "Search", Icons.Filled.Search),
        Triple("quizz", "Quizz", Icons.Filled.Star)
    )

    Scaffold(
        bottomBar = {
            NavigationBar(containerColor = MaterialTheme.colorScheme.surface) {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination

                items.forEach { (route, label, icon) ->
                    val isSelected = currentDestination?.hierarchy?.any { it.route == route } == true

                    NavigationBarItem(
                        icon = { Icon(icon, contentDescription = label) },
                        label = { Text(label) },
                        selected = isSelected,
                        onClick = {
                            if (route == "quizz") {
                                val intent = Intent(context, QuizzActivity::class.java)
                                context.startActivity(intent)
                            } else {
                                navController.navigate(route) {
                                    popUpTo(navController.graph.findStartDestination().id) {
                                        saveState = true
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            }
                        }
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "home",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("home") { HomeView(Modifier, navController, viewModel, viewModelS) }
            composable("catalog") { CatalogView(Modifier, navController, viewModel, viewModelS) }
            composable("quizz") { QuizzView(Modifier, navController, viewModel, viewModelS) }

        }
    }
}