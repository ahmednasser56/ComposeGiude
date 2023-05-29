package com.programmingwithahmed.composegiude.profile_screen

import androidx.lifecycle.ViewModel
import com.programmingwithahmed.composegiude.profile_screen.state.ProfileUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor()  : ViewModel() {

    private val _profileUiState = MutableStateFlow(ProfileUIState())
    val profileUiState = _profileUiState.asStateFlow()

    fun onChangeFirstName(newValue: String) {
        _profileUiState.update { it.copy(firstName = newValue) }
    }

    fun onChangeLastName(newValue: String) {
        _profileUiState.update { it.copy(lastName = newValue) }
    }

    fun onChangeLocation(newValue: String) {
        _profileUiState.update { it.copy(location = newValue) }
    }

    fun onChangeEmail(newValue: String) {
        _profileUiState.update { it.copy(email = newValue) }
    }

    fun onChangePhone(newValue: String) {
        _profileUiState.update { it.copy(phone = newValue) }
    }

    fun onSaveClicked(){}
}