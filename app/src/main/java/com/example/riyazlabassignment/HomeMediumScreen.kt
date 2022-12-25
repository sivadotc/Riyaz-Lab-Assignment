package com.example.riyazlabassignment

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.riyazlabassignment.ui.theme.ButtonBlue
import com.example.riyazlabassignment.ui.theme.DarkerButtonBlue
import com.example.riyazlabassignment.ui.theme.TextWhite
import com.example.riyazlabassignment.ui.theme.Typography


@Composable
fun HomeMediumScreen() {

    Row {
        Column(modifier = Modifier
            .weight(0.75f)
            .fillMaxSize(), verticalArrangement = Arrangement.SpaceEvenly) {
            GreetingSection(name = "Riyaz")
            ChipSectionMedium(chips = listOf("Riyaz","2019WA86947","Lab 3","SDPD","CSIWZ424"))

        }
        Column(modifier = Modifier
            .weight(1f)
            .fillMaxSize(), verticalArrangement = Arrangement.Top
        ) {
            ObjectiveSection()
            CurrentLabSection()
        }

    }
}


@Composable
fun ChipSectionMedium(chips: List<String>){
    val chipValues = listOf("NAME","BITS ID","LAB","SUBJECT","SUB CODE")
    var selectedChipIndex by remember {
        mutableStateOf(0)
    }
    LazyColumn{
        items(chips.size){
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 15.dp, top = 15.dp, bottom = 15.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .clickable {
                        selectedChipIndex = it
                    }
                    .background(
                        if (selectedChipIndex == it) ButtonBlue
                        else DarkerButtonBlue
                    )
            ){
                if (selectedChipIndex == it) {
                    Text(
                        text = chips[it],
                        color = TextWhite,
                        modifier = Modifier.padding(15.dp),
                        style = Typography.h2
                    )
                }
                else Text(
                    text = chipValues[it],
                    color = TextWhite,
                    modifier = Modifier.padding(15.dp),
                    style = Typography.h2
                )
            }

        }
    }
}