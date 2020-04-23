package com.zanyzephyr.retrofittest

import kotlinx.coroutines.*
import kotlin.coroutines.suspendCoroutine

fun main() {

    /* async的更合理用法 */
    runBlocking {
        val start = System.currentTimeMillis()
        val deferred1 = async {
            delay(1000)
            5 + 5
        }
        val deferred2 = async {
            delay(1000)
            5 + 6
        }
        println("result is ${deferred1.await()} + ${deferred2.await()}")
        val end = System.currentTimeMillis()
        println(end - start)
    }

    /* async函数的用法 */
    runBlocking {
        val result = async {
            5 + 5
        }.await()
        print(result)
    }

    /* 常用的写法 */
    val job = Job()
    val scope = CoroutineScope(job)
    scope.launch {
        // 处理逻辑1
    }
    scope.launch {
        // 处理逻辑2
    }
    job.cancel()
//
//    runBlocking {
//        coroutineScope {
//            launch {
//                for (i in 1..10) {
//                    println(i)
//                    delay(1000)
//                }
//            }
//
//        }
//        println("coroutinesScope finished")
//    }
//    println("runBlocking finished")

//    GlobalScope.launch {
//        delay(1500)
//        println("codes run in coroutines scope")
//    }
//    Thread.sleep(1000)

//    runBlocking {
//        println("codes run in coroutines scope")
//        delay(1500)
//        println("codes run in coroutines scope finish")
//    }

//    runBlocking {
//        launch {
//            println("launch1")
//            delay(1500)
//            println("launch1 finish")
//        }
//        launch {
//            println("launch2")
//            delay(1500)
//            println("launch2 finish")
//        }
//    }

//    val start = System.currentTimeMillis()
//    var count = 0
//    runBlocking {
//        repeat(100000) {
//            launch {
//                count += 1
//                println(count)
//            }
//        }
//    }
//    val end = System.currentTimeMillis()
//    println(end - start)
}

suspend fun printDot() = coroutineScope {
    launch {
        println(".")
        delay(1000)
    }
}


