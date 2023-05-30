package com.programmingwithahmed.composegiude.navigation.first

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class FirstViewModel @Inject constructor(

) : ViewModel() {

    private val _name = MutableStateFlow("")
    val name = _name.asStateFlow()

    fun onNameChanged(name: String) {
        _name.update {
            name
        }
    }
}