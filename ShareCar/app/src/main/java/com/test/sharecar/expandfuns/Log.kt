package com.test.sharecar.expandfuns

import android.util.Log

fun String.showLog() {
    Log.w("HeronTest", this)
}

fun Int.showLog() {
    Log.w("HeronTest", this.toString())
}