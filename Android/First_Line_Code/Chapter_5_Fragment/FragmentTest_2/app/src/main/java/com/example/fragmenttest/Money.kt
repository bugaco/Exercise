package com.example.fragmenttest

class Money(var value: Int) {

    operator fun plus(money: Money) {
        value += money.value
        money.value = 0
    }
    operator fun minus(value: Int) {
        this.value -= value
    }

    override fun toString(): String {
        return "${value}元".toString()
    }

    override fun equals(other: Any?): Boolean {
        return super.equals(other)
    }

    operator fun compareTo(other: Money): Int {
        return 1
    }
}

fun main() {
    val myMoney = Money(100)
    val yourMoney = Money(50)
    myMoney + yourMoney
    myMoney - 10 // 上了2小时网
    println("My money: ${myMoney.toString()}\nYour money: ${yourMoney.toString()}")
}