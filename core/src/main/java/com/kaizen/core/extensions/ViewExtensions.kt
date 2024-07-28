package com.kaizen.core.extensions

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.PopupMenu

fun Context.showToast(msg: String) =
    Toast.makeText(this, msg, Toast.LENGTH_LONG).show()

