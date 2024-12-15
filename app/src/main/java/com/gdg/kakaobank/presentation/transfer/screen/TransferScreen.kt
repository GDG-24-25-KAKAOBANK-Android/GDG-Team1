package com.gdg.kakaobank.presentation.transfer.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gdg.kakaobank.R
import com.gdg.kakaobank.presentation.home.navigation.HomeNavigator
import com.gdg.kakaobank.ui.component.NextBox
import com.gdg.kakaobank.ui.theme.Black
import com.gdg.kakaobank.ui.theme.Gray
import com.gdg.kakaobank.ui.theme.White
import com.gdg.kakaobank.ui.theme.b3Bold
import com.gdg.kakaobank.ui.theme.b4Regular
import com.gdg.kakaobank.ui.theme.h5Bold
import com.gdg.kakaobank.ui.theme.h7Regular
import com.gdg.kakaobank.ui.theme.h7Semi

@Composable
fun TransferRoute(
    navigator: HomeNavigator
) {
    TransferScreen(
        onNextClick = { navigator.navigateToSend() },
        onCloseClick = { navigator.navigateBack()}
        )
}

@Composable
fun TransferScreen(onNextClick: () -> Unit, onCloseClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(White)
    ) {
        TransferTopBar(onCloseClick = onCloseClick)
        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 50.dp),
            verticalArrangement = Arrangement.spacedBy(31.dp),
        ) {
            item { TransferItem(name = "이가을", amount = "10,000원") }
            item { TransferItem(name = "김나현", amount = "20,000원") }
            item { TransferItem(name = "백서연", amount = "300,000원") }
            item { TransferItem(name = "이현진", amount = "400원") }
            item { TransferItem(name = "조영서", amount = "5,000원") }
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp),
            contentAlignment = Alignment.Center
        ){
            NextBox(
                text = "다음",
                onNextClick = onNextClick
            )
        }
    }

}

@Composable
fun TransferTopBar(onCloseClick: () -> Unit) {
    Column {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 20.dp, top = 20.dp),
            contentAlignment = Alignment.TopEnd
        ) {
            Text(
                text = "닫기",
                style = h7Regular,
                color = Black,
                modifier = Modifier
                    .clickable { onCloseClick() }
            )
        }

        Text(
            modifier = Modifier
                .padding(start = 50.dp, top = 81.dp),
            text = stringResource(R.string.transfer),
            style = h5Bold,
            color = Black
        )
        Spacer(modifier = Modifier.size(21.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 50.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_transfer_search),
                contentDescription = "검색",
                tint = Gray,
                modifier = Modifier.size(20.dp)
            )
            Spacer(modifier = Modifier.size(15.dp))
            Text(
                text = "받는사람 이름 또는 계좌번호",
                style = b4Regular,
                color = Gray
            )
        }
        Spacer(modifier = Modifier.size(11.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth(),
            contentAlignment = Alignment.Center,
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_transfer_line),
                contentDescription = "라인",
                tint = Gray,
            )
        }
        Spacer(modifier = Modifier.size(38.dp))
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 50.dp, bottom = 23.dp),
            text = "최근 이체",
            style = h7Semi,
            color = Black
        )
    }
}

@Composable
fun TransferItem(name: String, amount: String) {
    Column(
        modifier = Modifier
            .padding(vertical = 10.dp)
            .fillMaxWidth()
    ) {
        Text(
            text = name,
            style = b3Bold,
            color = Black
        )
        Text(
            text = amount,
            style = b4Regular,
            color = Black
        )
    }
}

@Preview
@Composable
fun TransferScreenPreview(){
    TransferScreen(onNextClick = {}, onCloseClick={})
}



