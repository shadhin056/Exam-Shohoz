package com.shadhin.android_jetpack.view.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(MovieModel::class), version = 3)
abstract class MovieDatabase : RoomDatabase() {
    abstract fun dogDao(): MovieDataDao

    companion object {
        @Volatile
        private var instance: MovieDatabase? = null
        private val LOCK = Any()
        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also {
                instance = it
            }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            MovieDatabase::class.java,
            "moviedatabase"
        ).build()
    }
}