package com.example.rooms



import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
@Entity
data class Movie(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val title: String,
    val year: Int,
    val director: String
)





@Entity(foreignKeys = [ForeignKey(
    entity = Movie::class,
    parentColumns = ["id"],
    childColumns = ["movieId"],
    onDelete = ForeignKey.CASCADE)]
)
data class Actor(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val name: String,
    val role: String,
    @ColumnInfo(index = true) val movieId: Int
)
