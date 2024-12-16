package com.gdg.kakaobank.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.gdg.kakaobank.ui.theme.Black
import com.gdg.kakaobank.ui.theme.MainYellow
import com.gdg.kakaobank.ui.theme.h7Bold

@Composable
fun NextBox(text: String, receiver : String, onNextClick: () -> Unit) {
    Box(
        modifier = Modifier
            .height(57.dp)
            .width(319.dp)
            .clip(RoundedCornerShape(40.dp))
            .background(color = MainYellow)
            .clickable { onNextClick() },
        contentAlignment = Alignment.Center
    ){
        Text(
            text,
            style = h7Bold,
            color = Black
        )
    }

}