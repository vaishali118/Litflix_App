package com.vaishali.litflix.activity

import android.content.Context
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import android.widget.Toast

internal open class OnSwipeTouchListener(context: Context?): View.OnTouchListener {
    private val gestureDetector:GestureDetector
   init{
        gestureDetector=GestureDetector(context,GestureListener())
    }
    override fun onTouch(v: View?, event: MotionEvent?): Boolean {
        return gestureDetector.onTouchEvent(event)
    }
    private open inner class GestureListener:GestureDetector.SimpleOnGestureListener()
    {
        private  val SWIPE_THRESHOLD:Int=100
        private  val SWIPE_VELOCITY:Int=100
        override fun onDown(e: MotionEvent?): Boolean {
            return true
        }

        override fun onFling(
            e1: MotionEvent,
            e2: MotionEvent,
            velocityX: Float,
            velocityY: Float
        ): Boolean {
            try{
                val diffY:Float= e2.getY().minus(e1.getY())
                val diffX:Float=e2.getX()-e1.getX()
                if(Math.abs(diffX)>Math.abs(diffY))
                {
                    if(Math.abs(diffX)>SWIPE_THRESHOLD&&Math.abs(velocityX)>SWIPE_VELOCITY){
                        if(diffX>0) onSwipeRight();
                        else {}
                    }
                }

            }catch(e:Exception){ e.printStackTrace()}
            return false
        }

    }
    open fun onSwipeRight(){}
}