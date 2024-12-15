package com.gdg.kakaobank.presentation.home.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.gdg.kakaobank.presentation.home.screen.HomeRoute
import com.gdg.kakaobank.presentation.transfer.screen.SendScreen
import com.gdg.kakaobank.presentation.transfer.screen.TransferRoute

fun NavGraphBuilder.homeNavGraph(
    navigator: HomeNavigator
) {
    composable(route = "home") {
        HomeRoute(navigator = navigator)
    }

    composable(route = "transfer") {
        TransferRoute(navigator = navigator)
    }

    composable(route = "send") {
        SendScreen(navigator = navigator)
    }

    //transferNavGraph(navigator = TransferNavigator(navigator.navController))

}