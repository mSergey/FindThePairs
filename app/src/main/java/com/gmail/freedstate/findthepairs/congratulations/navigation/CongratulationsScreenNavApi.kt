package com.gmail.freedstate.findthepairs.congratulations.navigation

import androidx.navigation.NavHostController
import com.gmail.freedstate.findthepairs.app.navigation.BaseNavigationApi

interface CongratulationsScreenNavApi : BaseNavigationApi {
    fun navigate(
        navHostController: NavHostController,
        coinCountArg: Int
    )
}