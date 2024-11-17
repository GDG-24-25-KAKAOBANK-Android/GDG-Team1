package com.gdg.kakaobank.presentation.benefit.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.gdg.kakaobank.presentation.benefit.screen.BenefitRoute

fun NavGraphBuilder.benefitNavGraph(
    navigator: BenefitNavigator
) {
    composable(route = "benefit") {
        BenefitRoute(navigator = navigator)
    }
}