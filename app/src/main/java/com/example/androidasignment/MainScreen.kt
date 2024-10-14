package com.example.androidasignment

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidasignment.model.Manga

@Composable
fun MainScreen(mangaList: List<Manga>, onDetail: (String, String, Int) -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize().padding(top = 16.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = null,
            modifier = Modifier
                .size(100.dp)
                .align(Alignment.CenterHorizontally)
        )
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 16.dp, end = 16.dp, bottom = 26.dp)
        ) {
            items(mangaList) { manga ->
                MangaItem(manga = manga) {
                    onDetail(
                        manga.title,
                        manga.description,
                        manga.coverResId
                    )
                }
            }
        }
    }
}

@Composable
fun MangaItem(manga: Manga, next: () -> Unit) {
    Column(
        modifier = Modifier.padding(top = 20.dp)
    ) {
        Card(
            onClick = { next() },
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        ) {
            Image(
                painter = painterResource(id = manga.coverResId),
                contentDescription = null,
                modifier = Modifier
                    .size(300.dp)
                    .height(150.dp)
                    .align(Alignment.CenterHorizontally)
            )
            Text(
                text = manga.title,
                fontSize = 20.sp,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 16.dp, end = 10.dp, bottom = 20.dp)
            )
        }
    }
}




