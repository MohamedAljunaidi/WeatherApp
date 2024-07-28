package com.kaizen.weatherapp.presentation.search

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.TextView.OnEditorActionListener
import androidx.navigation.fragment.findNavController
import com.kaizen.core.bases.BaseFragment
import com.kaizen.core.extensions.collectLatest
import com.kaizen.core.extensions.showToast
import com.kaizen.weatherapp.R
import com.kaizen.weatherapp.databinding.FragmentSearchBinding
import com.kaizen.weatherapp.domain.search.model.SearchWeather
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class SearchFragment :
    BaseFragment<FragmentSearchBinding, SearchViewModel>(R.layout.fragment_search) {
    private val searchAdapter by lazy { SearchAdapter() }

    @SuppressLint("ClickableViewAccessibility")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initDataBinding()
        collectLatest(viewModel.searchSuccess, ::handleSearchSuccess)
        collectLatest(viewModel.addToFavouriteSuccess, ::handleAddToFavouriteSuccess)
        collectLatest(viewModel.state, ::handleViewState)

        viewBinding?.searchEditText?.setOnEditorActionListener(OnEditorActionListener { textview, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                viewModel.searchWeather(textview.text.toString())
                return@OnEditorActionListener true
            }
            false
        })

        searchAdapter.setOnItemClickListener { _, model, _ ->
            viewModel.addToFavourite(model)
        }

        viewBinding?.floatingMap?.setOnClickListener {
            findNavController().navigate(R.id.action_searchFragment_to_mapFragment)
        }
    }

    private fun handleSearchSuccess(weather: List<SearchWeather>?) {
        viewBinding?.weather = weather as ArrayList<SearchWeather>?
    }

    private fun handleAddToFavouriteSuccess(success: Boolean?) {
        requireContext().showToast(requireContext().getString(R.string.added_to_favourite))
    }

    private fun initDataBinding() {
        viewBinding?.searchAdapter = searchAdapter
    }


}