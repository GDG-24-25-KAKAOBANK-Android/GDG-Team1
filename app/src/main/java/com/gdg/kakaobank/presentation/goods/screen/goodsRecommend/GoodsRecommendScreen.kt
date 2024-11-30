package com.gdg.kakaobank.presentation.goods.screen.goodsRecommend

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.gdg.kakaobank.R
import com.gdg.kakaobank.ui.theme.DeepBlue
import com.gdg.kakaobank.ui.theme.White
import com.gdg.kakaobank.ui.theme.h6Bold
import com.gdg.kakaobank.ui.theme.h7Regular


@Composable
fun GoodsRecommendRoute() {
    val goodsRecommendViewModel: GoodsRecommendViewModel = hiltViewModel()
    GoodsRecommendScreen(
        goodsRecommendViewModel = goodsRecommendViewModel
    )
}


@Composable
fun GoodsRecommendScreen(
    goodsRecommendViewModel: GoodsRecommendViewModel
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
            Box(
                modifier = Modifier
                    .width(313.dp)
                    .height(297.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(20.dp))
                    .background(color = DeepBlue)
            ){
                Image(
                    painter = painterResource(id = R.drawable.ic_goods_handheart),
                    contentDescription = "손 하트 이미지",
                    modifier = Modifier.align(Alignment.Center)
                )

                Spacer(modifier = Modifier.height(42.dp))

                Column(
                    modifier = Modifier
                        .padding(top = 241.dp)
                        .padding(start = 21.dp)
                ) {
                    Text(
                        "단골사장님께만 드려요",
                        style = h6Bold,
                        color = White
                    )
                    Text(
                        "우대금리 0.24%p 제공",
                        style = h7Regular,
                        color = White,
                    )
                }
            }

            Spacer(modifier = Modifier.height(34.dp))
            Text(
                text = "이가을님 맞춤 추천",
                style = h6Bold
            )
        }

        items(goodsRecommendViewModel.goodsRecommendList) { item ->
            GoodsRecommendItem(
                data = item
            )
        }
    }
}

@Preview
@Composable
fun GoodsRecommendPreview(
){
    val goodsRecommendViewModel: GoodsRecommendViewModel = hiltViewModel()
    GoodsRecommendScreen(
        goodsRecommendViewModel = goodsRecommendViewModel
    )
}

