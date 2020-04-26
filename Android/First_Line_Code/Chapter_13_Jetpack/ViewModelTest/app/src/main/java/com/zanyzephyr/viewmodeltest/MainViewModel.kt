package com.zanyzephyr.viewmodeltest

import androidx.lifecycle.ViewModel

class MainViewModel(countReserved: Int = 0): ViewModel() {
    var counter = countReserved
}