package com.example.newprojects

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.newprojects.databinding.ActivitySplashScreenBinding

class SplashScreen : AppCompatActivity() {

    lateinit var splashScreenBinding: ActivitySplashScreenBinding
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            enableEdgeToEdge()

            splashScreenBinding = ActivitySplashScreenBinding.inflate(layoutInflater)
            setContentView(splashScreenBinding.root)

            splashScreenBinding.imageid.setImageResource(R.drawable.dog)

            Handler(Looper.getMainLooper()).postDelayed({
                var intent = Intent(this@SplashScreen,
                    loginActivity::class.java)
                startActivity(intent)
                finish()
            },3000)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}