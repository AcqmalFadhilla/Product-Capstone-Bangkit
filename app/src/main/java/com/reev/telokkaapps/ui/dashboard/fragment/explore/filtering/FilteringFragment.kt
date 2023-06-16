package com.reev.telokkaapps.ui.dashboard.fragment.explore.filtering

import android.content.Intent
import android.os.Bundle
import android.util.Log
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

    public var city : String? = null
    public var idCategory : Int? = null
    public var orderRating : Boolean? = null

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

                var listCities = InitialDataSource.getCityNames()
                for (i in 0.. listCities.size - 1){
                    if (listCities[i].equals(cityFilter.text.toString())) city = cityFilter.text.toString()

                }

                // Aksi untuk menyimpan kategori yang dipilih
                var j = 1
                var listCategory = InitialDataSource.getTourismCategoryNames()
                for (i in 0.. listCategory.size - 1){
                    if (listCategory[i].equals(categoryFilter.text.toString())) idCategory = i + 1

                }


                // Aksi untuk menyimpan urutan rating yang dipilih
                val selectedRadioButtonId = radioGroupRating.checkedRadioButtonId

                val isSelectedLowRating = selectedRadioButtonId == R.id.radioButtonLowRating
                val isSelectedHighRating = selectedRadioButtonId == R.id.radioButtonHighRating
                if (isSelectedLowRating) {
                    orderRating = false
                }
                if (isSelectedHighRating) {
                    orderRating = true
                }
                Log.i("dataFilter", "city = $city" )
                Log.i("dataFilter", "categoryId = ${idCategory.toString()}" )
                Log.i("dataFilter", "orderRating = $orderRating")
                dismiss()
            }
        }
    }
}