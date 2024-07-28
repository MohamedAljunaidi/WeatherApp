package com.kaizen.core.extensions

import android.graphics.Color
import android.os.SystemClock
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle

fun Fragment.menuItems(menuRes: Int, menuItemListener: ((menuItem: MenuItem) -> Unit)? = null) {

    val menuHost: MenuHost = requireActivity()
    menuHost.addMenuProvider(object : MenuProvider {
        override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
            // Add menu items here
            menuInflater.inflate(menuRes, menu)
        }

        override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
            menuItemListener?.invoke(menuItem)
            return false
        }

    }, viewLifecycleOwner, Lifecycle.State.RESUMED)
}

fun AppCompatActivity.initToolbar(
    toolbar: Toolbar,
    backImage: Int = 0,
    isTransparentToolbar: Boolean = false,
    onBackPressed: () -> Unit
) {
   setSupportActionBar(toolbar)
    supportActionBar?.setDisplayShowTitleEnabled(false)
    supportActionBar?.setDisplayHomeAsUpEnabled(true)
    supportActionBar?.setDisplayShowHomeEnabled(true)
    if (backImage != 0)
        supportActionBar?.setHomeAsUpIndicator(backImage)
    if (isTransparentToolbar){
        toolbar.setBackgroundColor(Color.TRANSPARENT)
    }
    toolbar.setNavigationOnClickListener {
            onBackPressed()
    }
}