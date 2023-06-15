package com.programmingwithahmed.composegiude.onboard.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SetOnboardUseCase @Inject constructor(
    private val preferencesUtility: PreferencesUtility,
) {

    operator fun invoke(): Flow<Boolean> =
        flow {
            preferencesUtility.setBoolean("onboard", true)
            emit(true)
        }

}