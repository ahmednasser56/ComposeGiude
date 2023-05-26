package com.programmingwithahmed.composegiude.food_screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.programmingwithahmed.composegiude.ui.theme.PrimaryTextColor
import com.programmingwithahmed.composegiude.ui.theme.Rubik

@Composable
fun MealItem(meal: Meal, modifier: Modifier, onItemClicked: (Meal) -> Unit) {

    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable {
                onItemClicked(meal)
            },
        shape = CutCornerShape(16.dp)
    ) {

        Column {

            AsyncImage(
                model = meal.imageUrl, contentDescription = "Meal Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.FillWidth
            )

            Text(
                meal.name,
                color = PrimaryTextColor,
                fontFamily = Rubik,
                fontSize = 22.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}


@Preview
@Composable
fun MealItemPreview() {
    MealItem(Meal(name = "Burger", ""), Modifier){}
}