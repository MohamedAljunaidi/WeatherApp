package com.kaizen.weatherapp.presentation.map

import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.kaizen.core.bases.BaseFragment
import com.kaizen.core.extensions.collectLatest
import com.kaizen.core.extensions.showToast
import com.kaizen.weatherapp.R
import com.kaizen.weatherapp.common.checkLocationPermission
import com.kaizen.weatherapp.common.getLocation
import com.kaizen.weatherapp.databinding.FragmentMapBinding
import com.kaizen.weatherapp.domain.search.model.SearchWeather
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MapFragment : BaseFragment<FragmentMapBinding, MapViewModel>(R.layout.fragment_map),
    OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private var latitude: Double = -34.0
    private var longitude: Double = 151.0

    private lateinit var requestPermissionLauncher: ActivityResultLauncher<String>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(requireContext())
        requestPermissionLauncher = registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) { isGranted: Boolean ->
            if (isGranted) {
                getLocation(fusedLocationClient) { latitude, longitude ->
                    this.latitude = latitude
                    this.longitude = longitude
                    viewModel.searchWeather("$latitude,$longitude")
                }
            }
        }
        getMyLocation()
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initMap()
        collectLatest(viewModel.searchSuccess, ::handleSearchSuccess)
        collectLatest(viewModel.addToFavouriteSuccess, ::handleAddToFavouriteSuccess)
        collectLatest(viewModel.state, ::handleViewState)
        handleScreenClick()
    }

    private fun initMap() {
        val mapFragment = childFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    private fun handleScreenClick() {
        viewBinding?.searchEditText?.setOnEditorActionListener(TextView.OnEditorActionListener { textview, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                viewModel.searchWeather(textview.text.toString())
                return@OnEditorActionListener true
            }
            false
        })

        viewBinding?.imageClose?.setOnClickListener {
            viewBinding?.cardWeatherInfo?.isVisible = false
        }
        viewBinding?.imageMyLocation?.setOnClickListener {
            getMyLocation()
        }
        viewBinding?.imageBack?.setOnClickListener {
            findNavController().popBackStack()
        }

    }

    private fun handleSearchSuccess(weather: List<SearchWeather>?) {
        if (!weather.isNullOrEmpty()) {
            viewBinding?.weather = weather[0]
            viewBinding?.buttonAddToFavourite?.setOnClickListener {
                viewModel.addToFavourite(weather[0])
            }

            viewBinding?.cardWeatherInfo?.isVisible = true

            latitude = weather[0].latitude.toDouble()
            longitude = weather[0].longitude.toDouble()
            setLocationOnMap()
        } else {
            requireContext().showToast(requireContext().getString(R.string.city_not_found))
        }
    }

    private fun handleAddToFavouriteSuccess(success: Boolean?) {
        requireContext().showToast(requireContext().getString(R.string.added_to_favourite))
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        setLocationOnMap()
    }

    private fun setLocationOnMap() {
        if (::mMap.isInitialized) {
            val location = LatLng(latitude, longitude)
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(location, 15f))
        }
    }

    private fun getMyLocation() {
        checkLocationPermission(
            requestPermissionLauncher, fusedLocationClient
        ) { latitude, longitude ->
            this.latitude = latitude
            this.longitude = longitude
            viewModel.searchWeather("$latitude,$longitude")
        }

    }
}