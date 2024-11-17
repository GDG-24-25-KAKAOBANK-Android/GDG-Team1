package com.gdg.kakaobank.presentation.other.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.gdg.kakaobank.presentation.other.screen.OtherRoute

fun NavGraphBuilder.otherNavGraph(
    navigator: OtherNavigator
) {
    composable(route = "other") {
        OtherRoute(navigator = navigator)
    }
}