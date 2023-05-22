package com.programmingwithahmed.composegiude.food_screen

data class FoodUIState(
    val meals: List<Meal> = emptyList()
)

data class Meal(
    val name: String,
    val imageUrl: String
)