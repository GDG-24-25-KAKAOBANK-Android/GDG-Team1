package com.gdg.kakaobank.presentation.home.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.gdg.kakaobank.presentation.home.screen.HomeRoute
import com.gdg.kakaobank.presentation.home.screen.SendRoute
import com.gdg.kakaobank.presentation.home.screen.TransferRoute

fun NavGraphBuilder.homeNavGraph(
    navigator: HomeNavigator
) {
    composable(route = "home") {
        HomeRoute(navigator = navigator)
    }

    composable(route = "transfer") {
        TransferRoute(navigator = navigator)
    }

    composable(
        route = "send?receiver={receiver}",
        arguments = listOf(navArgument("receiver") { type = NavType.StringType })
    ) { backStackEntry ->
        val receiver = backStackEntry.arguments?.getString("receiver") ?: "" // receiver 값 읽기
        SendRoute(navigator = navigator, receiver = receiver)
    }

}