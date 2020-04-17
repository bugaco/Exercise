package com.example.higherorderfunction

import java.lang.StringBuilder

fun operator(num1: Int, num2: Int, func: ((Int, Int) -> Int)) {
    println(func(num1, num2))
}

fun plus(num1: Int, num2: Int): Int {
    return num1 + num2
}

fun times(num1: Int, num2: Int): Int {
    return num1 * num2
}

fun main() {
    operator(2, 3, ::times)
    operator(5, 6, ::plus)

    operator(8, 9) { n1, n2 ->
        n1 - n2
    }
    operator(4, 7) { n1, n2 ->
        n2 / n1
    }

//    var stringBuilder = StringBuilder().build {
//
//        append("1a")
//        append("b2")
//    }
//    println("stringBuilder: $stringBuilder")
    println("--------")
    val dog = Animal()
    dog.doSomething {
        println("nothing")
        repeat(2) {
            eat("💩")
        }
        cry()
    }
}

fun StringBuilder.build(block: () -> Unit): StringBuilder {
    block()
    return this
}

inline fun Animal.doSomething(noinline block: Animal.() -> Unit) {
    block()
}

class Animal {
    fun eat(food: String) {
        println("Animal eat $food.")
    }

    fun cry() {
        println("Animal cry.")
    }
}