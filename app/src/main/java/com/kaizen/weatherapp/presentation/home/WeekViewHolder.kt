package com.kaizen.weatherapp.presentation.home

import android.view.View
import com.kaizen.core.bases.BaseViewHolder
import com.kaizen.weatherapp.databinding.ItemWeekBinding
import com.kaizen.weatherapp.domain.home.model.Weather

class WeekViewHolder(private val item: ItemWeekBinding) : BaseViewHolder<Weather.WeekWeather>(item) {

    override fun bind(
        model: Weather.WeekWeather, position: Int, clickListener: ((view: View, model: Weather.WeekWeather, position: Int) -> Unit)?
    ) {
        item.week = model
    }
}