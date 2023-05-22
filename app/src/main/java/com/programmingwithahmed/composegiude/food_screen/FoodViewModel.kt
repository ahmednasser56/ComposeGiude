package com.programmingwithahmed.composegiude.food_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@HiltViewModel
class FoodViewModel : ViewModel() {

    private val _foodUiState = MutableStateFlow(FoodUIState())
    val foodUiState = _foodUiState.asStateFlow()

    init {
        getMeals()
    }

    private fun getMeals() {
        _foodUiState.update {
            it.copy(
                meals = listOf(
                    Meal("Burger1", "https://via.placeholder.com/600/92c952"),
                    Meal("Burger2", "https://via.placeholder.com/600/771796"),
                    Meal("Burger3", "https://via.placeholder.com/600/24f355"),
                    Meal("Burger4", "https://via.placeholder.com/600/d32776"),
                    Meal("Burger5", "https://via.placeholder.com/600/f66b97"),
                )
            )
        }
    }

    fun onClickMeal(meal: Meal) {
        _foodUiState.update {

            it.copy(meals = it.meals.filterNot { currentMeal ->
                currentMeal.name == meal.name
            }
            )
        }
    }
}