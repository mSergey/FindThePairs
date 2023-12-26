package com.gmail.freedstate.findthepairs.game.navigation

import androidx.navigation.NavHostController
import com.gmail.freedstate.findthepairs.app.navigation.BaseNavigationApi

interface GameScreenNavApi : BaseNavigationApi {
    fun navigate(
        navHostController: NavHostController
    )
}