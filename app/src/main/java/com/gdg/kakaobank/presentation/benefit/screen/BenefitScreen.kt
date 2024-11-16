package com.gdg.kakaobank.presentation.benefit.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.gdg.kakaobank.presentation.benefit.navigation.BenefitNavigator

@Composable
fun BenefitRoute(
    navigator: BenefitNavigator
) {
    BenefitScreen()
}


@Composable
fun BenefitScreen() {

    Box(modifier = Modifier.fillMaxSize()) {
        Text("혜택", modifier = Modifier.align(Alignment.Center))
    }

}