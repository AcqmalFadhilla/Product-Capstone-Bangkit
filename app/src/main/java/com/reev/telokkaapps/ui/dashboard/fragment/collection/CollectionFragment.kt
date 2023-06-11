package com.reev.telokkaapps.ui.dashboard.fragment.collection

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.reev.telokkaapps.databinding.FragmentCollectionBinding
import com.reev.telokkaapps.ui.aboutus.AboutUsActivity
import com.reev.telokkaapps.ui.detailplanning.DetailPlanningActivity


class CollectionFragment : Fragment() {
    private lateinit var binding: FragmentCollectionBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCollectionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            favoriteBtn.setOnClickListener {
                Toast.makeText(requireContext(), "Favorite belum difungsikan", Toast.LENGTH_SHORT).show()
            }

            settingsBtn.setOnClickListener {
                Toast.makeText(requireContext(), "Setelan belum difungsikan", Toast.LENGTH_SHORT).show()
            }

            aboutUsButton.setOnClickListener {
                Toast.makeText(requireContext(), "Tentang Kami", Toast.LENGTH_SHORT).show()
                val intent = Intent(requireContext(), AboutUsActivity::class.java)
                startActivity(intent)
            }
        }


    }

}