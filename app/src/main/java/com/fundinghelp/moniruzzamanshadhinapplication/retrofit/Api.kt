package com.haqueit.question.app.retrofit

import com.fundinghelp.moniruzzamanshadhinapplication.model.ApiDataResponse
import io.reactivex.Single
import retrofit2.http.GET


interface Api {
    //API END POINT
    @GET("erik-sytnyk/movies-list/master/db.json")
    fun requestForResponse(
    ): Single<ApiDataResponse>
}