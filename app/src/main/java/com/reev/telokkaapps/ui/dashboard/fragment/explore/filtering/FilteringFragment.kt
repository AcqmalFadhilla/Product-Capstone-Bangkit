package com.reev.telokkaapps.ui.dashboard.fragment.explore.filtering

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.reev.telokkaapps.R
import com.reev.telokkaapps.databinding.FragmentCollectionBinding
import com.reev.telokkaapps.databinding.FragmentFilteringBinding
import com.reev.telokkaapps.helper.InitialDataSource

class FilteringFragment : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentFilteringBinding

    public var category : String = ""
    public var city : String = ""
    public var orderRating : Boolean = true

    override fun onResume() {
        super.onResume()
        val citiesOptions = InitialDataSource.getCityNames()
        val citiesAdapter = ArrayAdapter(requireContext(), R.layout.item_dropdown_filter, citiesOptions)
        val categoryOptions = InitialDataSource.getTourismCategoryNames()
        val categoryAdapter = ArrayAdapter(requireContext(), R.layout.item_dropdown_filter, categoryOptions)

        binding.apply {
            categoryFilter.setAdapter(categoryAdapter)
            cityFilter.setAdapter(citiesAdapter)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFilteringBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {

            filterConfirmationButton.setOnClickListener {
                Toast.makeText(requireContext(), "Berhasil menerapkan filter", Toast.LENGTH_SHORT).show()

                // Aksi untuk menyimpan kota/kabupaten yang dipilih
                city = cityFilter.toString()

                // Aksi untuk menyimpan kategori yang dipilih
                category = categoryFilter.toString()

                // Aksi untuk menyimpan urutan rating yang dipilih
                val selectedRadioButtonId = radioGroupRating.checkedRadioButtonId
                val isSelectedLowRating = selectedRadioButtonId == R.id.radioButtonLowRating
                if (isSelectedLowRating) {
                    orderRating = false
                }

                dismiss()
            }



        }
    }
}