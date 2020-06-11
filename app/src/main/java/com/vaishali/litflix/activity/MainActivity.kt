package com.vaishali.litflix.activity

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.graphics.Paint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.vaishali.litflix.R
import com.vaishali.litflix.adapter.AdapterClass
import com.vaishali.litflix.adapter.TopRatedAdapter
import com.vaishali.litflix.adapter.TrendingAdapter
import com.vaishali.litflix.module.Movies
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView1:RecyclerView
    lateinit var recyclerView2: RecyclerView
    lateinit var recyclerView3: RecyclerView
    lateinit var adapterRecyler1:AdapterClass
    lateinit var topRatedRecyclerView: TopRatedAdapter
    lateinit var trendingAdapter: TrendingAdapter
    lateinit var layoutManager1: RecyclerView.LayoutManager
    lateinit var layoutManager2: RecyclerView.LayoutManager
    lateinit var layoutManager3:RecyclerView.LayoutManager
    lateinit var imgMainMovie:ImageView
    lateinit var txtMainMovie:TextView
    lateinit var txt1:TextView
    lateinit var txt2:TextView
    lateinit var txt3:TextView
    lateinit var toolbar: Toolbar
    var movies_list= arrayListOf<Movies>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView1=findViewById(R.id.recyclerView1)
        recyclerView2=findViewById(R.id.recyclerView2)
        recyclerView3=findViewById(R.id.recyclerView3)
        imgMainMovie=findViewById(R.id.imgMainMovie)
        txtMainMovie=findViewById(R.id.txtMainMovie)
        toolbar=findViewById(R.id.toolbar)
        txt1=findViewById(R.id.txt1)
        txt2=findViewById(R.id.txt2)
        txt3=findViewById(R.id.txt3)
        setUpToolbar()
        layoutManager1=LinearLayoutManager(
            this@MainActivity,
            LinearLayoutManager.HORIZONTAL,
            false
        )
        layoutManager2=LinearLayoutManager(
            this@MainActivity,
            LinearLayoutManager.HORIZONTAL,
            false
        )
        layoutManager3=LinearLayoutManager(
            this@MainActivity,
            LinearLayoutManager.HORIZONTAL,
            false
        )
        movies_list= arrayListOf(Movies(R.drawable.movies1,"2.0"),
            Movies(R.drawable.movies2,"Sergio"), Movies
        (R.drawable.movies3,"Extraction"), Movies
        (R.drawable.movies5,"Escape Room"),Movies(
                R.drawable.movies6,"The Two Popes"), Movies
                (R.drawable.movies7,"Avengers EndGame"), Movies(
                R.drawable.movies9,"Moana")

        )
        val mainMovie=getRandomMovie(movies_list)
        imgMainMovie.setImageResource(mainMovie.mov_image)
        imgMainMovie.setOnClickListener {
            val intent= Intent(this@MainActivity,MovieActivity::class.java)
            startActivity(intent)
        }
        txtMainMovie.text=mainMovie.txt_movie
        txtMainMovie.underline()
        txt1.underline()
        txt2.underline()
        txt3.underline()
        txtMainMovie.setOnClickListener {
            val intent= Intent(this@MainActivity,MovieActivity::class.java)
            startActivity(intent)
        }
        if(!movies_list.isNullOrEmpty()){
            adapterRecyler1=AdapterClass(this@MainActivity,movies_list)
            recyclerView1.adapter=adapterRecyler1
            recyclerView1.layoutManager=layoutManager1

            topRatedRecyclerView=TopRatedAdapter(this@MainActivity,movies_list)
            recyclerView2.adapter=topRatedRecyclerView
            recyclerView2.layoutManager=layoutManager2

            trendingAdapter= TrendingAdapter(this@MainActivity,movies_list)
            recyclerView3.adapter=trendingAdapter
            recyclerView3.layoutManager=layoutManager3

        }

    }
    fun getRandomMovie(movies_list:List<Movies>):Movies{
        val randomMovie= Random.nextInt(movies_list.size)
        return movies_list[randomMovie]
    }
    fun TextView.underline(){
        paintFlags=paintFlags or Paint.UNDERLINE_TEXT_FLAG
    }
    fun setUpToolbar(){
        setSupportActionBar(toolbar)
        supportActionBar?.title="LitFlix"
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }

    override fun onBackPressed() {
        val dialoug = AlertDialog.Builder(this@MainActivity)
        dialoug.setTitle("Exit ")
        dialoug.setMessage("Are you sure?")
        dialoug.setPositiveButton("Exit", DialogInterface.OnClickListener { dialog, which ->
            finishAffinity()
        })

        dialoug.setNegativeButton("No", DialogInterface.OnClickListener { dialog, which ->
            dialog.cancel()
        })
        dialoug.create()
        dialoug.show()
    }

}
