package com.vaishali.litflix.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.PixelFormat
import android.media.MediaPlayer
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.Button
import android.widget.RelativeLayout
import android.widget.VideoView
import androidx.appcompat.widget.Toolbar
import com.vaishali.litflix.R

class MovieActivity : AppCompatActivity() {
    lateinit var rlayout:RelativeLayout
    lateinit var toolbar: Toolbar
     lateinit var mediaPlayer:MediaPlayer
    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie)
        rlayout=findViewById(R.id.rlayout)
        toolbar=findViewById(R.id.toolbar)
        window.setFormat(PixelFormat.UNKNOWN)
        setUpToolbar()
        mediaPlayer=MediaPlayer.create(this@MovieActivity,R.raw.samplelitflix)
        mediaPlayer.start()

        //val myUri="andriod:resouse//com.vaishali.litflix/${R.raw.samplelitflix}"
        rlayout.setOnTouchListener(object :OnSwipeTouchListener(this@MovieActivity){
            override fun onSwipeRight() {
                mediaPlayer.stop()
                val intent= Intent(this@MovieActivity,MainActivity::class.java)
                startActivity(intent)
            }
        })


    }
    fun setUpToolbar(){
        setSupportActionBar(toolbar)
        supportActionBar?.title="Litflix"
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }

    override fun onBackPressed() {
        mediaPlayer.run { stop() }
        val intent=Intent(this@MovieActivity,MainActivity::class.java)
        startActivity(intent)

    }


}
