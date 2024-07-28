package com.kaizen.weatherapp.presentation.home

import android.view.View
import com.kaizen.core.bases.BaseViewHolder
import com.kaizen.weatherapp.databinding.ItemHourlyBinding
import com.kaizen.weatherapp.domain.home.model.Weather

class HourlyViewHolder(private val item: ItemHourlyBinding) : BaseViewHolder<Weather.Hourly>(item) {

    override fun bind(
        model: Weather.Hourly, position: Int, clickListener: ((view: View, model: Weather.Hourly, position: Int) -> Unit)?
    ) {
        item.hourly = model
    }
}