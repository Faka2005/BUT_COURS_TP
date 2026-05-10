package dev.mobile.tpsae.ui.compo

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import dev.mobile.tpsae.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FilterSection(
    genres: List<String>,
    onSortSelected: (String) -> Unit,
    onGenresSelected: (List<String>) -> Unit,
    onCategorySelected: (String) -> Unit
) {
    var isExpanded by remember { mutableStateOf(false) }
    var selectedSort by remember { mutableStateOf("default") }
    var selectedGenres by remember { mutableStateOf(listOf("All")) }
    var selectedCategory by remember { mutableStateOf("movie") }

    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
        Button(
            onClick = { isExpanded = !isExpanded },
            modifier = Modifier.fillMaxWidth(),
            shape = MaterialTheme.shapes.medium,
            colors = if (selectedSort != "default" || !selectedGenres.contains("All") || selectedCategory != "movie")
                ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.secondary)
            else ButtonDefaults.buttonColors()
        ) {
            Text(if (isExpanded) stringResource(R.string.filter_btn_close) else stringResource(R.string.filter_btn_open))
        }

        AnimatedVisibility(visible = isExpanded) {
            Column(modifier = Modifier.padding(top = 12.dp, bottom = 16.dp).fillMaxWidth()) {

                Text(stringResource(R.string.category_label), style = MaterialTheme.typography.labelLarge, color = MaterialTheme.colorScheme.primary)
                Row(
                    modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    val categories = listOf(
                        "movie" to "Movies",
                        "tv" to "TV Shows",
                        "both" to "Both"
                    )
                    categories.forEach { (key, label) ->
                        FilterChip(
                            selected = selectedCategory == key,
                            onClick = {
                                selectedCategory = key
                                onCategorySelected(key)
                            },
                            label = { Text(label) },
                            leadingIcon = if (selectedCategory == key) {
                                { Icon(Icons.Default.Done, null, Modifier.size(FilterChipDefaults.IconSize)) }
                            } else null
                        )
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))

                Text(stringResource(R.string.sort_by_label), style = MaterialTheme.typography.labelLarge, color = MaterialTheme.colorScheme.primary)
                Row(
                    modifier = Modifier.fillMaxWidth().horizontalScroll(rememberScrollState()),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    val sorts = listOf(
                        "popular" to stringResource(R.string.sort_popular),
                        "top-rated" to stringResource(R.string.sort_top_rated),
                        "recent" to stringResource(R.string.sort_latest)
                    )
                    sorts.forEach { (key, label) ->
                        FilterChip(
                            selected = selectedSort == key,
                            onClick = { selectedSort = key; onSortSelected(key) },
                            label = { Text(label) }
                        )
                    }
                    FilterChip(
                        selected = selectedSort == "default",
                        onClick = { selectedSort = "default"; onSortSelected("default") },
                        label = { Text("✕") },
                        colors = FilterChipDefaults.filterChipColors(selectedContainerColor = MaterialTheme.colorScheme.errorContainer)
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))
                Text(stringResource(R.string.genres_label), style = MaterialTheme.typography.labelLarge, color = MaterialTheme.colorScheme.primary)
                Row(
                    modifier = Modifier.fillMaxWidth().horizontalScroll(rememberScrollState()),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    genres.forEach { genre ->
                        val isSelected = selectedGenres.contains(genre)
                        FilterChip(
                            selected = isSelected,
                            onClick = {
                                val newList = if (genre == "All") {
                                    listOf("All")
                                } else {
                                    val currentWithoutAll = selectedGenres.filter { it != "All" }
                                    if (isSelected) {
                                        val removed = currentWithoutAll - genre
                                        if (removed.isEmpty()) listOf("All") else removed
                                    } else {
                                        currentWithoutAll + genre
                                    }
                                }
                                selectedGenres = newList
                                onGenresSelected(newList)
                            },
                            label = { Text(genre) },
                            leadingIcon = if (isSelected) {
                                { Icon(Icons.Default.Done, null, Modifier.size(FilterChipDefaults.IconSize)) }
                            } else null
                        )
                    }
                }
            }
        }
    }
}