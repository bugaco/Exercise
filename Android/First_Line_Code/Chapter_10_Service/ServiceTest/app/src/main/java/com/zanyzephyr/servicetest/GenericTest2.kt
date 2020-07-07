package com.zanyzephyr.servicetest

interface Transformer<in T> {
    fun transform(t: T): String
}

fun handleSimpleData(data: Transformer<Teacher>) {

}

fun main() {
    val trans = object : Transformer<Person> {
        override fun transform(t: Person): String {
            return "${t.name}, ${t.age}"
        }
    }
    handleSimpleData(trans)

    val trans2 = object : Transformer<Person> {
        override fun transform(t: Person): String {
            return "${t.name}, ${t.age}"
        }
    }
    handleSimpleData(trans2)
}

interface Comparable<in T> {
    operator fun compareTo(other: T): Int
}