package com.kaizen.core.extensions

import com.kaizen.core.ProgressDialog

fun ProgressDialog.showProgressDialog(){
    this.show()
}


fun ProgressDialog.hideProgressDialog(){
    this.dismiss()
}

