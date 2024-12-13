package com.gdg.kakaobank.presentation.home.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.gdg.kakaobank.presentation.home.screen.HomeRoute
import com.gdg.kakaobank.presentation.transfer.navigation.TransferNavigator
import com.gdg.kakaobank.presentation.transfer.navigation.transferNavGraph
import com.gdg.kakaobank.presentation.transfer.screen.TransferRoute
import com.gdg.kakaobank.presentation.transfer.screen.TransferScreen

fun NavGraphBuilder.homeNavGraph(
    navigator: HomeNavigator
) {
    composable(route = "home") {
        HomeRoute(navigator = navigator)
    }

    composable(route = "transfer") {
        TransferRoute(navigator = TransferNavigator(navigator.navController),
            homeNavigator = navigator
        )
    }

    //transferNavGraph(navigator = TransferNavigator(navigator.navController))

}