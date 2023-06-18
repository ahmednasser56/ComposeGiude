package com.programmingwithahmed.composegiude.onboard

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.programmingwithahmed.composegiude.onboard.data.GetOnboardStatusUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val getOnboardStatusUseCase: GetOnboardStatusUseCase
) : ViewModel() {

    private val _isLoading: MutableState<Boolean> = mutableStateOf(true)
    val isLoading: State<Boolean> = _isLoading

    private val _startDestination: MutableState<String> = mutableStateOf("")
    val startDestination: State<String> = _startDestination

    init {
        getOnboardStatus()
    }

    private fun getOnboardStatus() {
        getOnboardStatusUseCase().onEach {completed ->

            if (completed) {
                _startDestination.value = "home"
            } else {
                _startDestination.value = "onboard"
            }

            _isLoading.value = false

        }.launchIn(viewModelScope)
    }

}