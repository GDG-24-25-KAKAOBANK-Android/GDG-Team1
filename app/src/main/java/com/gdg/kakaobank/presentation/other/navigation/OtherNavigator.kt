package com.gdg.kakaobank.presentation.other.navigation

import androidx.navigation.NavController

class OtherNavigator(
    val navController: NavController
) {
    fun navigateBack() {
        navController.popBackStack()
    }
}