package com.zanyzephyr.viewmodeltest

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

object Repository {
    fun getUser(userId: String): LiveData<User> {
        val liveData = MutableLiveData<User>()
        liveData.value = User(userId, userId, 0)
        return liveData
    }

    fun refresh(): LiveData<User> {
        val liveData = MutableLiveData<User>()
        val firstName = (10000..20000).random().toString()
        liveData.value = User(firstName, "", 0)
        return liveData
    }
}