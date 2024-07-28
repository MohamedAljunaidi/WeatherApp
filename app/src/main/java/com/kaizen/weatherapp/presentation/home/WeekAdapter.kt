package com.kaizen.weatherapp.presentation.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import com.kaizen.core.bases.BaseListAdapter
import com.kaizen.core.bases.BaseViewHolder
import com.kaizen.weatherapp.R
import com.kaizen.weatherapp.databinding.ItemWeekBinding
import com.kaizen.weatherapp.domain.home.model.Weather

class WeekAdapter : BaseListAdapter<BaseViewHolder<Weather.WeekWeather>, Weather.WeekWeather>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeekViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<ItemWeekBinding>(
            inflater, R.layout.item_week, parent, false
        )
        return WeekViewHolder(view)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<Weather.WeekWeather>, position: Int) {
        holder.bind(getItem(position), position, getOnItemClickListener())
    }

    companion object {

        val DIFF_CALLBACK: DiffUtil.ItemCallback<Weather.WeekWeather> =
            object : DiffUtil.ItemCallback<Weather.WeekWeather>() {
                override fun areContentsTheSame(
                    oldItem: Weather.WeekWeather,
                    newItem: Weather.WeekWeather
                ): Boolean {
                    return oldItem.date == newItem.date
                }

                override fun areItemsTheSame(
                    oldItem: Weather.WeekWeather,
                    newItem: Weather.WeekWeather
                ): Boolean {
                    return oldItem.date == newItem.date
                }
            }
    }
}