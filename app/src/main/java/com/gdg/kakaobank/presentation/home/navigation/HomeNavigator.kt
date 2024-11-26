package com.gdg.kakaobank.presentation.home.navigation

import androidx.navigation.NavController

class HomeNavigator(
    val navController: NavController
) {
    fun navigateBack() {
        navController.popBackStack()
    }
    fun navigateToTransfer() {
        navController.navigate("transfer")
    }
}