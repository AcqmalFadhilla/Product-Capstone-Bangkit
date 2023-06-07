package com.reev.telokkaapps.ui.detailplanning

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.AlphaAnimation
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.reev.telokkaapps.R
import com.reev.telokkaapps.data.source.local.dummy.dummyplanning.PlanningPlace
import com.reev.telokkaapps.databinding.ActivityDetailPlanningBinding
import com.reev.telokkaapps.ui.formplanning.FormPlanningActivity

class DetailPlanningActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailPlanningBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailPlanningBinding.inflate(layoutInflater)
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

        // get data planning
        val planningPlace = intent.getParcelableExtra<PlanningPlace>("PLANNING_EXTRA")
        if (planningPlace != null) {
            binding.apply {
                layoutActivityDetailPlanning.apply{
                    val color = ContextCompat.getColor(binding.root.context, R.color.blue_200)
                    val drawable = CircularProgressDrawable(binding.root.context)
                    drawable.strokeWidth = 10f
                    drawable.centerRadius = 50f
                    drawable.setColorSchemeColors(color)
                    drawable.start()
                    Glide.with(this@DetailPlanningActivity)
                        .load(planningPlace.place.placePhotoUrl)
                        .placeholder(drawable)
                        .into(placePhotoUrlImageView)

                    nameTextView.text = planningPlace.place.placeName
                    categoryTextView.text = planningPlace.place.placeCategory

                    //untuk rating
                    val rating = planningPlace.place.placeRating.toString()
                    val ratingCount = planningPlace.place.placeRatingCount.toString()
                    ratingTextView.text = "$rating ($ratingCount)"

                    tagsTextView.text = planningPlace.place.placeTags
                    addressTextView.text = planningPlace.place.placeAddress
                    websiteTextView.text = planningPlace.place.placeWebsite
                    phoneTextView.text = planningPlace.place.placePhone
                    descriptionTextView.text = planningPlace.place.placeDescription

                    openMapButton.setOnClickListener {
                        Toast.makeText(this@DetailPlanningActivity, "Buka Map", Toast.LENGTH_SHORT).show()

                        val mapUrl = planningPlace.place.placeMapUrl

                        val intent = Intent(Intent.ACTION_VIEW)
                        intent.data = Uri.parse(mapUrl)
                        startActivity(intent)
                    }
                }

                itemButton.apply {
                    infoTV.text = "klik tombol dibawah jika ingin mengakhiri wisata"
                    button1.isGone = true
                    button2.isVisible = true
                    button2.text = "Akhiri Kegiatan Wisata"
                    button2.setOnClickListener {
                        val alertDialog = android.app.AlertDialog.Builder(this@DetailPlanningActivity)
                            .setTitle("Yakin untuk mengakhiri wisata?")
                            .setMessage("Data akan dihapuskan setelah anda mengakhiri wisata")
                            .setPositiveButton("Ya, Akhiri wisata") { _, _ ->
                                Toast.makeText(this@DetailPlanningActivity, "Akhiri Wisata berhasi", Toast.LENGTH_SHORT).show()
                                //buat aksi disini
                                finish()
                            }
                            .setNegativeButton("batalkan", null)
                            .create()
                        alertDialog.show()
                    }
                }
            }
        }
    }
}