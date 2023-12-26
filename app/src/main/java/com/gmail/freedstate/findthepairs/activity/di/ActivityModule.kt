package com.gmail.freedstate.findthepairs.activity.di

import com.gmail.freedstate.findthepairs.congratulations.navigation.CongratulationsScreenNavApi
import com.gmail.freedstate.findthepairs.congratulations.navigation.CongratulationsScreenNavImpl
import com.gmail.freedstate.findthepairs.game.navigation.GameScreenNavApi
import com.gmail.freedstate.findthepairs.game.navigation.GameScreenNavImpl
import com.gmail.freedstate.findthepairs.menu.navigation.MenuScreenNavApi
import com.gmail.freedstate.findthepairs.menu.navigation.MenuScreenNavImpl
import dagger.Binds
import dagger.Module

@Module
interface ActivityModule {

    @Binds
    fun bindMenuScreen(
        menuScreenNavImpl: MenuScreenNavImpl
    ): MenuScreenNavApi

    @Binds
    fun bindGameScreen(
        gameScreenNavImpl: GameScreenNavImpl
    ): GameScreenNavApi

    @Binds
    fun bindCongratulationsScreen(
        congratulationsScreenNavImpl: CongratulationsScreenNavImpl
    ): CongratulationsScreenNavApi
}