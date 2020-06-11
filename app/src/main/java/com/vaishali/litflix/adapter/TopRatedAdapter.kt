package com.vaishali.litflix.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.vaishali.litflix.R
import com.vaishali.litflix.activity.MovieActivity
import com.vaishali.litflix.module.Movies

class TopRatedAdapter(val context: Context,val itemList:List<Movies>):RecyclerView.Adapter<TopRatedAdapter.TopRatedViewHolder>() {
    class TopRatedViewHolder(view: View):RecyclerView.ViewHolder(view)
    {
        val imgMovie: ImageView =view.findViewById(R.id.imgMovie)
        val txtMovieName: TextView =view.findViewById(R.id.txtMovieName)
        val cardLayout: CardView =view.findViewById(R.id.cardLayout)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopRatedViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.movie_single_view,parent,false)
        return TopRatedViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: TopRatedViewHolder, position: Int) {
        val movie=itemList[position]
        holder.imgMovie.setImageResource(movie.mov_image)
        holder.txtMovieName.text=movie.txt_movie
        holder.cardLayout.setOnClickListener {
            val intent= Intent(context, MovieActivity::class.java)
            context.startActivity(intent)
        }
    }
}