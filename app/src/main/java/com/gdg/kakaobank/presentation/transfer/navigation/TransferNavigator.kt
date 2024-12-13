package com.gdg.kakaobank.presentation.transfer.navigation

import androidx.navigation.NavController

class TransferNavigator(
    val navController: NavController
) {
    fun navigateToSend() {
        navController.navigate("send")
    }
}