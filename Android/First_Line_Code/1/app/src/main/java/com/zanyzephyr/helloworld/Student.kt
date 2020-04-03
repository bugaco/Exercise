package com.zanyzephyr.helloworld


class Student(val sno: String, val grade: Int, name: String, age: Int): Person(name, age), Study {

    constructor(sno: String, grade: Int): this(sno, grade, "", 0) {

    }
    constructor(): this("110", -1) {

    }

    override fun readBooks() {
        println("$name is reading.")
    }

}


