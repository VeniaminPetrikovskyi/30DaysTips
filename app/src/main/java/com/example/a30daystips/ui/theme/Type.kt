package com.example.a30daystips.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp
import com.example.a30daystips.R

val rancho = FontFamily(
    Font(R.font.rancho_regular, FontWeight.Bold)
)

val satisfy = FontFamily(
    Font(R.font.satisfy_regular, FontWeight.Normal)
)

// Set of Material typography styles to start with
val Typography = Typography(
    displayLarge = TextStyle(
        fontFamily = rancho,
        fontWeight = FontWeight.Bold,
        fontSize = 40.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = satisfy,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = satisfy,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        textDecoration = TextDecoration.Underline,
        color = Color.Blue
    ),
    bodySmall = TextStyle(
        fontFamily = satisfy,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    )
)