package com.reev.telokkaapps.ui.dashboard.fragment.home.minimap

import androidx.fragment.app.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.reev.telokkaapps.R
import com.reev.telokkaapps.databinding.FragmentMinimapBinding

class MinimapFragment : Fragment() {
    private var _binding: FragmentMinimapBinding? = null
    private val binding get() = _binding!!

    private val callback = OnMapReadyCallback { googleMap ->
        val indonesiaLatLng = LatLng(-2.5489, 118.0149)
        googleMap.addMarker(
            MarkerOptions()
                .position(indonesiaLatLng)
                .title("Indonesia"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(indonesiaLatLng, 5f))
     }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentMinimapBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)
    }

    fun updateMapLocation(latitude: Double, longitude: Double) {
        val googleMap = (childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?)?.getMapAsync { googleMap ->
            val userLocationUpdate = LatLng(latitude, longitude)
            googleMap.clear() // Menghapus marker sebelumnya (jika ada)
            googleMap.addMarker(
                MarkerOptions()
                    .position(userLocationUpdate)
                    .title("Lokasi Anda")
            )
            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(userLocationUpdate, 5f))
        }
    }
}