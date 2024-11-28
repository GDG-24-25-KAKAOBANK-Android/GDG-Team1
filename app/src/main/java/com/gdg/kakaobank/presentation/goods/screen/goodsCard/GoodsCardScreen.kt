package com.gdg.kakaobank.presentation.goods.screen.goodsCard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.gdg.kakaobank.ui.component.GoodsBox
import com.gdg.kakaobank.ui.theme.White
import com.gdg.kakaobank.ui.theme.Yellow
import com.gdg.kakaobank.ui.theme.h6Bold

@Composable
fun GoodsCardRoute() {
    val goodsCardViewModel: GoodsCardViewModel = hiltViewModel()
    GoodsCardScreen(
        goodsCardViewModel = goodsCardViewModel
    )
}


@Composable
fun GoodsCardScreen(
    goodsCardViewModel: GoodsCardViewModel
) {

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(18.dp),
        modifier = Modifier
            .fillMaxSize()
            .background(color = White)
            .padding(top = 15.dp)
            .padding(horizontal = 24.dp)
    ) {

        item{
            GoodsBox( Yellow, "혜택 좋은 카드 쓰고\n현금 캐시백 받기")

            Spacer(modifier = Modifier.height(34.dp))

            Text("투자", style = h6Bold)
        }

        items(goodsCardViewModel.goodsCardList) { item ->
            GoodsCardItem(
                data = item
            )
        }

    }
}

@Preview
@Composable
fun GoodsCardScreenPreview(
){
    val goodsCardViewModel: GoodsCardViewModel = hiltViewModel()
    GoodsCardScreen(
        goodsCardViewModel = goodsCardViewModel
    )

}