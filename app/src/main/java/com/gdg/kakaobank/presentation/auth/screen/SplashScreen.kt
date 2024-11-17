package com.gdg.kakaobank.presentation.auth.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import kotlinx.coroutines.delay


@Composable
fun SplashScreen(navController: NavController, modifier: Modifier = Modifier) {

    LaunchedEffect(Unit) {
        delay(2500) // 2.5초 대기
        navController.navigate("main") { // main 화면으로 이동
            popUpTo("splash") {
                inclusive = true
            }
            launchSingleTop = true
        }
    }

    Box(modifier = Modifier.fillMaxSize()) {
        Text("스플래시", modifier = Modifier.align(Alignment.Center))
    }

}