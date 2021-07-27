package com.fundinghelp.moniruzzamanshadhinapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.fundinghelp.moniruzzamanshadhinapplication.adapter.MoviesAdapter
import com.fundinghelp.moniruzzamanshadhinapplication.view_model.ListViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var mAdapter: MoviesAdapter? = null
    private lateinit var viewModel: ListViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(ListViewModel::class.java)
        viewModel.getFromDB()

        observeViewModel()
        val mLayoutManager = LinearLayoutManager(applicationContext)
        recyclerViewJobs!!.setLayoutManager(mLayoutManager)
        recyclerViewJobs!!.setItemAnimator(DefaultItemAnimator())
    }

    private fun observeViewModel() {
        viewModel.moviesGet.observe(this, androidx.lifecycle.Observer { userss ->
            userss.let {
                //Toast.makeText(getApplication(), "From Local Database "+userss, Toast.LENGTH_LONG).show()
                mAdapter = MoviesAdapter( this,userss)
                recyclerViewJobs!!.setAdapter(mAdapter)
                mAdapter?.notifyDataSetChanged();
            }
        })
    }
}