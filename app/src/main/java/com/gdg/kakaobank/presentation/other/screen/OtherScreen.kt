package com.gdg.kakaobank.presentation.other.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.gdg.kakaobank.presentation.other.navigation.OtherNavigator

@Composable
fun OtherRoute(
    navigator: OtherNavigator
) {
    OtherScreen()
}


@Composable
fun OtherScreen() {

    Box(modifier = Modifier.fillMaxSize()) {
        Text("전체", modifier = Modifier.align(Alignment.Center))
    }
}