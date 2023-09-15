package com.example.rooms

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.room.Room

class MovieViewModel(application: Application) : AndroidViewModel(application) {
    private val db = Room.databaseBuilder(
        application,
        AppDatabase::class.java, "database-name"
    ).build()

    val allMovies = MutableLiveData<List<Movie>>()

    suspend fun insertMovie(movie: Movie) {
        db.movieDao().insert(movie)
    }

    suspend fun insertActor(actor: Actor) {
        db.actorDao().insert(actor)
    }

    suspend fun fetchAllMovies() {
        allMovies.value = db.movieDao().getAllMovies()
    }

    suspend fun fetchActorsForMovie(movieId: Int): List<Actor> {
        return db.actorDao().getActorsForMovie(movieId)
    }
}
