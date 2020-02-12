package com.pack.anurak.loyaltypoint.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ProfileModel : ViewModel() {
    private val _text = MutableLiveData<String>().apply { value = "This is profile fragment" }
    val text: LiveData<String> = _text
}