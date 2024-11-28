package com.gdg.kakaobank.presentation.goods.screen.goodsRecommend

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.gdg.kakaobank.presentation.goods.navigation.GoodsNavigator

@Composable
fun GoodsRecommendRoute() {
    GoodsRecommendScreen()
}


@Composable
fun GoodsRecommendScreen() {

    Box(modifier = Modifier.fillMaxSize()) {
        Text("추천", modifier = Modifier.align(Alignment.Center))
    }
}