package com.gdg.kakaobank.presentation.benefit.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gdg.kakaobank.R
import com.gdg.kakaobank.ui.theme.LightMint
import com.gdg.kakaobank.ui.theme.h6Bold

@Composable
fun BenefitLikeItem(
    color: Color,
    text: String
) {
    val isFavorite = remember { mutableStateOf(false) }

    val heartIconId = if (isFavorite.value) {
        R.drawable.ic_benefit_selected_heart
    } else {
        R.drawable.ic_benefit_unselected_heart
    }

    Box(
        modifier = Modifier
            .width(205.dp)
            .height(84.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(color)
    ) {
        Text(
            "24-25 \n$text",
            style = h6Bold,
            modifier = Modifier
                .padding(horizontal = 19.dp)
                .padding(top = 22.dp)
        )

        Image(
            painter = painterResource(id = heartIconId),
            contentDescription = null,
            modifier = Modifier
                .padding(end = 10.dp, top = 10.dp)
                .align(Alignment.TopEnd)
                .clickable {
                    // 클릭 시 좋아요 상태를 토글
                    isFavorite.value = !isFavorite.value
                }
        )
    }
}

@Preview
@Composable
fun BenefitLikeItemPreview(){
    BenefitLikeItem(LightMint, "GDG Android")
}
