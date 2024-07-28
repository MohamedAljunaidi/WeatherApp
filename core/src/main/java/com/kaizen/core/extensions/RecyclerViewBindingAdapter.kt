package com.kaizen.core.extensions

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.kaizen.core.R
import java.util.*

val DEFAULT_IMAGE_RES = R.drawable.ic_logo

@BindingAdapter("entry_list")
fun <T> submitRecyclerViewList(recyclerView: RecyclerView, data: T) {
    if (recyclerView.adapter is ListAdapter<*, *>) {
        if (data != null)
            (recyclerView.adapter as ListAdapter<T, *>).submitList(data as List<T>)
    }
}
