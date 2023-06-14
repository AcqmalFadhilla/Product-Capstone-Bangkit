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
import com.reev.telokkaapps.data.remote.response.TourismPlaceResponse
import com.reev.telokkaapps.databinding.ActivityDetailBinding
import com.reev.telokkaapps.helper.InternetConnection
import com.reev.telokkaapps.ui.formplanning.FormPlanningActivity
import com.reev.telokkaapps.utility.Constant
import com.reev.telokkaapps.data.remote.Result

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    private lateinit var viewModel: DetailViewModel

    private var placeId : Int?  = null
    private var dataTourismPlaceResponse : TourismPlaceResponse?  = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = DetailViewModel(application)

        val placeId = intent.getIntExtra(Constant.DETAIL_PLACE, 1)

        if (placeId != null) {
            getData(placeId)
        }

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

        binding.itemButton.apply {
            infoTV.text = "klik tombol dibawah jika ingin mengatur jadwal"
            button1.text = "Buat jadwal ke lokasi ini"
            button1.setOnClickListener {
                Toast.makeText(this@DetailActivity, "Buat jadwal", Toast.LENGTH_SHORT).show()
                val intent = Intent(this@DetailActivity, FormPlanningActivity::class.java)
                intent.putExtra("PLACE_EXTRA", dataTourismPlaceResponse)
                startActivity(intent)
            }
        }




    }
    private fun getData(id: Int){
        if (InternetConnection.checkConnection(applicationContext)){
            viewModel.getNewDetailTourismPlace(id).observe(this, { result->
                if (result != null){
                    when(result){
                        is Result.Loading -> {
                            // Tampilan ketika Loading
                            binding.itemButton.button2.isClickable = false
                        }
                        is Result.Success ->{

                                placeId = result.data[0].id
                                dataTourismPlaceResponse = result.data[0]
                                binding.apply {
                                layoutActivityDetail.apply{

                                    val color = ContextCompat.getColor(binding.root.context, R.color.blue_200)
                                    val drawable = CircularProgressDrawable(binding.root.context)
                                    drawable.strokeWidth = 10f
                                    drawable.centerRadius = 50f
                                    drawable.setColorSchemeColors(color)
                                    drawable.start()
                                    Glide.with(this@DetailActivity)
                                        .load(result.data[0].image)
                                        .placeholder(drawable)
                                        .into(placePhotoUrlImageView)

                                    placeNameTextView.text = result.data[0].name
                                    categoryTextView.text = result.data[0].category
                                    ratingTextView.text = result.data[0].rating.toString()
                                    ratingCountTextView.text = "" // belum difungsikan
                                    tagsTextView.text = result.data[0].tags
                                    addressTextView.text = result.data[0].address
                                    operationalHourTextView.text = "-" // belum difungsikan
                                    websiteTextView.text = result.data[0].website
                                    phoneTextView.text = result.data[0].phone
                                    descriptionTextView.text = result.data[0].description

                                    openMapButton.setOnClickListener {
                                        Toast.makeText(this@DetailActivity, "Buka Map", Toast.LENGTH_SHORT).show()

                                    val mapUrl = result.data[0].detailURL

                                    val intent = Intent(Intent.ACTION_VIEW)
                                    intent.data = Uri.parse(mapUrl)
                                    startActivity(intent)
                                    }
                                    favoriteButton.setOnClickListener {
                                        Toast.makeText(this@DetailActivity, "Fitur ini belum dapat digunakan", Toast.LENGTH_SHORT).show()
                                    }
                                }
                            }

                            binding.itemButton.button2.isClickable = false

                        }
                        is Result.Error -> {
                            Toast.makeText(this, "Terjadi kesalahan ${result.error}", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            })
        }

    }

}