package com.gdg.kakaobank.presentation.home.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.gdg.kakaobank.presentation.home.screen.HomeRoute
import com.gdg.kakaobank.presentation.transfer.TransferScreen

fun NavGraphBuilder.homeNavGraph(
    navigator: HomeNavigator
) {
    composable(route = "home") {
        HomeRoute(navigator = navigator)
    }

    composable(route = "transfer") {
        TransferScreen(navigator = navigator)
    }
}