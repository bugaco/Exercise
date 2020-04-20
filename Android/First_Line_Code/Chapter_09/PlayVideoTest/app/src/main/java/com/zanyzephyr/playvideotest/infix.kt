package com.zanyzephyr.playvideotest

infix fun String.beginWith(prefix: String) = startsWith(prefix)

infix fun <T>Collection<T>.has(element: T) = contains(element)

fun main() {
    val flag = "abc" beginWith "a"
    println(flag) // true

    val list = listOf<String>("a", "1")
    val flag2 = list.has("1")
    println(flag2) // true

    val foo = mapOf("a" to "b", "1" to "2")

}
public infix fun <A, B> A.to(that: B): Pair<A, B> = Pair(this, that)