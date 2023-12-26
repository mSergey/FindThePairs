package com.gmail.freedstate.findthepairs.congratulations.navigation

import android.util.Log
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.gmail.freedstate.findthepairs.congratulations.presentation.CongratulationsScreen
import javax.inject.Inject

private const val COIN_COUNT = "coinCount"

class CongratulationsScreenNavImpl @Inject constructor()
    : CongratulationsScreenNavApi {
    override fun navigate(
        navHostController: NavHostController,
        coinCountArg: Int
    ) {
        navHostController.navigate(
            route = route() + coinCountArg
        )
    }

    override fun route(): String {
        return "congratulations"
    }

    override fun registerInNavigationGraph(
        navGraphBuilder: NavGraphBuilder,
        navController: NavHostController
    ) {
        navGraphBuilder.composable(
            route = route() + "{$COIN_COUNT}",
            arguments = listOf(
                navArgument(COIN_COUNT) { type = NavType.IntType }
            )
        ) {
            val coins = it.arguments?.getInt(COIN_COUNT) ?: 0
            Log.d("myLog", "registerInNavigationGraph congratulations")
            CongratulationsScreen(coinCount = coins)
        }
    }
}