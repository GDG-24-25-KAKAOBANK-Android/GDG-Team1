package com.gdg.kakaobank.presentation.goods.screen.goodsRecommend

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.gdg.kakaobank.ui.theme.White
import com.gdg.kakaobank.ui.theme.b3Bold
import com.gdg.kakaobank.ui.theme.b4Regular

@Composable
fun GoodsRecommendItem(
    data : GoodsRecommendEntity
) {
    Box(
        modifier = Modifier
            .background(color = White)
            .height(44.dp)
    ){
        Image(
            painter = painterResource(id = data.image), //리소스 id를 painter로 변환
            contentDescription = "상품-추천 이미지"
        )

        Column(
            modifier = Modifier
                .padding(horizontal = 61.dp)
                .padding(vertical = 6.dp)
        ) {
            Text(data.text1, style = b3Bold)
            Text(data.text2, style = b4Regular)
        }
    }

}