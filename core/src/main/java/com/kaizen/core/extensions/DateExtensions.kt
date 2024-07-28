package com.kaizen.core.extensions

import java.text.SimpleDateFormat
import java.util.*

fun Int.convertToReadableTime(): String {
    val militaryTime = String.format("%04d", this)
    val hourPart = militaryTime.substring(0, 2).toInt()
    val minutePart = militaryTime.substring(2, 4).toInt()

    val calendar = Calendar.getInstance()
    calendar.set(Calendar.HOUR_OF_DAY, hourPart)
    calendar.set(Calendar.MINUTE, minutePart)

    val format = SimpleDateFormat("h:mm a", Locale.getDefault())
    return format.format(calendar.time)
}