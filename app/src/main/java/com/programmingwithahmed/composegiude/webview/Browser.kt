package com.programmingwithahmed.composegiude.webview

import android.graphics.Bitmap
import android.util.Log
import android.webkit.WebResourceRequest
import android.webkit.WebView
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.web.AccompanistWebViewClient
import com.google.accompanist.web.WebView
import com.google.accompanist.web.WebViewState
import com.google.accompanist.web.rememberWebViewState


@Composable
fun Browser() {
    val browserState = rememberWebViewState(url = "https://www.google.com")
    val progressBarState = remember { mutableStateOf(true) }

    BrowserContent(browserState, progressBarState.value, onPageStarted = {
        progressBarState.value = false
    }, onUrlChanged = {
        Log.e("A7A", "Browser: $it", )
    })
}

@Composable
private fun BrowserContent(
    browserState: WebViewState,
    appearProgress: Boolean,
    onPageStarted: () -> Unit,
    onUrlChanged: (String) -> Unit,
) {

    val webClient = remember {
        object : AccompanistWebViewClient() {

            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
                onPageStarted()
            }

            override fun shouldOverrideUrlLoading(
                view: WebView?,
                request: WebResourceRequest?
            ): Boolean {
                onUrlChanged(request?.url.toString())
                return super.shouldOverrideUrlLoading(view, request)
            }

        }
    }

    Box(modifier = Modifier.fillMaxSize()) {

        WebView(
            state = browserState,
            modifier = Modifier.fillMaxSize(),
            onCreated = {
                it.settings.javaScriptEnabled = true
            },
            client = webClient
        )

        if (appearProgress) {
            CircularProgressIndicator(
                modifier = Modifier
                    .align(Alignment.Center)
            )
        }
    }


}


@Preview
@Composable
fun BrowserContentPreview() {
    BrowserContent(rememberWebViewState(url = "https://www.google.com"), true, onPageStarted = {}) {}
}