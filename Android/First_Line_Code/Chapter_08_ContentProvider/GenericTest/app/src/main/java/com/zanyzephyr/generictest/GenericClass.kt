package com.zanyzephyr.generictest

class GenericClass<T> {
    fun method(param: T): T {
        return param
    }
}

fun main() {
    val generic = GenericClass<Int>()
    generic.method(123)

    val genericMethodClass = GenericMethodClass()
    genericMethodClass.method<Int>(456)
    genericMethodClass.method(123)

    genericMethodClass.methodWithNumber<Double>(1.1)

}







class GenericMethodClass {
    fun <T: Any>method(param: T): T {
        return param
    }

    fun <T: Number>methodWithNumber(param: T): T {
        return param
    }
}