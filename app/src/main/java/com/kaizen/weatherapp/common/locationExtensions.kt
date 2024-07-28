package com.kaizen.weatherapp.common

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.google.android.gms.location.FusedLocationProviderClient

fun Fragment.registerActivityResult(
    fusedLocationClient: FusedLocationProviderClient,
    onLocationReceived: (latitude: Double, longitude: Double) -> Unit
) {
    val requestPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted: Boolean ->
        if (isGranted) {
            getLocation(fusedLocationClient, onLocationReceived)
        }
    }
    checkLocationPermission(requestPermissionLauncher,fusedLocationClient,onLocationReceived)
}

fun Fragment.checkLocationPermission(
    requestPermissionLauncher: ActivityResultLauncher<String>,
    fusedLocationClient: FusedLocationProviderClient,
    onLocationReceived: (latitude: Double, longitude: Double) -> Unit
) {
    if (ContextCompat.checkSelfPermission(
            requireContext(),
            Manifest.permission.ACCESS_FINE_LOCATION
        ) != PackageManager.PERMISSION_GRANTED
    ) {
        requestPermissionLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
    } else {
        getLocation(fusedLocationClient, onLocationReceived)
    }
}

@SuppressLint("MissingPermission")
fun getLocation(
    fusedLocationClient: FusedLocationProviderClient,
    onLocationReceived: (latitude: Double, longitude: Double) -> Unit
) {
    fusedLocationClient.lastLocation
        .addOnSuccessListener { location ->
            if (location != null) {
                val latitude = location.latitude
                val longitude = location.longitude
                onLocationReceived(latitude, longitude)
            }
        }
}

