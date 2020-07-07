package com.zanyzephyr.providertest

import java.lang.StringBuilder

fun <T>T.build(block: T.() -> Unit): T {
    block()
    return this
}

fun main() {
    val builder = StringBuilder()
    builder.build {
        append("a")
        append("b")
    }
    println("builder is : $builder")
}

class MySet<T>(val helperSet: HashSet<T>): Set<T> by helperSet {
    fun greeting(name: String) {
        println("Hello, $name!")
    }

    override fun isEmpty() = false
}

class MyClass {
    var property by Delegate()
}

class Delegate {
    operator fun getValue(myClass: MyClass, property: KProperty<*>): Any? {
        return propValue
    }

    operator fun setValue(myClass: MyClass, property: KProperty<*>, any: Any?) {
        propValue = any
    }

    var propValue: Any? = null

}