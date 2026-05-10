package dev.mobile.tpsae.ui.compo

import android.content.Intent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.mobile.tpsae.DetailActivity
import dev.mobile.tpsae.data.model.Movie
import coil.compose.AsyncImage

@Composable
fun MovieCard(movie: Movie, modifier: Modifier = Modifier) {
    val context = LocalContext.current

    Column(
        modifier = modifier.clickable {
            val intent = Intent(context, DetailActivity::class.java).apply {
                putExtra("title", movie.title)
                putExtra("overview", movie.overview ?: "")
                putExtra("imageUrl", movie.imageUrl)
                putExtra("rating", movie.rate)
                putExtra("nbVote", movie.nbVote)
                putExtra("popularity", movie.popularity)
                putStringArrayListExtra("genres", ArrayList(movie.genres))
                putExtra("ITEM_TYPE", "movie")
            }
            context.startActivity(intent)
        }
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            shape = RoundedCornerShape(12.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            AsyncImage(
                model = movie.imageUrl,
                contentDescription = movie.title,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = movie.title,
            color = MaterialTheme.colorScheme.onSurface,
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .padding(horizontal = 4.dp)
                .padding(bottom = 4.dp)
        )
    }
}