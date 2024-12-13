package com.gdg.kakaobank.presentation.main.screen

import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.gdg.kakaobank.presentation.auth.navigation.AuthNavigator
import com.gdg.kakaobank.presentation.benefit.navigation.BenefitNavigator
import com.gdg.kakaobank.presentation.goods.navigation.GoodsNavigator
import com.gdg.kakaobank.presentation.home.navigation.HomeNavigator
import com.gdg.kakaobank.presentation.main.navigation.MainNavigator
import com.gdg.kakaobank.presentation.navigator.KakaoNavHost
import com.gdg.kakaobank.presentation.other.navigation.OtherNavigator
import com.gdg.kakaobank.presentation.transfer.navigation.TransferNavigator
import com.gdg.kakaobank.ui.theme.KakaoBankTheme
import com.gdg.kakaobank.ui.theme.White
import com.gdg.kakaobank.util.toast
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        setContent {
            KakaoBankTheme {
                val context = LocalContext.current
                var backPressedState by remember { mutableStateOf(true) }
                var backPressedTime = 0L
                val systemUiController = rememberSystemUiController()
                val lifecycleOwner = LocalLifecycleOwner.current

                BackHandler(enabled = backPressedState) {
                    if (System.currentTimeMillis() - backPressedTime <= 3000) {
                        (context as Activity).finish()
                    } else {
                        backPressedState = true
                        context.toast("한 번 더 누르면 종료돼요")
                    }
                    backPressedTime = System.currentTimeMillis()
                }

                SideEffect {
                    systemUiController.setStatusBarColor(
                        color = White
                    )
                }

                DisposableEffect(key1 = lifecycleOwner) {
                    onDispose {
                        systemUiController.setStatusBarColor(
                            color = Transparent
                        )
                    }
                }

                val navController = rememberNavController()
                val authNavigator = remember(navController) { AuthNavigator(navController) }
                val mainNavigator = remember(navController) { MainNavigator(navController) }
                val homeNavigator = remember(navController) { HomeNavigator(navController) }
                val otherNavigator = remember(navController) { OtherNavigator(navController) }
                val goodsNavigator = remember(navController) { GoodsNavigator(navController) }
                val benefitNavigator = remember(navController) { BenefitNavigator(navController) }
                val transferNavigator = remember(navController) { TransferNavigator(navController) }

                Scaffold(
                    containerColor = MaterialTheme.colorScheme.background,
                    content = { paddingValues ->
                        KakaoNavHost(
                            modifier = Modifier
                                .padding(paddingValues),
                            navController = navController,
                            mainNavigator = mainNavigator,
                            homeNavigator = homeNavigator,
                            authNavigator = authNavigator,
                            goodsNavigator = goodsNavigator,
                            benefitNavigator = benefitNavigator,
                            otherNavigator = otherNavigator,
                            transferNavigator = transferNavigator
                        )
                    }
                )
            }
        }
    }
}