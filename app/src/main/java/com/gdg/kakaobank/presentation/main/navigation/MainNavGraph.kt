package com.gdg.kakaobank.presentation.main.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.gdg.kakaobank.presentation.benefit.navigation.BenefitNavigator
import com.gdg.kakaobank.presentation.goods.navigation.GoodsNavigator
import com.gdg.kakaobank.presentation.home.navigation.HomeNavigator
import com.gdg.kakaobank.presentation.main.screen.MainRoute
import com.gdg.kakaobank.presentation.other.navigation.OtherNavigator

fun NavGraphBuilder.mainNavGraph(
    mainNavigator: MainNavigator,
    homeNavigator: HomeNavigator,
    benefitNavigator: BenefitNavigator,
    goodsNavigator: GoodsNavigator,
    otherNavigator: OtherNavigator,
) {
    composable(route = "main") {
        MainRoute(navigator = mainNavigator)
    }
}