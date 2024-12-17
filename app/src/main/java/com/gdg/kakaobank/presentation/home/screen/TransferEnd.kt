package com.gdg.kakaobank.presentation.home.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gdg.kakaobank.R
import com.gdg.kakaobank.presentation.home.navigation.HomeNavigator
import com.gdg.kakaobank.ui.component.NextBox
import com.gdg.kakaobank.ui.theme.White
import com.gdg.kakaobank.ui.theme.h5Semi

@Composable
fun TransferEndRoute(
    navigator: HomeNavigator,
    receiver: String
) {
    TransferEndScreen(
        onNextClick = { navigator.navigateToHome()},
        receiver = receiver,
    )
}

@Composable
fun TransferEndScreen(onNextClick: () -> Unit, receiver: String) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(White),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            imageVector = ImageVector.vectorResource(R.drawable.ic_transferend_checked),
            contentDescription = "null",
            modifier = Modifier
                .padding(top = 135.dp)
                .size(140.dp)
        )
        Text(
            text = receiver + "님께",
            modifier = Modifier
                .padding(top = 36.dp),
            style = h5Semi
        )
        Text(
            text = "이체가 완료되었습니다",
            style = h5Semi
        )
        Spacer(modifier = Modifier.weight(1f))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp),
            contentAlignment = Alignment.Center
        ) {
            NextBox(
                text = "돌아가기",
                receiver = "",
                onNextClick = onNextClick
            )
        }
    }
}

@Composable
@Preview
fun TransferEndPreview() {
    TransferEndScreen(
        onNextClick = {},
        receiver = "이현진",
    )
}