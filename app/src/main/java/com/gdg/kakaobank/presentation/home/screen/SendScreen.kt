package com.gdg.kakaobank.presentation.home.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gdg.kakaobank.presentation.home.navigation.HomeNavigator
import com.gdg.kakaobank.ui.component.KaKaoBottomSheet
import com.gdg.kakaobank.ui.component.NextBox
import com.gdg.kakaobank.ui.theme.Black
import com.gdg.kakaobank.ui.theme.Gray
import com.gdg.kakaobank.ui.theme.White
import com.gdg.kakaobank.ui.theme.h1Semi
import com.gdg.kakaobank.ui.theme.h7Regular
import com.gdg.kakaobank.ui.theme.h7Semi

@Composable
fun SendRoute(
    navigator: HomeNavigator,
    receiver: String
) {
    SendScreen(
        onNextClick = { navigator.navigateToTransferEnd(receiver) },
        onDismissClick = { navigator.navigateToHome() },
        receiver = receiver,
        onCloseClick = { navigator.navigateBack() }
    )
}

@Composable
fun SendScreen(onNextClick : () -> Unit, onDismissClick: () -> Unit, receiver : String, onCloseClick: () -> Unit) {
    //상태 2개의 변수로 나눠서 직접 상태 수정
    val (showBottomSheet, setShowBottomSheet) = remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(White),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 20.dp, top = 20.dp),
            contentAlignment = Alignment.TopEnd
        ) {
            Text(
                text = "취소",
                style = h7Regular,
                color = Black,
                modifier = Modifier
                    .clickable { onCloseClick() }
            )
        }
        Text(
            modifier = Modifier
                .padding(top = 127.dp),
            text = receiver + "님께",
            style = h7Semi
        )
        Text(
            modifier = Modifier
                .padding(top = 38.dp),
            text = "보낼금액",
            style = h1Semi,
            color = Gray
        )
        Box(
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .padding(top = 20.dp)
                .fillMaxWidth()
                .height(1.dp)
                .background(color = Gray),
            contentAlignment = Alignment.Center
        ) {}
        Spacer(modifier = Modifier.weight(1f))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp),
            contentAlignment = Alignment.Center
        ) {
            NextBox(
                text = "다음",
                receiver = receiver,
                onNextClick = { setShowBottomSheet(true) }
            )
        }

        if (showBottomSheet) {
            KaKaoBottomSheet(
                onDismiss = {
                    setShowBottomSheet(false)
                    onDismissClick()
                },
                onConfirm = {
                    setShowBottomSheet(false)
                    onNextClick()
                },
                title = "이체 하시겠습니까?",
                subtitle = "이체하는 순간 잔액이 빠져나갑니다",
                confirmButtonText = "이체"
            )
        }
    }
}

@Composable
@Preview
fun SendScreenPreview() {
    SendScreen(onNextClick = {}, onDismissClick = {}, receiver = "이현진", onCloseClick = {})
}