package com.gmail.freedstate.findthepairs.activity.di

import com.gmail.freedstate.findthepairs.congratulations.navigation.CongratulationsScreenNavApi
import com.gmail.freedstate.findthepairs.game.navigation.GameScreenNavApi
import com.gmail.freedstate.findthepairs.menu.navigation.MenuScreenNavApi

interface ScreensNavProviders {
    fun provideMenuScreenNavigation(): MenuScreenNavApi
    fun provideGameScreenNavigation(): GameScreenNavApi
    fun provideCongratulationsScreenNavigation(): CongratulationsScreenNavApi
}