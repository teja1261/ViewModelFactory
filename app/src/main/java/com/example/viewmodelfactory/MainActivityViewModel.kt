package com.example.viewmodelfactory

import androidx.lifecycle.ViewModel

class MainActivityViewModel(var initialValue: Int): ViewModel() {
    private var addResult: Int = 0

    init {
        addResult = initialValue
    }

    fun add(userInput: Int) {
        addResult += userInput
    }

    fun getAddResult(): Int {
        return addResult
    }
}
