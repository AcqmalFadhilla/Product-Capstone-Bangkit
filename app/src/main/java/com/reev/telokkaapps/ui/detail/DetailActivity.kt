package com.reev.telokkaapps.ui.detail

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.AlphaAnimation
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.reev.telokkaapps.R
import com.reev.telokkaapps.data.source.local.dummy.dummyplace.Place
import com.reev.telokkaapps.databinding.ActivityDetailBinding
import com.reev.telokkaapps.ui.formplanning.FormPlanningActivity

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // untuk back button
        binding.apply{
            backButton.setOnClickListener {
                finish()
            }
            val fadeDuration = 200 // Durasi animasi fade dalam milidetik
            val fadeInAlpha = 1.0f // Nilai alpha saat fadeIn
            val fadeOutAlpha = 0.0f // Nilai alpha saat fadeOut
            scrollView.viewTreeObserver.addOnScrollChangedListener {
                val scrollY = scrollView.scrollY
                if (scrollY > 0 && backButton.visibility == View.VISIBLE) {
                    val fadeOutAnimation = AlphaAnimation(fadeInAlpha, fadeOutAlpha)
                    fadeOutAnimation.duration = fadeDuration.toLong()
                    backButton.startAnimation(fadeOutAnimation)
                    backButton.visibility = View.INVISIBLE
                } else if (scrollY == 0 && backButton.visibility != View.VISIBLE) {
                    val fadeInAnimation = AlphaAnimation(fadeOutAlpha, fadeInAlpha)
                    fadeInAnimation.duration = fadeDuration.toLong()
                    backButton.startAnimation(fadeInAnimation)
                    backButton.visibility = View.VISIBLE
                }
            }
        }


        val place = intent.getParcelableExtra<Place>("PLACE_EXTRA")
        if (place != null) {
            binding.apply {
                layoutActivityDetail.apply{
                    val color = ContextCompat.getColor(binding.root.context, R.color.blue_200)
                    val drawable = CircularProgressDrawable(binding.root.context)
                    drawable.strokeWidth = 10f
                    drawable.centerRadius = 50f
                    drawable.setColorSchemeColors(color)
                    drawable.start()
                    Glide.with(this@DetailActivity)
                        .load(place.placePhotoUrl)
                        .placeholder(drawable)
                        .into(placePhotoUrlImageView)

                    placeNameTextView.text = place.placeName
                    categoryTextView.text = place.placeCategory
                    ratingTextView.text = place.placeRating.toString()
                    ratingCountTextView.text = place.placeRatingCount.toString()
                    tagsTextView.text = place.placeTags
                    addressTextView.text = place.placeAddress
                    websiteTextView.text = place.placeWebsite
                    phoneTextView.text = place.placePhone
                    descriptionTextView.text = place.placeDescription

                    openMapButton.setOnClickListener {
                        Toast.makeText(this@DetailActivity, "Buka Map", Toast.LENGTH_SHORT).show()

                        val mapUrl = place.placeMapUrl

                        val intent = Intent(Intent.ACTION_VIEW)
                        intent.data = Uri.parse(mapUrl)
                        startActivity(intent)
                    }
                    favoriteButton.setOnClickListener {
                        Toast.makeText(this@DetailActivity, "Fitur ini belum dapat digunakan", Toast.LENGTH_SHORT).show()
                    }
                }

                itemButton.apply {
                    infoTV.text = "klik tombol dibawah jika ingin mengatur jadwal"
                    button1.text = "Buat jadwal ke lokasi ini"
                    button1.setOnClickListener {
                        Toast.makeText(this@DetailActivity, "Buat jadwal", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this@DetailActivity, FormPlanningActivity::class.java)
                        intent.putExtra("PLACE_EXTRA", place)
                        startActivity(intent)
                    }
                }
            }
        }
    }
}