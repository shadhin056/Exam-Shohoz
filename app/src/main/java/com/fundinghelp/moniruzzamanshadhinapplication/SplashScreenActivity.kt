package com.fundinghelp.moniruzzamanshadhinapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.fundinghelp.moniruzzamanshadhinapplication.view_model.MovieViewModel
import com.shadhin.android_jetpack.view.model.MovieModel
import com.shadhin.android_jetpack.view.view_model.LDBViewModel
import kotlinx.android.synthetic.main.activity_splash_screen.*


class SplashScreenActivity : AppCompatActivity() {

    private val SPLASH_TIME_OUT = 9000
    private lateinit var movieViewModel: MovieViewModel
    private lateinit var lDBViewModel: LDBViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        movieViewModel = ViewModelProvider(this).get(MovieViewModel::class.java)
        lDBViewModel = ViewModelProvider(this).get(LDBViewModel::class.java)

        requestForMovies()
        observeViewModel()
    }
    private fun requestForMovies() {
        this?.let { it1 -> movieViewModel.reqForMovies() };
    }

    private fun observeViewModel() {
        movieViewModel.response_error.observe(this, androidx.lifecycle.Observer {
            it?.let {
                Log.e("XXX", "Error")
                txtGet.text="Error Occurs"
            }
        })
        movieViewModel.movieResponse.observe(
            this,
            androidx.lifecycle.Observer {
                it?.let {
                    txtGet.text="fetching completed"

                    val user = MovieModel(it.movies.get(0).id.toString(), it.movies.get(0).title, it.movies.get(0).year, it.movies.get(0).runtime, it.movies.get(0).director, it.movies.get(0).actors, it.movies.get(0).plot,it.movies.get(0).posterUrl,
                        it.movies.get(0).genres.toString()
                    );
                    lDBViewModel.storeMoviesLocally(user)
                    val i = Intent(
                        this@SplashScreenActivity,
                        MainActivity::class.java
                    )
                    startActivity(i)

                }
            })
    }
}