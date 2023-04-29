package com.example.mvvm_example.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvm_example.model.DataModel

class MainViewModel: ViewModel() {

    private var model = DataModel(newText = "Hola Mundo!")

    val uiTextLiveData = MutableLiveData<String>()

    fun getUpdatedText() {
        val updatedText = model.newText
        uiTextLiveData.postValue(updatedText)
    }
}