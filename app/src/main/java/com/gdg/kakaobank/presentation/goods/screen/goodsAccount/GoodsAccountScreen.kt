package com.gdg.kakaobank.presentation.goods.screen.goodsAccount

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun GoodsAccountRoute() {
    GoodsAccountScreen()
}


@Composable
fun GoodsAccountScreen() {

    Box(modifier = Modifier.fillMaxSize()) {
        Text("통장", modifier = Modifier.align(Alignment.Center))
    }
}