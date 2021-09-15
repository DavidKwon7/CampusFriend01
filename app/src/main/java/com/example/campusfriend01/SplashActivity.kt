package com.example.campusfriend01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.campusfriend01.auth.IntroActivity
import com.example.campusfriend01.fragments.HomeFragment
import com.example.campusfriend01.utils.FBAuth
import com.google.firebase.auth.FirebaseAuth

class SplashActivity : AppCompatActivity() {

    val firebaseAuth = FirebaseAuth.getInstance()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        //3초 후 넘어감
        Handler().postDelayed({
            startActivity(Intent(this, IntroActivity::class.java))
            finish()
        }, 3000)


    }
}