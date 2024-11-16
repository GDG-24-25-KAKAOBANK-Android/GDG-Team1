package com.gdg.kakaobank.presentation.goods.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.gdg.kakaobank.presentation.goods.screen.GoodsRoute

fun NavGraphBuilder.goodsNavGraph(
    navigator: GoodsNavigator
) {
    composable(route = "goods") {
        GoodsRoute(navigator = navigator)
    }
}