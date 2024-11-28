package com.gdg.kakaobank.presentation.goods.screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.gdg.kakaobank.presentation.goods.navigation.GoodsNavigator
import com.gdg.kakaobank.ui.theme.White
import com.gdg.kakaobank.ui.theme.h4Bold
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun GoodsRoute(
    navigator: GoodsNavigator
) {
    val systemUiController = rememberSystemUiController()

    SideEffect {
        systemUiController.setStatusBarColor(
            color = White
        )
    }


    GoodsScreen()
}


@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun GoodsScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier.background(White),
                title = {
                    Text(
                        text = "상품",
                        style = h4Bold,
                    )
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = White
                )
            )
        }
    ) { innerPadding ->

        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(color = White)
        ) {
            GoodsTabPager()
        }
    }

}

@Preview
@Composable
fun GoodsScreenPreview(){
    GoodsScreen()
}