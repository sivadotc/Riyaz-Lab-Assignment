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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.riyazlabassignment.destinations.Lab2ScreenDestination
import com.example.riyazlabassignment.ui.theme.*
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Composable
fun HomeMediumScreen(navigator: DestinationsNavigator){

        Row {
            Column(modifier = Modifier
                .weight(0.75f)
                .fillMaxSize(), verticalArrangement = Arrangement.SpaceEvenly) {
                GreetingSection(name = "Riyaz")
                ChipSectionMedium(chips = listOf("Riyaz","2019WA86947","Lab 3","SDPD","CSIWZ424"))

            }
            Column(modifier = Modifier
                .weight(1f)
                .fillMaxSize(), verticalArrangement = Arrangement.Center
            ) {
                ObjectiveSectionMedium()
                CurrentLabSectionMedium(navigator)
            }

        }
}

@Composable
fun ObjectiveSectionMedium() {
    Box(modifier = Modifier
        .padding(15.dp)
        .fillMaxWidth()
        .clip(RoundedCornerShape(20.dp))
        .background(LightRed)){
    Column(
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding(15.dp)
            .fillMaxWidth()
    ) {
        Text(
            text = "Lab 3 Objective",
            style = Typography.h1
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = stringResource(id = R.string.lab3_objective),
            style = Typography.h2
        )
    }
}
}

@Composable
fun CurrentLabSectionMedium(navigator: DestinationsNavigator){
    Box(modifier = Modifier
        .padding(15.dp)
        .fillMaxWidth()
        .clip(RoundedCornerShape(20.dp))
        .background(LightGreen1)
    ){
        Column(
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .padding(15.dp)
                .fillMaxWidth()
        ) {
            Text(text = "Current Lab Assignment", style = Typography.h1)
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "More than one activity",
                style = Typography.h2,
                modifier = Modifier.padding(start = 20.dp)
            )
            Text(
                text = "Permissions",
                style = Typography.h2,
                modifier = Modifier.padding(start = 20.dp)
            )
            Text(
                text = "Multiple screen size compatibility",
                style = Typography.h2,
                modifier = Modifier.padding(start = 20.dp)
            )

        }
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .padding(15.dp)
                .align(Alignment.BottomEnd)
                .clip(RoundedCornerShape(40.dp))
                .clickable {
                    navigator.navigate(Lab2ScreenDestination)
                }
                .background(ButtonBlue)
        ) {
            Text(
                text = "  View  ",
                color = TextWhite,
                modifier = Modifier.padding(15.dp),
                style = Typography.h2
            )
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