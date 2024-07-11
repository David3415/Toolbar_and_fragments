package com.example.myapplication

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class DataModel : ViewModel() {
    val message_for_activity: MutableLiveData<String> by lazy {
        MutableLiveData<String>()

    }
    val message_for_fragment1: MutableLiveData<String> by lazy {
        MutableLiveData<String>()

    }
    val message_for_fragment2: MutableLiveData<String> by lazy {
        MutableLiveData<String>()

    }
}