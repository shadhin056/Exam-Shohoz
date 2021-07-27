package com.fundinghelp.moniruzzamanshadhinapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.fundinghelp.moniruzzamanshadhinapplication.adapter.MoviesAdapter
import com.fundinghelp.moniruzzamanshadhinapplication.view_model.ListViewModel
import com.fundinghelp.moniruzzamanshadhinapplication.view_model.MovieViewModel
import com.shadhin.android_jetpack.view.model.MovieModel
import com.shadhin.android_jetpack.view.view_model.LDBViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_splash_screen.*


class SplashScreenActivity : AppCompatActivity() {

    private lateinit var user: MovieModel
    private val SPLASH_TIME_OUT = 9000
    private lateinit var movieViewModel: MovieViewModel
    private lateinit var lDBViewModel: LDBViewModel
    private lateinit var viewModel: ListViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        movieViewModel = ViewModelProvider(this).get(MovieViewModel::class.java)
        lDBViewModel = ViewModelProvider(this).get(LDBViewModel::class.java)
        viewModel = ViewModelProvider(this).get(ListViewModel::class.java)
        viewModel.check()

        observeViewModel()
    }
    private fun requestForMovies() {
        this?.let { it1 -> movieViewModel.reqForMovies() };
    }

    private fun observeViewModel() {

        viewModel.check.observe(this, androidx.lifecycle.Observer { valueCHeck ->
            valueCHeck.let {

                if(it>0){
                    txtGet.text="fetching from Local DB"
                    val i = Intent(
                        this@SplashScreenActivity,
                        MainActivity::class.java
                    )
                    startActivity(i)
                }else{
                    txtGet.text="fetching from API"
                    requestForMovies()
                }
            }
        })
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
                    txtGet.text="fetching from API completed"


                    for (i in 0 until it!!.movies.size) {
                          user = MovieModel(it.movies.get(i).id.toString(), it.movies.get(i).title, it.movies.get(i).year, it.movies.get(i).runtime, it.movies.get(i).director, it.movies.get(i).actors, it.movies.get(i).plot,it.movies.get(i).posterUrl,
                            it.movies.get(i).genres.toString()
                        );
                        lDBViewModel.storeMoviesLocally(user)
                    }

                    val i = Intent(
                        this@SplashScreenActivity,
                        MainActivity::class.java
                    )
                    startActivity(i)

                }
            })
    }
}