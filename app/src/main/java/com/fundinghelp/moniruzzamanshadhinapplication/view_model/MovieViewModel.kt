package com.fundinghelp.moniruzzamanshadhinapplication.view_model

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fundinghelp.moniruzzamanshadhinapplication.model.ApiDataResponse
import com.haqueit.question.app.retrofit.ApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class MovieViewModel : ViewModel() {

    private val apiService = ApiService()
    private val disposable = CompositeDisposable()

    var movieResponse = MutableLiveData<ApiDataResponse>();
    var response_error = MutableLiveData<Boolean>();

    fun reqForMovies() {
        disposable.add(
            apiService.reqForMovies()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<ApiDataResponse>() {
                    override fun onSuccess(model: ApiDataResponse) {
                        model?.let {
                            movieResponse.value = model
                        }
                    }
                    override fun onError(e: Throwable) {
                        e.printStackTrace()
                        Log.e("XXX", e.toString())
                        response_error.value = true
                    }
                })
        )
    }
    }
