package com.kaizen.core

import android.content.Context
import android.util.AttributeSet
import com.google.android.material.R
import com.google.android.material.appbar.MaterialToolbar

/**
 * A custom view for the base toolbar style: toolbarStyle
 */
class WeatherToolbar @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : MaterialToolbar(context, attrs, R.attr.toolbarStyle)