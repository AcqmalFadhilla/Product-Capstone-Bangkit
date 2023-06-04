package com.reev.telokkaapps.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.reev.telokkaapps.R
import com.reev.telokkaapps.data.source.local.dummy.dummyplace.Place
import com.reev.telokkaapps.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

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
                    }
                }

                itemButton.apply {
                    infoTV.text = "klik tombol dibawah jika ingin mengatur jadwal"
                    button1.text = "Buat jadwal ke lokasi ini"
                    button1.setOnClickListener {
                        Toast.makeText(this@DetailActivity, "Buat jadwal", Toast.LENGTH_SHORT).show()

                    }
                }
            }
        }
    }
}