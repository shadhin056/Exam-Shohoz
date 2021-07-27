package com.fundinghelp.moniruzzamanshadhinapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.fundinghelp.moniruzzamanshadhinapplication.adapter.MoviesAdapter
import com.fundinghelp.moniruzzamanshadhinapplication.util.GlobalVariable
import com.fundinghelp.moniruzzamanshadhinapplication.view_model.ListViewModel
import com.shadhin.android_jetpack.view.model.MovieModel
import kotlinx.android.synthetic.main.activity_main.*

class MovieListActivity : AppCompatActivity() ,
    MoviesAdapter.adapterListener{
    private lateinit var globalVariable: GlobalVariable
    private var mAdapter: MoviesAdapter? = null
    private lateinit var viewModel: ListViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(ListViewModel::class.java)
        globalVariable = this.applicationContext as GlobalVariable
        viewModel.getFromDB()

        observeViewModel()
        val mLayoutManager = LinearLayoutManager(applicationContext)
        recyclerViewJobs!!.setLayoutManager(mLayoutManager)
        recyclerViewJobs!!.setItemAnimator(DefaultItemAnimator())
    }

    private fun observeViewModel() {
        viewModel.moviesGet.observe(this, androidx.lifecycle.Observer { movies ->
            movies.let {
                //Toast.makeText(getApplication(), "From Local Database "+userss, Toast.LENGTH_LONG).show()
                mAdapter = MoviesAdapter( this,movies,this)
                recyclerViewJobs!!.setAdapter(mAdapter)
                mAdapter?.notifyDataSetChanged();
            }
        })
    }

    override fun onItemSelected(itemSelected: MovieModel?) {
        globalVariable.movie_id= itemSelected!!.movie_id.toString()
        globalVariable.title= itemSelected!!.title.toString()
        globalVariable.year= itemSelected!!.year.toString()
        globalVariable.runtime= itemSelected!!.runtime.toString()
        globalVariable.genres= itemSelected!!.genres.toString()
        globalVariable.director= itemSelected!!.director.toString()
        globalVariable.actors= itemSelected!!.actors.toString()
        globalVariable.plot= itemSelected!!.plot.toString()

        val i = Intent(
            this,
            MovieDetailsActivity::class.java
        )
        startActivity(i)
    }
}