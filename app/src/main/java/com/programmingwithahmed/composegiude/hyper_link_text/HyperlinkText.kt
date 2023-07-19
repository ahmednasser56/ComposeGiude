package com.programmingwithahmed.composegiude.hyper_link_text

import androidx.compose.foundation.text.ClickableText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

@Composable
fun HyperlinkText(
    fullText: String,
    hyperlinks: Map<String, String>,
    modifier: Modifier = Modifier,
    fontSize: TextUnit = 20.sp,
    linkTextColor: Color = Color.Blue,
    linkTextWeight: FontWeight = FontWeight.Medium,
    linkTextDecoration: TextDecoration = TextDecoration.Underline
) {

    val annotatedString = buildAnnotatedString {

        append(fullText)

        for ((key, value) in hyperlinks) {

            val startIndex = fullText.indexOf(key)
            val endIndex = startIndex + key.length

            addStyle(
                style = SpanStyle(
                    color = linkTextColor,
                    // fontSize = fontSize,
                    fontWeight = linkTextWeight,
                    textDecoration = linkTextDecoration
                ),
                start = startIndex,
                end = endIndex
            )

            addStringAnnotation("URL", annotation = value, start = startIndex, end = endIndex)
        }

        addStyle(
            style = SpanStyle(
                fontSize = fontSize
            ),
            start = 0,
            end = 0
        )
    }

    val uriHandler = LocalUriHandler.current

    ClickableText(text = annotatedString, modifier = modifier) {

        annotatedString
            .getStringAnnotations("URL", it, it)
            .firstOrNull()?.let { stringAnnotation ->
                uriHandler.openUri(stringAnnotation.item)
            }
    }
}

@Composable
@Preview
fun HyperlinkTextPreview() {
    HyperlinkText(
        "This text may go to Google or GitHub", hyperlinks = mapOf(
            "Google" to "https://www.google.com",
            "GitHub" to "https://github.com/"
        )
    )
}