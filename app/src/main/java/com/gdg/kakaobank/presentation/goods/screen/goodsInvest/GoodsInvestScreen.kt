package com.gdg.kakaobank.presentation.goods.screen.goodsInvest

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gdg.kakaobank.R
import com.gdg.kakaobank.ui.component.GoodsBox
import com.gdg.kakaobank.ui.theme.DarkGray
import com.gdg.kakaobank.ui.theme.LightGray
import com.gdg.kakaobank.ui.theme.LightMint
import com.gdg.kakaobank.ui.theme.White
import com.gdg.kakaobank.ui.theme.Yellow
import com.gdg.kakaobank.ui.theme.b2Semi
import com.gdg.kakaobank.ui.theme.h6Bold
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun GoodsInvestRoute() {
    val systemUiController = rememberSystemUiController()

    SideEffect {
        systemUiController.setStatusBarColor(
            color = White
        )
    }

    GoodsInvestScreen()
}


@Composable
fun GoodsInvestScreen() {

    val categoryList = listOf("펀드", "증권사 금융상품 투자", "국내주식 투자", "해외주식 투자")
    var selectedCategory by remember { mutableIntStateOf(1) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = White)
            .padding(top = 15.dp)
            .padding(horizontal = 24.dp)
    ) {

        GoodsBox(LightMint, "혜택 받고 간편하게\n주식계좌 개설하기")

        Spacer(modifier = Modifier.height(34.dp))

        Text(stringResource(R.string.tv_goodsInvest_title), style = h6Bold)

        Spacer(modifier = Modifier.height(15.dp))

        LazyRow(
            modifier = Modifier
                .height(32.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            itemsIndexed(categoryList) { index, category ->
                Button(
                    shape = RoundedCornerShape(10.dp),
                    contentPadding = PaddingValues(horizontal = 12.dp, vertical = 8.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (selectedCategory == index) Yellow else LightGray
                    ),
                    onClick = { selectedCategory = index }
                ) {
                    Text(
                        text = category,
                        style = b2Semi,
                        color = if (selectedCategory == index) White else DarkGray
                    )
                }
            }
        }

    }
}

@Preview
@Composable
fun GoodsInvestScreenPreview(){
    GoodsInvestScreen()
}