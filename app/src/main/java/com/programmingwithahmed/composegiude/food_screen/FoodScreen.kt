package com.programmingwithahmed.composegiude.food_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel


@Composable
fun FoodScreen(
    foodViewModel: FoodViewModel = hiltViewModel()
) {
    val foodUiState by foodViewModel.foodUiState.collectAsState()

    FoodContent(
        foodUiState,
        onMealClicked = foodViewModel::onClickMeal
    )
}


@Composable
private fun FoodContent(foodUiState: FoodUIState, onMealClicked: (Meal)->Unit) {

    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Text(text = "Select Meal:")
        }
        items(foodUiState.meals) {
            MealItem(it, onItemClicked = onMealClicked)
        }

        item {
            Text(text = "Copyright 2022")
        }
    }

}


@Preview
@Composable
fun FoodContentPreview() {
    FoodContent(FoodUIState()){}
}