package com.kaizen.weatherapp.presentation.favourite

import android.os.Bundle
import android.view.View
import com.kaizen.core.bases.BaseFragment
import com.kaizen.core.extensions.collectLatest
import com.kaizen.weatherapp.R
import com.kaizen.weatherapp.databinding.FragmentFavouriteBinding
import com.kaizen.weatherapp.domain.search.model.SearchWeather
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class FavouriteFragment : BaseFragment<FragmentFavouriteBinding, FavouriteViewModel>(R.layout.fragment_favourite) {

    private val favouriteAdapter by lazy { FavouriteAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getFavourites()
        initDataBinding()
        collectLatest(viewModel.favouritesSuccess, ::handleFavouriteSuccess)
        collectLatest(viewModel.state, ::handleViewState)
    }

    private fun handleFavouriteSuccess(weather: List<SearchWeather>?) {
        viewBinding?.weather = weather as ArrayList<SearchWeather>?
    }
    private fun initDataBinding() {
        viewBinding?.favouriteAdapter = favouriteAdapter
    }

}