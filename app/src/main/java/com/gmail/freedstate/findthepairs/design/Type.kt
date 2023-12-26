package com.gmail.freedstate.findthepairs.design

import androidx.compose.material3.Typography
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType

// Set of Material typography styles to start with
val baseTypography = Typography()

val Typography = Typography(
    headlineSmall = baseTypography.headlineSmall.copy(
        color = background_text_color
    ),
    bodyLarge = baseTypography.bodyLarge.copy(
        fontWeight = FontWeight(
            weight = 450
        ),
        fontSize = TextUnit(18F, TextUnitType.Sp)

    ),
    headlineMedium = baseTypography.headlineMedium.copy(
        fontWeight = FontWeight(
            weight = 450
        )
    ),
    bodyMedium = baseTypography.bodyMedium.copy(
        fontWeight = FontWeight(
            weight = 500
        ),
        lineHeight = TextUnit(16f, TextUnitType.Sp)
    ),
    bodySmall = baseTypography.bodySmall.copy(
        fontWeight = FontWeight(
            weight = 500
        )
    ),
    titleLarge = baseTypography.titleLarge.copy(
        fontWeight = FontWeight(
            weight = 400
        )
    )
)