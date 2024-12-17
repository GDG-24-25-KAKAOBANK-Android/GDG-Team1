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
    fun navigateToSend(receiver: String) {
        navController.navigate("send?receiver=$receiver")
    }
    fun navigateToTransferEnd(receiver: String) {
        navController.navigate("transferEnd?receiver=$receiver")
    }
    fun navigateToHome() {
        navController.navigate("home")
    }
}