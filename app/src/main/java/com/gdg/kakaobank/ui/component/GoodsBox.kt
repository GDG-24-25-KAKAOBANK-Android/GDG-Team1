package com.gdg.kakaobank.ui.component


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.gdg.kakaobank.ui.theme.White
import com.gdg.kakaobank.ui.theme.h6Bold

@Composable
fun GoodsBox (bgcolor : Color, text : String){

    Box(
        modifier = Modifier
            .height(130.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp))
            .background(color = bgcolor)
    ){

        Text(text,
            style = h6Bold,
            color = White,
            modifier = Modifier
                .padding(top = 43.dp)
                .padding(start = 27.dp))
    }






}