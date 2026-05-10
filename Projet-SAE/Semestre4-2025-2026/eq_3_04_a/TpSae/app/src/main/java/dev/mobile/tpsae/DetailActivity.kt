package dev.mobile.tpsae

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import dev.mobile.tpsae.ui.theme.TpSaeTheme
import dev.mobile.tpsae.ui.views.CommonDetailsView

class DetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val title = intent.getStringExtra("title") ?: ""
        val overview = intent.getStringExtra("overview") ?: ""
        val imageUrl = intent.getStringExtra("imageUrl") ?: ""
        val rating = intent.getFloatExtra("rating", 0f)
        val nbVote = intent.getIntExtra("nbVote", 0)
        val genres = intent.getStringArrayListExtra("genres") ?: arrayListOf<String>()
        val popularity = intent.getFloatExtra("popularity", 0f)

        setContent {
            TpSaeTheme {
                Scaffold { innerPadding ->
                    CommonDetailsView(
                        modifier = Modifier.padding(innerPadding),
                        title = title,
                        overview = overview,
                        imageUrl = imageUrl,
                        rating = rating,
                        nbVote = nbVote,
                        popularity = popularity,
                        genres = genres,
                        onBackClick = { finish() }
                    )
                }
            }
        }
    }
}