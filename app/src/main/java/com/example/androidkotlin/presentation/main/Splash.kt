package com.example.androidkotlin.presentation.main

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.androidkotlin.R
import com.example.androidkotlin.presentation.login.MainActivity

class Splash : AppCompatActivity() {
    private val SPLASH_DELAY: Long = 5000
    private var mDelayHandler: Handler? = null
    private var progressBarStatus = 0
    var dummy: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash)
        val img: ImageView = findViewById(R.id.splashImage)
        val slideAnimation = AnimationUtils.loadAnimation(this, R.anim.splash_anim)
        mDelayHandler = Handler()
        img.startAnimation(slideAnimation)
        mDelayHandler!!.postDelayed(mRunnable, SPLASH_DELAY)
    }

    private fun launchMainActivity() {
        var intent = Intent(this, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        startActivity(intent)
        this.finish()
        mDelayHandler!!.removeCallbacks(mRunnable)
    }

    private val mRunnable: Runnable = Runnable {
        Thread(Runnable {
            launchMainActivity()
        }).start()
    }

    override fun onDestroy() {
        if (mDelayHandler != null) {
            mDelayHandler!!.removeCallbacks(mRunnable)
        }
        super.onDestroy()
    }
}
