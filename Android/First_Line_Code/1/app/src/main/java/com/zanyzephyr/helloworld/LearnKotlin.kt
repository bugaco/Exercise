package com.zanyzephyr.helloworld

import kotlin.math.max

fun main() {
    printParams(num = 10)
}

fun printParams(str: String = "foo", num: Int) {
    println("str is $str, num is $num")

}

fun doStudy(study: Study?) {
    study?.let {
        it.readBooks()
        it.doHomework()
    }
}