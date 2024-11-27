package com.gdg.kakaobank.presentation.goods.screen.goodsSaving

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
import com.gdg.kakaobank.ui.theme.DarkMint
import com.gdg.kakaobank.ui.theme.White
import com.gdg.kakaobank.ui.theme.h6Bold

@Composable
fun GoodsSavingRoute() {
    val goodsSavingViewModel: GoodsSavingViewModel = hiltViewModel()
    GoodsSavingScreen(
        goodsSavingViewModel = goodsSavingViewModel
    )
}


@Composable
fun GoodsSavingScreen(
    goodsSavingViewModel: GoodsSavingViewModel
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
            GoodsBox(DarkMint, "알아서 모아주는\n저금통 만들기")

            Spacer(modifier = Modifier.height(34.dp))

            Text("저축", style = h6Bold)
        }

        items(goodsSavingViewModel.goodsSavingList) { item ->
            GoodsSavingItem(
                data = item
            )
        }

    }
}

@Preview
@Composable
fun GoodsSavingScreenPreview(
) {
    val goodsSavingViewModel: GoodsSavingViewModel = hiltViewModel()
    GoodsSavingScreen(
        goodsSavingViewModel = goodsSavingViewModel
    )
}

