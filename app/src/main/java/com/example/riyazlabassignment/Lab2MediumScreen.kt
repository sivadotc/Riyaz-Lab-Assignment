package com.example.riyazlabassignment


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.riyazlabassignment.destinations.HomeScreenDestination
import com.example.riyazlabassignment.ui.theme.*
import com.ramcosta.composedestinations.navigation.DestinationsNavigator


@Composable
fun Lab2MediumScreen(navigator: DestinationsNavigator){
    Box(modifier = Modifier
        .fillMaxSize()
        .background(DeepBlue)){
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
        ) {
            TitleSection()
            Spacer(modifier = Modifier.height(20.dp))
            Row() {
                Column(modifier = Modifier.weight(1f)) {
                    PermissionStatus()
                }
                Column(modifier = Modifier.weight(1f)) {
                    MultipleScreenSize()
                }
                Column(modifier = Modifier.weight(1f)) {
                    Activity()
                }

            }

        }
        Box(
            contentAlignment = Center,
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(horizontal = 20.dp, vertical = 45.dp)
                .clip(RoundedCornerShape(40.dp))
                .clickable {
                    navigator.navigate(HomeScreenDestination)
                }
                .background(ButtonBlue)
        ) {
            Text(
                text = "  Home  ",
                color = TextWhite,
                modifier = Modifier.padding(15.dp),
                style = Typography.h2
            )
        }
    }

}