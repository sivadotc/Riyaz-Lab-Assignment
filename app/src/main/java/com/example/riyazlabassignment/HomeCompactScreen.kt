package com.example.riyazlabassignment

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.riyazlabassignment.ui.theme.*
import com.example.riyazlabassignment.ui.theme.Typography


@Composable
fun HomeCompactScreen(){
    Column {
        GreetingSection(name = "Riyaz")
        ChipSection(chips = listOf("Riyaz","2019WA86947","Lab 3","SDPD","CSIWZ424"))
        ObjectiveSection()
        CurrentLabSection()
    }
}

@Composable
fun GreetingSection(name: String){
    val context = LocalContext.current
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 15.dp, end = 15.dp, top = 40.dp, bottom = 20.dp)
    ) {
        Column {
            Text(
                text = "Hi, $name",
                fontFamily = montserrat,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = "This is your Lab Assignment App",
                style = MaterialTheme.typography.h2
            )
        }
        Icon(
            painter = painterResource(id = R.drawable.ic_search),
            contentDescription = "Search",
            modifier = Modifier
                .size(24.dp)
                .clickable {
                    Toast
                        .makeText(context, "Search feature will come soon", Toast.LENGTH_SHORT)
                        .show()
                }
        )
    }
}

@Composable
fun ChipSection(chips: List<String>){
    val chipValues = listOf("NAME","BITS ID","LAB","SUBJECT","SUB CODE")
    var selectedChipIndex by remember {
        mutableStateOf(0)
    }
    LazyRow{
        items(chips.size){
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
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

@Composable
fun ObjectiveSection() {
    Box(modifier = Modifier
        .padding(15.dp)
        .fillMaxWidth()
        .clip(RoundedCornerShape(20.dp))
        .background(LightRed)){
        Column(
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.SpaceBetween,
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
                text = stringResource(id = R.string.lab4_objective),
                style = Typography.h2
            )
        }

    }
}

@Composable
fun CurrentLabSection(){
    Box(
        modifier = Modifier
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
            Text(text = "Learning Outcome", style = Typography.h1)
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "Create an App with sophisticated UI",
                style = Typography.h2,
                modifier = Modifier.padding(start = 20.dp)
            )
            Text(
                text = "Elegant User Interface",
                style = Typography.h2,
                modifier = Modifier.padding(start = 20.dp)
            )


        }


    }
}