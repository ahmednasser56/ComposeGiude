package com.programmingwithahmed.composegiude.navigation.second.viewModel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.programmingwithahmed.composegiude.navigation.second.route.SecondArgs
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class SecondViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val args: SecondArgs = SecondArgs(savedStateHandle)

    private val _name= MutableStateFlow("")
    val name = _name.asStateFlow()

    init {
        _name.update {
            args.name
        }
    }
}