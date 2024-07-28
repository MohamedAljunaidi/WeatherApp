package com.kaizen.weatherapp.presentation.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import com.kaizen.core.bases.BaseListAdapter
import com.kaizen.core.bases.BaseViewHolder
import com.kaizen.weatherapp.R
import com.kaizen.weatherapp.databinding.ItemHourlyBinding
import com.kaizen.weatherapp.domain.home.model.Weather

class HourlyAdapter : BaseListAdapter<BaseViewHolder<Weather.Hourly>, Weather.Hourly>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HourlyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<ItemHourlyBinding>(
            inflater, R.layout.item_hourly, parent, false
        )
        return HourlyViewHolder(view)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<Weather.Hourly>, position: Int) {
        holder.bind(getItem(position), position, getOnItemClickListener())
    }

    companion object {

        val DIFF_CALLBACK: DiffUtil.ItemCallback<Weather.Hourly> =
            object : DiffUtil.ItemCallback<Weather.Hourly>() {
                override fun areContentsTheSame(
                    oldItem: Weather.Hourly,
                    newItem: Weather.Hourly
                ): Boolean {
                    return oldItem.time == newItem.time
                }

                override fun areItemsTheSame(
                    oldItem: Weather.Hourly,
                    newItem: Weather.Hourly
                ): Boolean {
                    return oldItem.time == newItem.time
                }
            }
    }
}