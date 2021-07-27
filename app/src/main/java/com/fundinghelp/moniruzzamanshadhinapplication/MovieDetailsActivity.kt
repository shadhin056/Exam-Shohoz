package com.fundinghelp.moniruzzamanshadhinapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.fundinghelp.moniruzzamanshadhinapplication.util.GlobalVariable
import kotlinx.android.synthetic.main.activity_movie_details.*

class MovieDetailsActivity : AppCompatActivity() {
    private lateinit var globalVariable: GlobalVariable
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)

        supportActionBar!!.setDisplayShowHomeEnabled(true)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        globalVariable = this.applicationContext as GlobalVariable
        loadInfo()
    }

    private fun loadInfo() {

        txtId.setText(globalVariable.movie_id)
         txtTitle.setText(globalVariable.title)
         txtYear.setText(globalVariable .year)
         txtRunTime.setText(globalVariable .runtime)
         txtGenres.setText(globalVariable .genres)
         txtDerector.setText(globalVariable .director)
         txtActor.setText(globalVariable .actors)
         txtPlot.setText(globalVariable .plot)

    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home -> {
                val intent: Intent = Intent(this, MovieListActivity::class.java)
                startActivity(intent)
            }
        }

        return super.onOptionsItemSelected(item)
    }
}