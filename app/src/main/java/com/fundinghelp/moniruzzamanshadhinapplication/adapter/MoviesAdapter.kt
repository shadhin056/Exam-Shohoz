package com.fundinghelp.moniruzzamanshadhinapplication.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.fundinghelp.moniruzzamanshadhinapplication.R
import com.shadhin.android_jetpack.view.model.MovieModel
import kotlinx.android.synthetic.main.row_movie.view.*

class MoviesAdapter(
    private val activity: Activity,
    private val mainRequestList: List<MovieModel>
) :
    RecyclerView.Adapter<MoviesAdapter.MyViewHolder>() {

    private val mainList: List<MovieModel>

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view)

    init {
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MoviesAdapter.MyViewHolder {
        val itemView: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_movie, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(
        holder: MoviesAdapter.MyViewHolder,
        position: Int
    ) {
        val currentItem = mainList[position]

        holder.itemView.txtJobCompanyValue.setText(currentItem.actors)
        holder.itemView.txtJobTitleValue.setText(currentItem.director)
        holder.itemView.txtJobDeadlineValue.setText(currentItem.genres)
        holder.itemView.txtJobRecruitingCompanyProfileValue.setText(currentItem.posterUrl)
        holder.itemView.txtLastDateValue.setText(currentItem.runtime)

        Glide.with(activity).load(currentItem.posterUrl!!.replace(" ","")).into(holder.itemView.ivLogo)

    }

    override fun getItemCount(): Int {
        return try {
            mainList.size
        } catch (e: Exception) {
            0
        }
    }
    init {
        this.mainList = mainRequestList
    }

}