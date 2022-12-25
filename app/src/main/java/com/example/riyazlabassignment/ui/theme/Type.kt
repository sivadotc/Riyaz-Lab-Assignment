package com.example.riyazlabassignment.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.riyazlabassignment.R

val montserrat = FontFamily(
    listOf(
        Font(R.font.montserrat_medium, FontWeight.Medium),
        Font(R.font.montserrat_normal, FontWeight.Normal),
        Font(R.font.montserrat_bold, FontWeight.Bold)
    )
)


val Typography = Typography(
    body1 = TextStyle(
        fontFamily = montserrat,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    h1 = TextStyle(
        fontFamily = montserrat,
        fontWeight = FontWeight.Bold,
        fontSize = 22.sp
    ),
    h2 = TextStyle(
        fontFamily = montserrat,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp
    )
)