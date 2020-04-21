package com.zanyzephyr.servicetest

inline fun <reified T> getGenericType() = T::class.java

fun main() {
    println("str type: ${getGenericType<String>()}")
    println("int type: ${getGenericType<Int>()}")

//    val student = Student("Tom", 19)
//    val data = SimpleData<Student>(student)
//    handleSimpleData(data)
//    val studentData = data.get()

    val trans = object : Transformer<Person> {
        override fun transform(t: Person): String {
            return "${t.name}, ${t.age}"
        }
    }
    handleSimpleData(trans)
}

open class Person(val name: String, val age: Int)
class Student(name: String, age: Int, val grade: Int): Person(name, age), Comparable<Teacher> {
    override fun compareTo(other: Teacher): Int {
        return age - other.age
    }
}
class Teacher(name: String, age: Int): Person(name, age)

class SimpleData<out T>(private val data: T?) {

    fun get(): T? {
        return data
    }
}


