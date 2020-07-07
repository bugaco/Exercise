package com.zanyzephyr.viewmodeltest

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class MainViewModel(countReserved: Int = 0) : ViewModel() {

    private val userLiveData = MutableLiveData<User>()
    val userName: LiveData<String> = Transformations.map(userLiveData) {
        "${it.firstName} ${it.lastName}"
    }

    val counter: LiveData<Int>
        get() = _counter
    private val _counter = MutableLiveData<Int>()

    init {
        _counter.value = countReserved
    }

    fun plusOne() {
        val count = counter.value ?: 0
        _counter.value = count + 1
    }

    fun clear() {
        _counter.value = 0
    }

    /* 从外部获取数据 */
    private val userIdLiveData = MutableLiveData<String>()

    val user: LiveData<User> = Transformations.switchMap(userIdLiveData) {
        Repository.getUser(it)
    }

    fun getUser(userId: String) {
        userIdLiveData.value = userId
    }

    /* 无参的方法 */

    private val refreshLiveData = MutableLiveData<Any?>()

    val refreshResult = Transformations.switchMap(refreshLiveData) {
        Repository.refresh()
    }
    fun refresh() {
        refreshLiveData.value = refreshLiveData.value
    }
}


