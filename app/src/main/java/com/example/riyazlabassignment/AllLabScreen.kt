package com.example.riyazlabassignment

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.riyazlabassignment.ui.theme.LightGreen1
import com.example.riyazlabassignment.ui.theme.Typography


@Composable
fun AllLabScreen(){
    Box(modifier = Modifier
        .fillMaxSize()
    ){
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
        ) {
            AllLabTitleSection()
            Spacer(modifier = Modifier.height(20.dp))
            Sophisticated()
            Elegant()
        }

    }
}

@Composable
fun AllLabTitleSection(){
    Text(text = "Lab 4 Screen", style = Typography.h1)
}

@Composable
fun Sophisticated(){
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "App with sophisticated UI", style = Typography.h2, textAlign = TextAlign.Center)
        Box(
            modifier = Modifier
                .padding(15.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(20.dp))
                .background(LightGreen1), contentAlignment = Center
        ) {
            Text(
                text = "I have added bottom navigation feature in this version",
                style = Typography.h2,
                modifier = Modifier.padding(15.dp), textAlign = TextAlign.Justify
            )
        }
    }
}

@Composable
fun Elegant(){
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Elegant User Interface", style = Typography.h2, textAlign = TextAlign.Center)
        Box(
            modifier = Modifier
                .padding(15.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(20.dp))
                .background(LightGreen1), contentAlignment = Center
        ) {
            Text(
                text = "I have imported custom colors to make this UI more elegant than previous version",
                style = Typography.h2,
                modifier = Modifier.padding(15.dp), textAlign = TextAlign.Justify
            )
        }
    }
}