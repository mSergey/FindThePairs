package com.gmail.freedstate.findthepairs.activity.di

import com.gmail.freedstate.findthepairs.activity.MainActivity
import com.gmail.freedstate.findthepairs.congratulations.navigation.CongratulationsScreenNavApi
import com.gmail.freedstate.findthepairs.congratulations.navigation.CongratulationsScreenNavImpl
import com.gmail.freedstate.findthepairs.game.navigation.GameScreenNavApi
import com.gmail.freedstate.findthepairs.menu.navigation.MenuScreenNavApi
import com.gmail.freedstate.findthepairs.menu.navigation.MenuScreenNavImpl
import dagger.Binds
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ActivityModule::class])
interface ActivityComponent : ScreensNavProviders {
    fun injectMainActivity(mainActivity: MainActivity)
}