package com.gdg.kakaobank.presentation.transfer

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.gdg.kakaobank.presentation.home.navigation.HomeNavigator

@Composable
fun TransferScreen(navigator: HomeNavigator) {
    Box(modifier = Modifier.fillMaxSize()) {
        Text("이체", modifier = Modifier.align(Alignment.Center))
    }
}