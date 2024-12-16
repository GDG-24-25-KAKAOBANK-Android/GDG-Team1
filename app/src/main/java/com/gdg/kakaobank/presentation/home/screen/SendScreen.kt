package com.gdg.kakaobank.presentation.home.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.gdg.kakaobank.presentation.home.navigation.HomeNavigator

@Composable
fun SendRoute(
    navigator: HomeNavigator,
    receiver : String
) {
    SendScreen(
        onNextClick = {},
        receiver = receiver
    )
}

@Composable
fun SendScreen(onNextClick : () -> Unit, receiver : String) {
    Column(modifier = Modifier.fillMaxSize()) {
        Text("송금")
        Text(receiver)
    }
}