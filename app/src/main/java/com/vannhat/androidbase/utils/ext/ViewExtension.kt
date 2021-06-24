package com.vannhat.androidbase.utils.ext

import android.content.Context
import android.os.SystemClock
import android.text.InputType
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText

private const val INPUT_TYPE_HIDDEN_PASSWORD =
    InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
private const val INPUT_TYPE_VISIBLE_PASSWORD =
    InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD

fun View.safeClick(blockInMillis: Long = 1000, onClick: (View) -> Unit) {
    var lastClickTime: Long = 0
    this.setOnClickListener {
        if (SystemClock.elapsedRealtime() - lastClickTime < blockInMillis) return@setOnClickListener
        lastClickTime = SystemClock.elapsedRealtime()
        onClick(this)
    }
}

fun View.visible() {
    this.visibility = View.VISIBLE
}

fun View.gone() {
    this.visibility = View.GONE
}

fun View.invisible() {
    this.visibility = View.INVISIBLE
}

fun EditText.isHidingPassword(): Boolean = this.inputType == INPUT_TYPE_HIDDEN_PASSWORD

fun EditText.enableInputHiddenPassword() {
    val cache = typeface
    inputType = INPUT_TYPE_HIDDEN_PASSWORD
    typeface = cache
}

fun EditText.enableInputVisiblePassword() {
    val cache = typeface
    inputType = INPUT_TYPE_VISIBLE_PASSWORD
    typeface = cache
}

fun View.hideSoftKeyBoard() {
    val inputMethodManager = this.context.getSystemService(
        Context.INPUT_METHOD_SERVICE
    ) as InputMethodManager
    inputMethodManager.hideSoftInputFromWindow(this.windowToken, 0)
}

fun View.showSoftKeyBoard() {
    val inputMethodManager = this.context.getSystemService(
        Context.INPUT_METHOD_SERVICE
    ) as InputMethodManager
    inputMethodManager.showSoftInput(this, InputMethodManager.SHOW_IMPLICIT)
}
