package com.gdg.kakaobank.presentation.transfer.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.gdg.kakaobank.presentation.transfer.navigation.TransferNavigator

@Composable
fun SendScreen(navigator: TransferNavigator) {
    Box(modifier = Modifier.fillMaxSize()) {
        Text("송금", modifier = Modifier.align(Alignment.Center))
    }
}