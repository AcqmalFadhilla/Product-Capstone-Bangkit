package com.reev.telokkaapps.ui.formplanning

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.reev.telokkaapps.R
import com.reev.telokkaapps.databinding.ActivityFormPlanningBinding

class FormPlanningActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFormPlanningBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormPlanningBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_form_planning)
    }
}