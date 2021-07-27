package com.shadhin.android_jetpack.view.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MovieModel(

    @ColumnInfo(name = "movie_id")
    val movie_id: String?,

    @ColumnInfo(name = "title")
    val title: String?,

    @ColumnInfo(name = "year")
    val year: String?,

    @ColumnInfo(name = "runtime")
    val runtime: String?,

    @ColumnInfo(name = "director")
    val director: String?,

    @ColumnInfo(name = "actors")
    val actors: String?,

    @ColumnInfo(name = "plot")
    val plot: String?,

    @ColumnInfo(name = "posterUrl")
    val posterUrl: String?,

    @ColumnInfo(name = "genres")
    val genres: String?

) {

    @PrimaryKey(autoGenerate = true)
    var uuid: Int = 0
}
