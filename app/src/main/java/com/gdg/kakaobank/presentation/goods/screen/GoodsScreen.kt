package com.gdg.kakaobank.presentation.goods.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.gdg.kakaobank.presentation.goods.navigation.GoodsNavigator

@Composable
fun GoodsRoute(
    navigator: GoodsNavigator
) {
    GoodsScreen()
}


@Composable
fun GoodsScreen() {

    Box(modifier = Modifier.fillMaxSize()) {
        Text("상품", modifier = Modifier.align(Alignment.Center))
    }
}