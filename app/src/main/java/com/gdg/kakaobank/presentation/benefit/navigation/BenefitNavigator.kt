package com.gdg.kakaobank.presentation.benefit.navigation

import androidx.navigation.NavController

class BenefitNavigator(
    val navController: NavController
) {
    fun navigateBack() {
        navController.popBackStack()
    }
}