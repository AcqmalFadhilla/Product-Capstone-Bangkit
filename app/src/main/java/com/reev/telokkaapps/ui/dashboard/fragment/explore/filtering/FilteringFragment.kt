package com.reev.telokkaapps.ui.dashboard.fragment.explore.filtering

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.reev.telokkaapps.R
import com.reev.telokkaapps.databinding.FragmentCollectionBinding
import com.reev.telokkaapps.databinding.FragmentFilteringBinding

class FilteringFragment : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentFilteringBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFilteringBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.filterConfirmationButton.setOnClickListener {
            Toast.makeText(requireContext(), "Berhasil menerapkan filter", Toast.LENGTH_SHORT).show()
        }
    }
}