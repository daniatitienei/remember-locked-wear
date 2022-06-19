package com.atitienei_daniel.rememberlocked.presentation

import androidx.compose.runtime.Composable
import androidx.wear.compose.material.ExperimentalWearMaterialApi
import androidx.wear.compose.navigation.SwipeDismissableNavHost
import androidx.wear.compose.navigation.composable
import androidx.wear.compose.navigation.rememberSwipeDismissableNavController
import com.atitienei_daniel.rememberlocked.presentation.screens.add_new_lock.AddNewLockScreen
import com.atitienei_daniel.rememberlocked.presentation.screens.home.HomeScreen
import com.atitienei_daniel.rememberlocked.presentation.screens.update_lock_status.UpdateLockStatusScreen
import com.atitienei_daniel.rememberlocked.presentation.util.Routes

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
            AddNewLockScreen(
                onPopBackStack = {
                    swipeDismissibleNavController.popBackStack()
                }
            )
        }
        composable(Routes.UpdateLockStatusScreen) {
            UpdateLockStatusScreen()
        }
    }
}