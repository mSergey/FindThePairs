package com.gmail.freedstate.findthepairs.app.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController

interface BaseNavigationApi {
    fun route(): String
    fun registerInNavigationGraph(
        navGraphBuilder: NavGraphBuilder,
        navController: NavHostController
    )
}