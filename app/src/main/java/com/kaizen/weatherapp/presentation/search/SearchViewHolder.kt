package com.kaizen.weatherapp.presentation.search

import android.view.View
import com.kaizen.core.bases.BaseViewHolder
import com.kaizen.core.extensions.toViewClickListener
import com.kaizen.weatherapp.databinding.ItemSearchBinding
import com.kaizen.weatherapp.domain.search.model.SearchWeather

class SearchViewHolder(private val item: ItemSearchBinding) : BaseViewHolder<SearchWeather>(item) {

    override fun bind(
        model: SearchWeather, position: Int, clickListener: ((view: View, model: SearchWeather, position: Int) -> Unit)?
    ) {
        item.weather = model
        item.clickListener = clickListener.toViewClickListener(model, position)
    }
}