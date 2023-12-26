package com.gmail.freedstate.findthepairs.game.navigation

import android.util.Log
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.gmail.freedstate.findthepairs.congratulations.navigation.CongratulationsScreenNavApi
import com.gmail.freedstate.findthepairs.game.presentation.GameScreen
import javax.inject.Inject

class GameScreenNavImpl @Inject constructor(
    private val congratulationsScreenNavApi: CongratulationsScreenNavApi
) : GameScreenNavApi {
    override fun navigate(
        navHostController: NavHostController
    ) {
        navHostController.navigate(
            route = route()
        )
    }

    override fun route(): String {
        return "game"
    }

    override fun registerInNavigationGraph(
        navGraphBuilder: NavGraphBuilder,
        navController: NavHostController
    ) {
        congratulationsScreenNavApi.registerInNavigationGraph(
            navGraphBuilder = navGraphBuilder,
            navController = navController
        )
        navGraphBuilder.composable(
            route = route()
        ) {
            val onGameFinishedListener: (coinCount: Int) -> Unit = {
                congratulationsScreenNavApi.navigate(
                    navHostController = navController,
                    coinCountArg = it
                )
            }
            GameScreen(
                onGameFinishedListener = onGameFinishedListener
            )
            Log.d("myLog", "registerInNavigationGraph game")
        }
    }
}