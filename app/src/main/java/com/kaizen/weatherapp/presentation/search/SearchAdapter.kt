package com.kaizen.weatherapp.presentation.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import com.kaizen.core.bases.BaseListAdapter
import com.kaizen.core.bases.BaseViewHolder
import com.kaizen.weatherapp.R
import com.kaizen.weatherapp.databinding.ItemSearchBinding
import com.kaizen.weatherapp.domain.search.model.SearchWeather

class SearchAdapter : BaseListAdapter<BaseViewHolder<SearchWeather>, SearchWeather>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<ItemSearchBinding>(
            inflater, R.layout.item_search, parent, false
        )
        return SearchViewHolder(view)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<SearchWeather>, position: Int) {
        holder.bind(getItem(position), position, getOnItemClickListener())
    }

    companion object {

        val DIFF_CALLBACK: DiffUtil.ItemCallback<SearchWeather> =
            object : DiffUtil.ItemCallback<SearchWeather>() {
                override fun areContentsTheSame(
                    oldItem: SearchWeather,
                    newItem: SearchWeather
                ): Boolean {
                    return oldItem.city == newItem.city
                }

                override fun areItemsTheSame(
                    oldItem: SearchWeather,
                    newItem: SearchWeather
                ): Boolean {
                    return oldItem.city == newItem.city
                }
            }
    }
}