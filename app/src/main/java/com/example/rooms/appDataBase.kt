package com.example.rooms
import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Movie::class, Actor::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
    abstract fun actorDao(): ActorDao
}
