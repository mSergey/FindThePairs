package com.gmail.freedstate.findthepairs.app.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost


@Composable
fun AppNavGraph(
    navController: NavHostController,
    menuScreenNavApi: BaseNavigationApi,
    modifier: Modifier
) {
    NavHost(
        navController = navController,
        startDestination = menuScreenNavApi.route(),
        modifier = Modifier.then(modifier)
    ) {
        menuScreenNavApi.registerInNavigationGraph(
            navGraphBuilder = this,
            navController = navController
        )
    }
}