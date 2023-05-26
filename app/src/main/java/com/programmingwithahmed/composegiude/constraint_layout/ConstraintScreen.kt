package com.programmingwithahmed.composegiude.constraint_layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun ConstraintScreen() {
    ConstraintContent()
}


@Composable
private fun ConstraintContent() {

    ConstraintLayout(modifier = Modifier.fillMaxSize()) {

        val (btnShow, fab, tvResult, btnForGuideline) = createRefs()
        val topGuideline = createGuidelineFromTop(.2f)

        val (tv1, tv2, tv3) = createRefs()
        val chainHorizontal = createHorizontalChain(tv1, tv2, tv3, chainStyle = ChainStyle.Packed)

        Button(onClick = {},
            modifier = Modifier.constrainAs(btnShow) {
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }) {
            Text(text = "Show")
        }

        FloatingActionButton(onClick = {},
            modifier = Modifier.constrainAs(fab) {
                bottom.linkTo(parent.bottom, 24.dp)
                end.linkTo(parent.end, 24.dp)
            }) {
            Icon(imageVector = Icons.Default.Add, contentDescription = "")
        }

        Text(text = "This is the result",
            modifier = Modifier.constrainAs(tvResult) {
                bottom.linkTo(btnShow.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            })

        Button(onClick = {},
            modifier = Modifier.constrainAs(btnForGuideline) {
                top.linkTo(topGuideline)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }) {
            Text(text = "For Top Guideline")
        }

        Text(text = "Text 1", fontSize = 22.sp,
            modifier = Modifier
                .background(color = Color.Yellow)
                .padding(8.dp)
                .constrainAs(tv1) {}
        )

        Text(text = "Text 2", fontSize = 22.sp,
            modifier = Modifier
                .background(color = Color.Cyan)
                .padding(8.dp)
                .constrainAs(tv2) {}
        )

        Text(text = "Text 3", fontSize = 22.sp,
            modifier = Modifier
                .background(color = Color.Red)
                .padding(8.dp)
                .constrainAs(tv3) {}
        )
    }

}


@Preview
@Composable
fun ConstraintContentPreview() {
    ConstraintContent()
}