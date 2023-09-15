package com.example.rooms

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable


@Composable
fun AppContent(viewModel: MovieViewModel) {
    Column {
        InsertMovieComposable(viewModel)
        InsertActorComposable(viewModel)
        MoviesListComposable(viewModel)
    }
}

class MainActivity : ComponentActivity() {
    private val viewModel: MovieViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppContent(viewModel)
        }
    }
}
