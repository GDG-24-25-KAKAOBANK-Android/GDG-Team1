package com.gdg.kakaobank.presentation.auth.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.gdg.kakaobank.R
import com.gdg.kakaobank.ui.theme.MainYellow
import kotlinx.coroutines.delay


@Composable
fun SplashScreen(navController: NavController) {

    LaunchedEffect(Unit) {
        delay(2500) // 2.5초 대기
        navController.navigate("main") { // main 화면으로 이동
            popUpTo("splash") {
                inclusive = true
            }
            launchSingleTop = true
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MainYellow)
            .padding(16.dp),
        contentAlignment = Alignment.TopCenter
        ) {
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(top = 100.dp)
        ){
            Image(
                imageVector = ImageVector.vectorResource(R.drawable.ic_splash_logo),
                contentDescription = "카카오뱅크 로고",
                modifier = Modifier.size(75.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
        }
    }

}