package com.pack.anurak.bottomnavigation.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Total : "+22/10+" Cup"
    }
    val text: LiveData<String> = _text
}