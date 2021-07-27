package com.shadhin.android_jetpack.view.view_model

import android.app.Application
import com.shadhin.android_jetpack.view.model.MovieDatabase
import com.shadhin.android_jetpack.view.model.MovieModel
import kotlinx.coroutines.launch


class LDBViewModel(application: Application) : BaseViewModel(application) {

    override fun onCleared() {
        super.onCleared()
       // disposable.clear()
    }

    fun storeMoviesLocally(movie: MovieModel) {
        launch {
            val obj = MovieDatabase(getApplication()).dogDao()
            obj.insertAll(movie)
        }
    }

}
