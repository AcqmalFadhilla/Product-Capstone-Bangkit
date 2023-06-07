package com.reev.telokkaapps.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.reev.telokkaapps.databinding.ActivitySplashBinding
import com.reev.telokkaapps.ui.categoryzation.CategoryzationActivity
import com.reev.telokkaapps.ui.dashboard.MainActivity

class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        hideActBar()

        splashScreenHandler()
    }

    private fun hideActBar() {
        supportActionBar?.hide()
    }

    private fun splashScreenHandler() {
//        if() { //buat if untuk mengecek apakah user sudah mementukan kategorisasinya
//            val intent = Intent(this, MainActivity::class.java)
//            navigate(intent)
//        } else {
            val intent = Intent(this, CategoryzationActivity::class.java)
            navigate(intent)
//        }
    }

    private fun navigate(intent: Intent) {
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(intent)
            finish()
        }, SPLASH_DELAY)
    }

    companion object {
        private const val SPLASH_DELAY = 3000L
    }
}