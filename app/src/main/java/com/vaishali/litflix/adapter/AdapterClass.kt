package com.vaishali.litflix.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.vaishali.litflix.R
import com.vaishali.litflix.activity.MovieActivity
import com.vaishali.litflix.module.Movies
import kotlinx.android.synthetic.main.movie_single_view.view.*
import java.util.Date.from

class AdapterClass(val context: Context,val itemList:List<Movies>):RecyclerView.Adapter<AdapterClass.AdapterClassView>() {
    class AdapterClassView(view: View):RecyclerView.ViewHolder(view)
    {
         val imgMovie:ImageView=view.findViewById(R.id.imgMovie)
         val txtMovieName:TextView=view.findViewById(R.id.txtMovieName)
        val cardLayout:CardView=view.findViewById(R.id.cardLayout)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterClassView {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.movie_single_view,parent,false)
        return AdapterClassView(view)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: AdapterClassView, position: Int) {
        val movie=itemList[position]
        holder.imgMovie.setImageResource(movie.mov_image)
        holder.txtMovieName.text=movie.txt_movie
        holder.cardLayout.setOnClickListener {
            val intent= Intent(context,MovieActivity::class.java)
            context.startActivity(intent)
        }
    }
}