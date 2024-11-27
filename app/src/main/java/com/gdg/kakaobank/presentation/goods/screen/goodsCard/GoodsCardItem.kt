package com.gdg.kakaobank.presentation.goods.screen.goodsCard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.gdg.kakaobank.ui.theme.White
import com.gdg.kakaobank.ui.theme.b3Bold
import com.gdg.kakaobank.ui.theme.b4Regular

@Composable
fun GoodsCardItem(
    data : GoodsCardEntity
    ) {
    Box(
        modifier = Modifier
            .background(color = White)
            .height(44.dp)
    ){
        Box(
            modifier = Modifier
                .size(44.dp) // 원의 크기
                .clip(CircleShape) // 원 모양으로 자르기
                .background(data.circleColor) // 원의 배경 색상
        )

        Column (
            modifier = Modifier
                .padding(horizontal = 61.dp)
                .padding(vertical = 6.dp)

        ){
            Text(data.text1, style = b3Bold)
            Text(data.text2, style = b4Regular)
        }

    }
}

