package com.zanyzephyr.helloworld

open class Person(var name: String, var age: Int) {

    fun eat() {
        println("$name is eating. He is $age years old.")
    }
}