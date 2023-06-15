package com.programmingwithahmed.composegiude.onboard.data

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object OnboardUseCaseModule {

    @Singleton
    @Provides
    fun provideGetOnboardStatusUseCase(
        preferencesUtility: PreferencesUtility
    ) =
        GetOnboardStatusUseCase(preferencesUtility)

    @Singleton
    @Provides
    fun provideSetOnboardUseCase(
        preferencesUtility: PreferencesUtility
    ) =
        SetOnboardUseCase(preferencesUtility)

}