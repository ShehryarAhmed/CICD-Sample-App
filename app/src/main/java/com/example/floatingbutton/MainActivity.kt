package com.example.floatingbutton

import android.graphics.Point
import android.graphics.Rect
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.view.animation.Animation
import android.widget.ImageView
import android.widget.RelativeLayout
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {

    lateinit var relativeLayout: MovableFloatingActionButton
    lateinit var imageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        relativeLayout = findViewById(R.id.moveBtn)
        imageView = findViewById(R.id.delete)
        showLog("onCreate")
        val centerDeleteBtnXAxis = imageView.x + imageView.width/2
        val centerFloatingBtnXAxis = relativeLayout.x + relativeLayout.width/2
        Log.d("Center1A","$centerDeleteBtnXAxis")
        Log.d("Center2A","$centerFloatingBtnXAxis")

        var isAnimating = false
        relativeLayout.setInterface(object : CallbackZapp {
            override fun onmove() {
                if(!isAnimating){
                    AnimationUtil.loadFadeInAnimation(imageView,object : Animation.AnimationListener{
                        override fun onAnimationStart(p0: Animation?) {
                            isAnimating = true
                        }

                        override fun onAnimationEnd(p0: Animation?) {
                        }

                        override fun onAnimationRepeat(p0: Animation?) {

                        }
                    })
                }
            }

            override fun onStop() {
                isAnimating = false
                val centerDeleteBtnXAxis = imageView.x + imageView.width/2
                val centerDeleteBtnYAxis = imageView.y + imageView.height/2

                val centerFloatingBtnXAxis = relativeLayout.x + relativeLayout.width/2
                val centerFloatingBtnYAxis = relativeLayout.y + relativeLayout.height/2

                val distanceXAxis =  centerFloatingBtnXAxis - centerDeleteBtnXAxis
                val distanceYAxis = centerFloatingBtnYAxis - centerDeleteBtnYAxis

//                Log.d("Center1","$centerDeleteBtnXAxis")
//                Log.d("Center2","$centerFloatingBtnXAxis")
//
                Log.d("DistanceX","$distanceXAxis")
                Log.d("DistanceY","$distanceYAxis")

                if(distanceXAxis <= 50 && distanceXAxis >= -50 && distanceYAxis <= 50 && distanceYAxis >= -50){
                    AnimationUtil.loadScaleDownAnimation(imageView,object : Animation.AnimationListener{
                        override fun onAnimationStart(p0: Animation?) {

                        }

                        override fun onAnimationEnd(p0: Animation?) {
                            imageView.visibility = View.GONE
                            relativeLayout.visibility = View.GONE

                        }

                        override fun onAnimationRepeat(p0: Animation?) {

                        }

                    })
                }else{
                    imageView.visibility = View.GONE
                }

            }

        })

        val location = IntArray(2)

        setFragment(BlankFragment());
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        showLog("onResumeFragments")
    }

    override fun onStart() {
        super.onStart()
        showLog("onStart")
    }

    override fun onStop() {
        super.onStop()
        showLog("onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        showLog("onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        showLog("onRestart")
    }


    override fun onResume() {
        super.onResume()
        showLog("onResume")
    }

    override fun onPause() {
        super.onPause()
        showLog("onPause")
    }


    fun setFragment(fragment: Fragment) {
        val fragmentManager: FragmentManager = supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment, fragment)
        fragmentTransaction.commit()
    }

    private fun showLog(str: String) {
        Log.d("LogActivity", str)
    }

}

fun View.getLocationOnScreen(): Point
{
    val location = IntArray(2)
    this.getLocationOnScreen(location)
    return Point(location[0],location[1])
}


interface CallbackZapp {
    fun onmove()
    fun onStop()

}

