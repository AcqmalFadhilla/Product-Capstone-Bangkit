package com.reev.telokkaapps.ui.dashboard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.reev.telokkaapps.R
import com.reev.telokkaapps.databinding.ActivityMainBinding
import com.reev.telokkaapps.ui.dashboard.fragment.collection.CollectionFragment
import com.reev.telokkaapps.ui.dashboard.fragment.explore.ExploreFragment
import com.reev.telokkaapps.ui.dashboard.fragment.home.HomeFragment
import com.reev.telokkaapps.ui.dashboard.fragment.planning.PlanningFragment
import com.reev.telokkaapps.utility.notification.NotificationUtils

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        HomeFragment()
        supportActionBar?.hide()

        //Buat notifikasi
        NotificationUtils.createNotificationChannel(this)

        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.homeFragment -> replaceFragment(HomeFragment())
                R.id.exploreFragment -> replaceFragment(ExploreFragment())
                R.id.planningFragment -> replaceFragment(PlanningFragment())
                R.id.collectionFragment -> replaceFragment(CollectionFragment())
                else -> {

                }
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainer, fragment)
        fragmentTransaction.commit()
    }
}