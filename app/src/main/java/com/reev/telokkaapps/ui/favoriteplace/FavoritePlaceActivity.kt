package com.reev.telokkaapps.ui.favoriteplace

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.reev.telokkaapps.databinding.ActivityFavoritePlaceBinding

class FavoritePlaceActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFavoritePlaceBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavoritePlaceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Menampilkan tombol kembali di action bar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // untuk item list
        binding.listPlanningLayout.sectionTitle.text = "Jadwal Kegiatan Wisata Anda"

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressed() // Menangani kembali ketika tombol kembali di action bar ditekan
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}