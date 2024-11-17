package com.gdg.kakaobank.presentation.goods.navigation

import androidx.navigation.NavController

class GoodsNavigator(
    val navController: NavController
) {
    fun navigateBack() {
        navController.popBackStack()
    }
}