package dev.mobile.tpsae.ui.views

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import dev.mobile.tpsae.R

@Composable
fun CommonDetailsView(
    modifier: Modifier = Modifier,
    title: String,
    overview: String,
    imageUrl: String,
    rating: Float,
    nbVote: Int,
    popularity: Float,
    genres: List<String>,
    onBackClick: () -> Unit
) {
    Column(
        modifier = modifier.fillMaxSize().verticalScroll(rememberScrollState())
    ) {
        AsyncImage(
            model = imageUrl,
            contentDescription = null,
            modifier = Modifier.fillMaxWidth().height(450.dp),
            contentScale = ContentScale.Crop
        )

        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = title, fontSize = 28.sp, fontWeight = FontWeight.ExtraBold)

            Row(
                modifier = Modifier
                    .padding(vertical = 8.dp)
                    .horizontalScroll(rememberScrollState()),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                genres.forEach { genre ->
                    SuggestionChip(
                        onClick = { },
                        label = { Text(genre, fontSize = 12.sp) }
                    )
                }
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Default.Star, contentDescription = null, tint = Color(0xFFFFC107))
                    Text(text = " $rating ", fontWeight = FontWeight.Bold)
                    Text(text = "($nbVote)", color = Color.Gray, fontSize = 14.sp)
                }

                Surface(
                    color = MaterialTheme.colorScheme.primaryContainer,
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(
                        text = "Pop: ${popularity.toInt()}",
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                }
            }

            HorizontalDivider(modifier = Modifier.padding(vertical = 16.dp))

            Text(text = stringResource(R.string.genres_label), fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Text(
                text = overview.ifBlank { "Aucun synopsis disponible." },
                modifier = Modifier.padding(top = 8.dp),
                style = MaterialTheme.typography.bodyLarge
            )

            Spacer(modifier = Modifier.height(32.dp))

            Button(onClick = onBackClick, modifier = Modifier.fillMaxWidth()) {
                Text(stringResource(R.string.details_back))
            }
        }
    }
}