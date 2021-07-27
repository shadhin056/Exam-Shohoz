package com.fundinghelp.moniruzzamanshadhinapplication.view_model

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.shadhin.android_jetpack.view.model.MovieDatabase
import com.shadhin.android_jetpack.view.model.MovieModel
import com.shadhin.android_jetpack.view.view_model.BaseViewModel
import kotlinx.coroutines.launch

class ListViewModel(application: Application) : BaseViewModel(application) {
    val moviesGet = MutableLiveData<List<MovieModel>>()
    val check = MutableLiveData<Int>()

    fun getFromDB() {

        launch {
            val movies = MovieDatabase(getApplication()).dogDao().getAllMovie()
            moviesGet.value=movies
            Toast.makeText(getApplication(), "From Database", Toast.LENGTH_LONG).show()
        }

    }
    fun check() {

        launch {
            val movies = MovieDatabase(getApplication()).dogDao().check()
            check.value=movies
           // Toast.makeText(getApplication(), movies.toString(), Toast.LENGTH_LONG).show()
        }

    }
    override fun onCleared() {
        super.onCleared()
        //disposable.clear()
    }
}
