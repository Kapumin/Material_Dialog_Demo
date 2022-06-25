package com.abjt.materialdialogdemo

import android.view.View

fun View.gone() {
    this.visibility = View.GONE
}

fun View.show() {
    this.visibility = View.VISIBLE
}

fun View.isShowGone(isShow: Boolean) {
    if (isShow) show() else gone()
}

fun View.setOnClick(onViewClicked: () -> Unit) {
    this.setOnClickListener {
        onViewClicked()
    }
}