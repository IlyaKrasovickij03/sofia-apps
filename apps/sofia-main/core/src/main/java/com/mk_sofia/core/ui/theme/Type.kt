package com.mk_sofia.core.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = robotoFontFamily,
        fontWeight = FontWeight(700),
        fontSize = 28.sp,
        lineHeight = 34.sp,
    ),

    bodyMedium = TextStyle(
        fontFamily = robotoFontFamily,
        fontWeight = FontWeight(400),
        fontSize = 17.sp,
        lineHeight = 24.sp,
        letterSpacing = (-0.41).sp
    ),

    titleMedium = TextStyle(
        fontFamily = robotoFontFamily,
        lineHeight = 20.sp,
        letterSpacing = (-0.08).sp
    ),

    titleLarge = TextStyle(
        fontFamily = robotoFontFamily,
        fontSize = 16.sp,
        lineHeight = 20.sp,
        letterSpacing = (-0.08).sp
    ),

    titleSmall = TextStyle(
        fontFamily = robotoFontFamily,
        fontWeight = FontWeight(400),
        fontSize = 12.sp,
        lineHeight = 16.sp,
    ),

    headlineMedium = TextStyle(
        fontFamily = robotoFontFamily,
        fontWeight = FontWeight(400),
        fontSize = 22.sp,
        lineHeight = 28.sp,
    ),

    headlineSmall = TextStyle(
        fontFamily = robotoFontFamily,
        fontWeight = FontWeight(700),
        fontSize = 17.sp,
        lineHeight = 24.sp,
        letterSpacing = (-0.41).sp
    ),
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)