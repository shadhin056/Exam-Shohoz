package com.fundinghelp.moniruzzamanshadhinapplication.view_model

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.shadhin.android_jetpack.view.model.MovieDatabase
import com.shadhin.android_jetpack.view.model.MovieModel
import com.shadhin.android_jetpack.view.view_model.BaseViewModel
import kotlinx.coroutines.launch

class ListViewModel(application: Application) : BaseViewModel(application) {
    val users = MutableLiveData<List<MovieModel>>()

    fun getFromDB() {

        launch {
            val dogss = MovieDatabase(getApplication()).dogDao().getAllMovie()
            users.value=dogss
            Toast.makeText(getApplication(), "From Database", Toast.LENGTH_LONG).show()
        }

    }
    override fun onCleared() {
        super.onCleared()
        //disposable.clear()
    }
}
