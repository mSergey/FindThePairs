package com.gmail.freedstate.findthepairs.menu.navigation

import android.util.Log
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.gmail.freedstate.findthepairs.game.navigation.GameScreenNavApi
import com.gmail.freedstate.findthepairs.menu.presentation.MenuScreen
import javax.inject.Inject

class MenuScreenNavImpl @Inject constructor(
    private val gameScreenNavApi: GameScreenNavApi
) : MenuScreenNavApi {
    override fun navigate() {}

    override fun route(): String {
        return "menu"
    }

    override fun registerInNavigationGraph(
        navGraphBuilder: NavGraphBuilder,
        navController: NavHostController
    ) {
        gameScreenNavApi.registerInNavigationGraph(
            navGraphBuilder = navGraphBuilder,
            navController = navController
        )
        val playButtonClickListener: () -> Unit = {
            gameScreenNavApi.navigate(
                navHostController = navController
            )
        }
        navGraphBuilder.composable(
            route = route()
        ) {
            MenuScreen(
                playButtonClickListener = playButtonClickListener
            )
        }
        Log.d("myLog", "registerInNavigationGraph menu")

    }
}