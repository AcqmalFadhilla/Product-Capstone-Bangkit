package com.reev.telokkaapps.ui.formplanning

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.reev.telokkaapps.R
import com.reev.telokkaapps.data.source.local.dummy.dummyplace.Place
import com.reev.telokkaapps.databinding.ActivityFormPlanningBinding
import com.reev.telokkaapps.ui.dashboard.MainActivity
import java.text.SimpleDateFormat
import java.util.*

class FormPlanningActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFormPlanningBinding
    private var date : String = "date"
    private var title : String = "title"
    private var desc : String = "desc"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormPlanningBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val myCalendar = Calendar.getInstance()
        val datePicker = DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
            myCalendar.set(Calendar.YEAR, year)
            myCalendar.set(Calendar.MONTH, month)
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            updateLable(myCalendar)
        }

        binding.apply {
            layoutActivityFormPlanning.apply {
                selectDateButton.setOnClickListener {
                    val datePickerDialog = DatePickerDialog(
                        this@FormPlanningActivity,
                        datePicker,
                        myCalendar.get(Calendar.YEAR),
                        myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)
                    )
                    // Batasi tanggal maksimum yang dapat dipilih
                    datePickerDialog.datePicker.minDate = System.currentTimeMillis() - 1000

                    datePickerDialog.show()
                }
            }
        }

        val place = intent.getParcelableExtra<Place>("PLACE_EXTRA")
        if (place != null) {
            binding.apply {
                layoutActivityFormPlanning.apply {
                    val color = ContextCompat.getColor(binding.root.context, R.color.blue_200)
                    val drawable = CircularProgressDrawable(binding.root.context)
                    drawable.strokeWidth = 10f
                    drawable.centerRadius = 50f
                    drawable.setColorSchemeColors(color)
                    drawable.start()
                    Glide.with(this@FormPlanningActivity)
                        .load(place.placePhotoUrl)
                        .placeholder(drawable)
                        .into(placePhotoUrlImageView)

                    placeNameTextView.text = place.placeName
                    placeCategoryTextView.text = place.placeCategory
                }

                itemButton.apply {
                    infoTV.text = "klik tombol konfirmasi jika data sudah sesuai"
                    button1.text = "Konfirmasi"
                    button1.setOnClickListener {
                        Toast.makeText(this@FormPlanningActivity, "Berhasil Membuat Jadwal", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this@FormPlanningActivity, MainActivity::class.java)
//                        intent.putExtra("PLACE_EXTRA", place)
                        startActivity(intent)
                    }
                    button2.isVisible = true
                    button2.text = "Batalkan"
                    button2.setOnClickListener {
                        val alertDialog = android.app.AlertDialog.Builder(this@FormPlanningActivity)
                            .setTitle("Yakin untuk membatalkan pembuatan jadwal?")
                            .setMessage("Data sebelumnya akan terhapus jika anda membatalkannya")
                            .setPositiveButton("Ya, batalkan jadwal") { _, _ ->
                                finish()
                            }
                            .setNegativeButton("lanjutkan penjadwalan", null)
                            .create()
                        alertDialog.show()
                    }
                }
            }
        }
    }

    private fun updateLable(myCalendar: Calendar) {
        val myFormat = "dd-MM-yyyy"
        val sdf = SimpleDateFormat(myFormat, Locale.UK)
        binding.layoutActivityFormPlanning.planningDateTextView.setText(sdf.format(myCalendar.time))
    }
}