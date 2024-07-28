package com.kaizen.weatherapp.presentation.home

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import androidx.work.Constraints
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.NetworkType
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.material.tabs.TabLayout
import com.kaizen.core.bases.BaseFragment
import com.kaizen.core.extensions.collectLatest
import com.kaizen.weatherapp.R
import com.kaizen.weatherapp.common.registerActivityResult
import com.kaizen.weatherapp.databinding.FragmentHomeBinding
import com.kaizen.weatherapp.domain.home.model.Weather
import com.kaizen.weatherapp.services.FavouriteWorker
import dagger.hilt.android.AndroidEntryPoint
import java.util.concurrent.TimeUnit


@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>(R.layout.fragment_home) {

    private val hourlyAdapter by lazy { HourlyAdapter() }
    private val weekAdapter by lazy { WeekAdapter() }

    private lateinit var fusedLocationClient: FusedLocationProviderClient

    private val requestPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted: Boolean ->
        if (isGranted) {
            setupPeriodicWork()
        }
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(requireContext())
        registerActivityResult(fusedLocationClient) { latitude, longitude ->
            viewModel.getWeatherService(latitude.toString(), longitude.toString())
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        collectLatest(viewModel.weatherSuccess, ::handleGetWeatherSuccess)
        collectLatest(viewModel.state, ::handleViewState)
        initDataBinding()
        onTabSelect()
        checkPostPermission()

    }

    private fun initDataBinding() {
        viewBinding?.hourlyAdapter = hourlyAdapter
        viewBinding?.weekAdapter = weekAdapter
        viewBinding?.showToday = true
    }


    private fun checkPostPermission(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            when {
                ContextCompat.checkSelfPermission(requireActivity(), Manifest.permission.POST_NOTIFICATIONS) ==
                        PackageManager.PERMISSION_GRANTED -> {
                    setupPeriodicWork()
                }
                shouldShowRequestPermissionRationale(Manifest.permission.POST_NOTIFICATIONS) -> {
                }
                else -> {
                    requestPermissionLauncher.launch(Manifest.permission.POST_NOTIFICATIONS)
                }
            }
        } else {
            setupPeriodicWork()
        }
    }
    private fun handleGetWeatherSuccess(weather: Weather?) {
        viewBinding?.weather = weather
    }


    private fun onTabSelect(){
        viewBinding?.tabLayout?.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                tab?.let {
                    val position = tab.position
                    viewBinding?.showToday = position == 0
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }
        })
    }

    private fun setupPeriodicWork() {
        val workRequest = PeriodicWorkRequestBuilder<FavouriteWorker>(20, TimeUnit.MINUTES)
            .setConstraints(
                Constraints.Builder()
                    .setRequiredNetworkType(NetworkType.CONNECTED)
                    .setRequiresBatteryNotLow(true)
                    .build()
            )
            .build()

        WorkManager.getInstance(requireContext()).enqueueUniquePeriodicWork(
            "WeatherWork",
            ExistingPeriodicWorkPolicy.KEEP,
            workRequest
        )
    }
}