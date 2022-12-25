package com.example.riyazlabassignment


import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier


@Composable
fun HomeScreen() {
    Box(modifier = Modifier
        .fillMaxSize()
    ){
        val windowInfo = rememberWindowInfo()
        if (windowInfo.screenWidthInfo is WindowInfo.WindowType.Compact) {
            HomeCompactScreen()
        } else {
            HomeMediumScreen()
        }
    }
}



