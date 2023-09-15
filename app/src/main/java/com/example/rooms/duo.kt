package com.example.rooms



import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query


@Dao
interface MovieDao {
    @Insert
    suspend fun insert(movie: Movie): Long

    @Query("SELECT * FROM movie")
    suspend fun getAllMovies(): List<Movie>
}

@Dao
interface ActorDao {
    @Insert
    suspend fun insert(actor: Actor): Long

    @Query("SELECT * FROM actor WHERE movieId = :movieId")
    suspend fun getActorsForMovie(movieId: Int): List<Actor>
}
