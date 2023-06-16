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
import com.reev.telokkaapps.data.local.database.model.TourismPlaceDetail
import com.reev.telokkaapps.databinding.ActivityDetailBinding
import com.reev.telokkaapps.helper.InternetConnection
import com.reev.telokkaapps.ui.formplanning.FormPlanningActivity
import com.reev.telokkaapps.utility.Constant
import com.reev.telokkaapps.data.remote.Result

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    private lateinit var viewModel: DetailViewModel

    private var placeId : Int?  = null
    private var dataTourismPlace : TourismPlaceDetail?  = null

    // Untuk Favorite
    private var isFavorite: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

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
                intent.putExtra("PLACE_EXTRA", dataTourismPlace)
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
                            val data = result.data[0]
                            placeId = data.placeId
                            dataTourismPlace = data
                            updateInformation(data)
                            binding.itemButton.button2.isClickable = false
                        }
                        is Result.Error -> {
                            Toast.makeText(this, "Terjadi kesalahan ${result.error}", Toast.LENGTH_LONG).show()
                        }
                    }
                }
            })
        }else{
            viewModel.getDetailTourismPlace(id).observe(this,{list->
                var data = list.get(0)
                dataTourismPlace = data
                updateInformation(data)
            })

        }

    }
    private fun updateInformation(data: TourismPlaceDetail){

        isFavorite = data.isFavoritedPlace

        binding.apply {
            layoutActivityDetail.apply{

                val color = ContextCompat.getColor(binding.root.context, R.color.blue_200)
                val drawable = CircularProgressDrawable(binding.root.context)
                drawable.strokeWidth = 10f
                drawable.centerRadius = 50f
                drawable.setColorSchemeColors(color)
                drawable.start()
                Glide.with(this@DetailActivity)
                    .load(data.placePhotoUrl)
                    .placeholder(drawable)
                    .into(placePhotoUrlImageView)

                placeNameTextView.text = data.placeName
                categoryTextView.text = data.placeCategory
                ratingTextView.text = data.placeRating.toString()
                ratingCountTextView.text = "" // belum difungsikan
                tagsTextView.text = data.placeTags
                addressTextView.text = data.placeAddress
                operationalHourTextView.text = "-" // belum difungsikan
                websiteTextView.text = data.placeWebsite
                phoneTextView.text = data.placePhone
                descriptionTextView.text = data.placeDescription

                openMapButton.setOnClickListener {
                    Toast.makeText(this@DetailActivity, "Buka Map", Toast.LENGTH_SHORT).show()
                    val mapUrl = data.placeMapUrl
                    val intent = Intent(Intent.ACTION_VIEW)
                    intent.data = Uri.parse(mapUrl)
                    startActivity(intent)
                }

                // untuk fungsi favorite
                favoriteColorBtnHandler(isFavorite)
                favoriteButton.setOnClickListener {
                    if (isFavorite){
                        viewModel.updateFavoriteStatusOfTourismPlace(data.placeId, false)
                        Toast.makeText(this@DetailActivity, "Batal menyukai tempat wisata ini", Toast.LENGTH_SHORT).show()

                    }else{
                        viewModel.updateFavoriteStatusOfTourismPlace(data.placeId, true)
                        Toast.makeText(this@DetailActivity, "Menyukai tempat wisata ini", Toast.LENGTH_SHORT).show()
                    }
                    isFavorite = !isFavorite
                    favoriteColorBtnHandler(isFavorite)
                }
            }
        }

    }

    private fun favoriteColorBtnHandler(isFavorite: Boolean? = false) {
        val cardView = binding.layoutActivityDetail.favoriteButton
        if (isFavorite == true) {
            cardView.setCardBackgroundColor(ContextCompat.getColor(this@DetailActivity, R.color.danger_background))
        } else {
            cardView.setCardBackgroundColor(ContextCompat.getColor(this@DetailActivity, R.color.secondary_text_color))
        }
    }

}