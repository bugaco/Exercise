package com.zanyzephyr.uibestpractice

import java.lang.Exception
import java.lang.IllegalArgumentException

//interface Result
//class Success(val msg: String): Result
//class Failure(val error: Exception): Result

sealed class Result
class Success(val msg: String): Result()
class Failure(val error: Exception): Result()

fun getMsg(result: Result) = when (result) {
    is Success -> result.msg
    is Failure -> result.error.message
}