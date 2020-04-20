package com.zanyzephyr.threadtest

import kotlin.concurrent.thread

fun main() {
    MyThread().start() // 1
    Thread(MyThread2()).start() // 2

    // 3
    Thread {
        println("Lambda Thread run")
    }.start()

    // 4
    thread {
        println("thread")
    }
}

class MyThread: Thread() {
    override fun run() {
        println("MyThread run")
    }
}

class MyThread2: Runnable {
    override fun run() {
        println("MyThread2 run")
    }

}