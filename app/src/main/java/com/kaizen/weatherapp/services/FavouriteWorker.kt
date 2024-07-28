package com.kaizen.weatherapp.services

import android.Manifest
import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.kaizen.core.bases.ResultWrapper
import com.kaizen.weatherapp.domain.favourite.usecases.GetFavouriteLocalUseCase
import com.kaizen.weatherapp.domain.search.model.SearchWeather
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import javax.inject.Named

@HiltWorker
class FavouriteWorker @AssistedInject constructor(
    @Assisted context: Context,
    @Assisted params: WorkerParameters,
    @Named("FavouriteUseCase") val weatherDao: GetFavouriteLocalUseCase
) : CoroutineWorker(context, params) {

    override suspend fun doWork(): Result {
        val favoriteWeather = weatherDao()
        favoriteWeather.collect { result ->
            when (result) {
                is ResultWrapper.Success -> {
                    if (hasNotificationPermission()) {
                        sendNotification(result.data)
                    }
                }

                is ResultWrapper.Error -> {

                }

            }

        }

        return Result.success()
    }

    private fun hasNotificationPermission(): Boolean {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            ContextCompat.checkSelfPermission(
                applicationContext,
                Manifest.permission.POST_NOTIFICATIONS
            ) ==
                    PackageManager.PERMISSION_GRANTED
        } else {
            true
        }
    }

    @SuppressLint("MissingPermission")
    private fun sendNotification(weather: List<SearchWeather>?) {
        val notificationManager = NotificationManagerCompat.from(applicationContext)
        val channelId = "weather_channel"

        val channel = NotificationChannel(
            channelId,
            "Weather Notifications",
            NotificationManager.IMPORTANCE_DEFAULT
        )
        notificationManager.createNotificationChannel(channel)
        var content = ""
        weather?.forEachIndexed { index, searchWeather ->
            content += "Location${index + 1}: ${searchWeather.city}, Temperature${index + 1}: ${searchWeather.currentWeatherAverage}\n"
        }
        val notification = NotificationCompat.Builder(applicationContext, channelId)
            .setSmallIcon(com.kaizen.core.R.drawable.ic_logo)
            .setContentTitle("Favorite Weather")
            .setContentText(content)
            .setStyle(NotificationCompat.BigTextStyle().bigText(content))
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .build()

        notificationManager.notify(1, notification)
    }
}
