package com.example.riyazlabassignment


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.example.riyazlabassignment.ui.theme.*
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination(start = true)
@Composable
fun HomeScreen(navigator: DestinationsNavigator) {
    Box(modifier = Modifier
        .background(DeepBlue)
        .fillMaxSize()
    ){
        val windowInfo = rememberWindowInfo()
        if (windowInfo.screenWidthInfo is WindowInfo.WindowType.Compact) {
            HomeCompactScreen(navigator)
        } else {
            HomeMediumScreen(navigator)
        }
    }
}



