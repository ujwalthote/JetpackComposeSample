package com.ujwal.grocerycomposesample.ui.screens.tabs.shop

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShopViewModel : ViewModel() {
    private val _location : MutableLiveData<String> = MutableLiveData("Pune, MH")
    val location : LiveData<String> = _location

    fun onLocationChange(location : String){
        _location.postValue(location)
    }
}