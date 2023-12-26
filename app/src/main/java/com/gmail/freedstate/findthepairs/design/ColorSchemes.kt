package com.gmail.freedstate.findthepairs.design

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp

val LightColors = lightColorScheme(
    primary = button_background
)

val DarkColors = darkColorScheme()

data class ExtendedAppColors constructor(
    val guessedCellBackground: Color,
    val notGuessedCellBackground: Color,
    val congratulationsCoinBackground: Color,
    val gameLogoBackground: Color,
    val backgroundTextColor: Color,
    val clockBackground: Color,
    val arrowUpBackground : Color,
    val privacyBackground: Color
) {
    companion object {

        val lightColors: ExtendedAppColors
            get() = ExtendedAppColors(
                notGuessedCellBackground = not_guessed_cell_background,
                guessedCellBackground = guessed_cell_background,
                congratulationsCoinBackground = congratulations_coin_background,
                gameLogoBackground = game_logo_background,
                backgroundTextColor = background_text_color,
                clockBackground = clock_background,
                arrowUpBackground = arrow_up_background,
                privacyBackground = privacy_background
            )
        val darkColors: ExtendedAppColors
            get() = ExtendedAppColors(
                notGuessedCellBackground = not_guessed_cell_background,
                guessedCellBackground = guessed_cell_background,
                congratulationsCoinBackground = congratulations_coin_background,
                gameLogoBackground = game_logo_background,
                backgroundTextColor = background_text_color,
                clockBackground = clock_background,
                arrowUpBackground = arrow_up_background,
                privacyBackground = privacy_background
            )

        val unspecified: ExtendedAppColors
            get() = ExtendedAppColors(
                notGuessedCellBackground = Color.Unspecified,
                guessedCellBackground = Color.Unspecified,
                congratulationsCoinBackground = Color.Unspecified,
                gameLogoBackground = Color.Unspecified,
                backgroundTextColor = Color.Unspecified,
                clockBackground = Color.Unspecified,
                arrowUpBackground = Color.Unspecified,
                privacyBackground = Color.Unspecified
            )
    }
}

data class ExtendedAppDimens constructor(
    val dimenOne: Dp,
    val dimenTwo: Dp
) {
    companion object {
        val myDimens: ExtendedAppDimens
            get() = ExtendedAppDimens(
                dimenOne = dimen_one,
                dimenTwo = dimen_two,
            )

        val unspecified: ExtendedAppDimens
            get() = ExtendedAppDimens(
                dimenOne = dimen_one,
                dimenTwo = dimen_two,
            )
    }
}