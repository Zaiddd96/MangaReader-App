package com.example.androidasignment

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.androidasignment.model.MangaData
import com.example.androidasignment.ui.theme.AndroidAsignmentTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidAsignmentTheme {
                MangaApp()
            }
        }
    }
}


@Composable
fun MangaApp() {
    val list = MangaData.mangaList
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "MainScreen") {
        composable("MainScreen") {
            MainScreen(mangaList = list) { title, description, coverResId ->
                navController.navigate("DetailScreen/$title/$description/$coverResId")
            }
        }
        composable("DetailScreen/{title}/{description}/{coverResId}") { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val description = backStackEntry.arguments?.getString("description") ?: ""
            val coverResId = backStackEntry.arguments?.getString("coverResId")?.toInt() ?: R.drawable.ic_launcher_background
            DetailScreen(title, description, coverResId) { navController.navigate("SavedScreen") }
        }
        composable("SavedScreen"){
            SavedScreen()
        }
    }
}



