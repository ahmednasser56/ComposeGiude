package com.programmingwithahmed.composegiude.onboard.onboard.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.programmingwithahmed.composegiude.R
import com.programmingwithahmed.composegiude.onboard.data.SetOnboardUseCase
import com.programmingwithahmed.composegiude.onboard.model.OnboardItem
import com.programmingwithahmed.composegiude.onboard.onboard.view.OnboardUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class OnboardViewModel @Inject constructor(
    private val setOnboardUseCase: SetOnboardUseCase
) : ViewModel() {

    private val _onboardUIState = MutableStateFlow(OnboardUIState())
    val onboardUIState = _onboardUIState.asStateFlow()

    private val _navigateToHome = MutableSharedFlow<Boolean>()
    val navigateToHome = _navigateToHome.asSharedFlow()

    init {
        getOnboardItems()
    }

    private fun getOnboardItems() {
        _onboardUIState.update {
            it.copy(
                onboardItems = listOf(
                    OnboardItem(
                        image = R.drawable.first,
                        title = "Meeting",
                        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod."
                    ),
                    OnboardItem(
                        image = R.drawable.second,
                        title = "Coordination",
                        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod."
                    ),
                    OnboardItem(
                        image = R.drawable.third,
                        title = "Dialogue",
                        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod."
                    )
                )
            )
        }
    }

    fun onPageChanged(position: Int) {
        _onboardUIState.update {
            it.copy(
                showFinishButton = position == 2
            )
        }
    }

    fun onFinishClicked() {

        setOnboardUseCase().onEach {
            _navigateToHome.emit(true)
        }.launchIn(viewModelScope)

    }

}