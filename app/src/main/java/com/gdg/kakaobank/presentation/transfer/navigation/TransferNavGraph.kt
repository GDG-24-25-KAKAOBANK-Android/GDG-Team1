package com.gdg.kakaobank.presentation.transfer.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.gdg.kakaobank.presentation.transfer.screen.SendScreen

fun NavGraphBuilder.transferNavGraph(
    navigator: TransferNavigator
) {
    composable(route = "send") {
        SendScreen(navigator = navigator)
    }
}