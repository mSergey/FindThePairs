package com.gmail.freedstate.findthepairs.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.gmail.freedstate.findthepairs.activity.di.DaggerActivityComponent
import com.gmail.freedstate.findthepairs.app.navigation.AppNavGraph
import com.gmail.freedstate.findthepairs.design.FindThePairsTheme
import com.gmail.freedstate.findthepairs.menu.navigation.MenuScreenNavApi
import javax.inject.Inject

class MainActivity : ComponentActivity() {

    @Inject
    lateinit var menuScreenNavApi: MenuScreenNavApi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        DaggerActivityComponent
            .create()
            .injectMainActivity(this)

        setContent {
            val navController = rememberNavController()
            val startScreen = remember { menuScreenNavApi }
            FindThePairsTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppNavGraph(
                        navController = navController,
                        menuScreenNavApi = startScreen,
                        modifier = Modifier
                    )
                }
            }
        }
    }
}