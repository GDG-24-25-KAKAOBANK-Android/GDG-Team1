package com.gdg.kakaobank.presentation.goods.screen.goodsSaving

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gdg.kakaobank.ui.theme.DeepBlue
import com.gdg.kakaobank.ui.theme.White
import com.gdg.kakaobank.ui.theme.Yellow
import com.gdg.kakaobank.ui.theme.b3Bold
import com.gdg.kakaobank.ui.theme.b4Bold
import com.gdg.kakaobank.ui.theme.b4Regular

@Composable
fun GoodsSavingItem(
    data : GoodsSavingEntity
) {
    Box(
        modifier = Modifier
            .background(color = White)
            .height(44.dp)
            .fillMaxWidth()
    ){
        Box(
            modifier = Modifier
                .size(44.dp) // 원의 크기
                .clip(CircleShape) // 원 모양으로 자르기
                .background(Yellow) // 원의 배경 색상
        )

        Column (
            modifier = Modifier
                .padding(horizontal = 60.dp)
                .padding(vertical = 6.dp)

        ){
            Text(data.text1, style = b3Bold)
            Text(data.text2, style = b4Regular)
        }

        Text(
            data.rate,
            modifier = Modifier
                .padding(end= 20.dp)
                .padding(top = 22.dp)
                .align(Alignment.TopEnd),
            style = b4Bold,
            color = DeepBlue,
            )

    }
}

@Preview
@Composable
fun GoodsSavingItemPreview(){
    GoodsSavingEntity("혜택 좋은 신용카드", "9개 카드사의 혜택 좋은 카드만 모아", "최고 연 3.70%")
}