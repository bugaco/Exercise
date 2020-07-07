package com.zanyzephyr.materialtest

import android.content.Context
import android.view.View
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import java.lang.RuntimeException
import kotlin.math.max

fun <T : Comparable<T>> max(vararg nums: T): T {
    if (nums.isEmpty()) throw
    RuntimeException("Params can not be empty.")
    var maxNum = nums[0]
    for (num in nums) {
        if (num > maxNum) {
            maxNum = num
        }
    }
    return maxNum
}

fun main() {
    val a = 3.5
    val b = 3.8
    val c = 1.2
    val max = max(a, b, c)
    val maxInt = max(1, 2, 3, -11)
    println("$max, $maxInt")
}

fun String.makeToask(context: Context, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(context, this, duration).show()
}

fun View.showSnackbar(
    text: String,
    actionString: String?,
    duration: Int = Snackbar.LENGTH_SHORT,
    block: (() -> Unit)? = null
) {
    val snackbar = Snackbar.make(this, text, duration)
    if (actionString != null && block != null) {
        snackbar.setAction(actionString) {
            block()
        }
    }
    snackbar.show()
}