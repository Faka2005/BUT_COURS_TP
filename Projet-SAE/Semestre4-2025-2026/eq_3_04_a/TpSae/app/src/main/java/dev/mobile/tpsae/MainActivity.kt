package dev.mobile.tpsae

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatDelegate
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.os.LocaleListCompat
import dev.mobile.tpsae.ui.navigation.AppNav
import dev.mobile.tpsae.ui.theme.TpSaeTheme
import dev.mobile.tpsae.ui.viewmodel.MovieViewModel
import dev.mobile.tpsae.ui.viewmodel.SerieViewModel

class MainActivity : ComponentActivity() {
    private val viewModel : MovieViewModel by viewModels { MovieViewModel.factory }
    private val viewModelS : SerieViewModel by viewModels { SerieViewModel.factory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setApplicationLocales(
            LocaleListCompat.getEmptyLocaleList()
        )
        enableEdgeToEdge()
        setContent {
            TpSaeTheme {
                AppNav(modifier = Modifier, viewModel = viewModel, viewModelS = viewModelS)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TpSaeTheme {
        Text("test")
    }
}