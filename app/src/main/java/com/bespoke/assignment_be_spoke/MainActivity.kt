package com.bespoke.assignment_be_spoke

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.core.view.WindowCompat
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.bespoke.assignment_be_spoke.screen.HomeScreen
import com.bespoke.assignment_be_spoke.screen.WelcomeScreen
import com.bespoke.assignment_be_spoke.ui.theme.Assignment_be_spokeTheme
import androidx.compose.ui.graphics.Color
import androidx.core.view.WindowInsetsControllerCompat

import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.ui.Modifier

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        // Example: status bar background is white
        window.statusBarColor = android.graphics.Color.parseColor("#FFFFFF") // white

        // Set status bar icons to black (dark)
        val insetsController = WindowInsetsControllerCompat(window, window.decorView)
        insetsController.isAppearanceLightStatusBars = true // black icons

        setContent {
            Assignment_be_spokeTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = "welcome_screen",
                        modifier = Modifier.padding(WindowInsets.systemBars.asPaddingValues())
                    ) {
                        composable("welcome_screen") {
                            WelcomeScreen(navController)
                        }
                        composable("home_screen") {
                            HomeScreen()
                        }
                    }
                }
            }
        }
    }

}
