package com.shadhin.android_jetpack.view.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface MovieDataDao {
    @Insert
    suspend fun insertAll(vararg dogs: MovieModel): List<Long>

    @Query("SELECT * FROM moviemodel")
    suspend fun getAllMovie(): List<MovieModel>

     @Query("SELECT COUNT(movie_id) FROM moviemodel")
     suspend fun check(): Int

}