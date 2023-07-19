package com.programmingwithahmed.composegiude.stop_watch.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class StopWatchViewModel @Inject constructor(

) : ViewModel() {

    val seconds = (0..100)
        .asFlow()
        .map { if (it <10) "0$it" else it }
        .onEach { delay(1000) }

}