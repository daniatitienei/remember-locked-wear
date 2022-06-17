package com.example.rememberyouclosed.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.wear.compose.material.ExperimentalWearMaterialApi
import androidx.wear.compose.material.Text
import androidx.wear.compose.navigation.SwipeDismissableNavHost
import androidx.wear.compose.navigation.composable
import androidx.wear.compose.navigation.rememberSwipeDismissableNavController
import com.example.rememberyouclosed.presentation.screens.home.HomeScreen
import com.example.rememberyouclosed.presentation.util.Routes

@OptIn(ExperimentalWearMaterialApi::class)
@Composable
fun Navigation() {

    val swipeDismissibleNavController = rememberSwipeDismissableNavController()

    SwipeDismissableNavHost(
        navController = swipeDismissibleNavController,
        startDestination = Routes.HomeScreen
    ) {
        composable(Routes.HomeScreen) {
            HomeScreen(
                onNavigate = { destination ->
                    swipeDismissibleNavController.navigate(destination.route)
                }
            )
        }
        composable(Routes.AddNewLockScreen) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize(align = Alignment.Center)
                    .background(Color.Black)
            ) {
                Text(text = "Add new lock screen")
            }
        }
        composable(Routes.UpdateLockStatusScreen) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize(align = Alignment.Center)
                    .background(Color.Black)
            ) {
                Text(text = "Update lock status screen")
            }
        }
    }
}