package com.abjt.materialdialogdemo.base

import android.view.View

fun View.gone() {
    this.visibility = View.GONE
}

fun View.show() {
    this.visibility = View.VISIBLE
}

fun View.isShowGone(isShow: Boolean) {
    this.visibility = if (isShow) View.VISIBLE else View.GONE
}