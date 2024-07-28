package com.kaizen.weatherapp.presentation.favourite

import android.view.View
import com.kaizen.core.bases.BaseViewHolder
import com.kaizen.core.extensions.toViewClickListener
import com.kaizen.weatherapp.databinding.ItemFavouriteBinding
import com.kaizen.weatherapp.databinding.ItemSearchBinding
import com.kaizen.weatherapp.domain.home.model.Weather
import com.kaizen.weatherapp.domain.search.model.SearchWeather

class FavouriteViewHolder(private val item: ItemFavouriteBinding) : BaseViewHolder<SearchWeather>(item) {

    override fun bind(
        model: SearchWeather, position: Int, clickListener: ((view: View, model: SearchWeather, position: Int) -> Unit)?
    ) {
        item.weather = model

    }
}