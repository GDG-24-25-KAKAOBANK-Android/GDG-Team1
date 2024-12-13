package com.gdg.kakaobank.presentation.navigator

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.gdg.kakaobank.presentation.auth.navigation.AuthNavigator
import com.gdg.kakaobank.presentation.auth.screen.SplashScreen
import com.gdg.kakaobank.presentation.benefit.navigation.BenefitNavigator
import com.gdg.kakaobank.presentation.benefit.navigation.benefitNavGraph
import com.gdg.kakaobank.presentation.goods.navigation.GoodsNavigator
import com.gdg.kakaobank.presentation.goods.navigation.goodsNavGraph
import com.gdg.kakaobank.presentation.home.navigation.HomeNavigator
import com.gdg.kakaobank.presentation.home.navigation.homeNavGraph
import com.gdg.kakaobank.presentation.main.navigation.MainNavigator
import com.gdg.kakaobank.presentation.main.navigation.mainNavGraph
import com.gdg.kakaobank.presentation.other.navigation.OtherNavigator
import com.gdg.kakaobank.presentation.other.navigation.otherNavGraph
import com.gdg.kakaobank.presentation.transfer.navigation.TransferNavigator
import com.gdg.kakaobank.presentation.transfer.navigation.transferNavGraph


@Composable
fun KakaoNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    mainNavigator: MainNavigator,
    homeNavigator: HomeNavigator,
    authNavigator: AuthNavigator,
    goodsNavigator: GoodsNavigator,
    benefitNavigator: BenefitNavigator,
    otherNavigator: OtherNavigator,
    transferNavigator: TransferNavigator
    ) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        NavHost(
            navController = navController,
            startDestination = "splash",
        ) {
            composable("splash") { SplashScreen(navController = authNavigator.navController) }

            mainNavGraph(
                mainNavigator,
                homeNavigator,
                benefitNavigator,
                goodsNavigator,
                otherNavigator
            )
            homeNavGraph(homeNavigator)
            benefitNavGraph(benefitNavigator)
            goodsNavGraph(goodsNavigator)
            otherNavGraph(otherNavigator)
            transferNavGraph(transferNavigator)
        }
    }
}