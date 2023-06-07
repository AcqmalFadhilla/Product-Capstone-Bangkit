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
import com.reev.telokkaapps.data.local.database.entity.relation.PlaceAndTourismCategory
import com.reev.telokkaapps.data.source.local.dummy.dummyplace.Place
import com.reev.telokkaapps.databinding.ActivityFormPlanningBinding
import com.reev.telokkaapps.ui.dashboard.MainActivity
import java.text.SimpleDateFormat
import java.util.*

class FormPlanningActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFormPlanningBinding
    private lateinit var myCalendar: Calendar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormPlanningBinding.inflate(layoutInflater)
        setContentView(binding.root)

        myCalendar = Calendar.getInstance()

        if (savedInstanceState != null) {
            val selectedDate = savedInstanceState.getSerializable(KEY_SELECTED_DATE) as Date?
            if (selectedDate != null) {
                myCalendar.time = selectedDate
                updateLabel(myCalendar)
            }
        }

        val datePicker = DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
            myCalendar.set(Calendar.YEAR, year)
            myCalendar.set(Calendar.MONTH, month)
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            updateLabel(myCalendar)
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

        val place = intent.getParcelableExtra<PlaceAndTourismCategory>("PLACE_EXTRA")
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
                        .load(place.tourismPlace.placePhotoUrl)
                        .placeholder(drawable)
                        .into(placePhotoUrlImageView)

                    placeNameTextView.text = place.tourismPlace.placeName
                    placeCategoryTextView.text = place.category?.categoryName
                }

                itemButton.apply {
                    infoTV.text = "klik tombol konfirmasi jika data sudah sesuai"
                    button1.text = "Konfirmasi"
                    button1.setOnClickListener {
                        val alertDialog = android.app.AlertDialog.Builder(this@FormPlanningActivity)
                            .setTitle("Pastikan data penjadwalan benar")
                            .setMessage("Setelah klik konfirmasi, data akan tersimpan secara permanen")
                            .setPositiveButton("Ya, Konfirmasi Penjadwalan") { _, _ ->
                                Toast.makeText(this@FormPlanningActivity, "Berhasil Membuat Jadwal", Toast.LENGTH_SHORT).show()
                                val intent = Intent(this@FormPlanningActivity, MainActivity::class.java)
                                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                                startActivity(intent)
                                finish()
                            }
                            .setNegativeButton("Edit kembali", null)
                            .create()
                        alertDialog.show()
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

    private fun updateLabel(myCalendar: Calendar) {
        val myFormat = "dd-MM-yyyy"
        val sdf = SimpleDateFormat(myFormat, Locale.UK)
        binding.layoutActivityFormPlanning.planningDateTextView.setText(sdf.format(myCalendar.time))
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putSerializable(KEY_SELECTED_DATE, myCalendar.time)
    }

    companion object {
        private const val KEY_SELECTED_DATE = "selected_date"
    }
}