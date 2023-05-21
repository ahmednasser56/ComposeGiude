package com.programmingwithahmed.composegiude.counter_vm_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@HiltViewModel
class CounterViewModel : ViewModel() {

    private val _counterState = MutableStateFlow(0)
    val counterState = _counterState.asStateFlow()

    fun increaseCounter() = viewModelScope.launch {
        _counterState.update { it + 1 }
    }

    fun decreaseCounter() = viewModelScope.launch {
        _counterState.update { it - 1 }
    }
}