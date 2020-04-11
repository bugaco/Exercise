package com.zanyzephyr.uibestpractice

class Msg(content: String, type: Int) {
    companion object {
        const val TYPE_RECEIVED = 0
        const val TYPE_SENT = 1
    }
}