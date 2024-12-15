package com.gdg.kakaobank.presentation.home.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.gdg.kakaobank.R
import com.gdg.kakaobank.presentation.home.navigation.HomeNavigator
import com.gdg.kakaobank.ui.theme.Black
import com.gdg.kakaobank.ui.theme.DarkMint
import com.gdg.kakaobank.ui.theme.DeepBlue
import com.gdg.kakaobank.ui.theme.Gray
import com.gdg.kakaobank.ui.theme.LightMint
import com.gdg.kakaobank.ui.theme.MainYellow
import com.gdg.kakaobank.ui.theme.Pink
import com.gdg.kakaobank.ui.theme.White
import com.gdg.kakaobank.ui.theme.Yellow
import com.gdg.kakaobank.ui.theme.b4Bold
import com.gdg.kakaobank.ui.theme.b4Regular
import com.gdg.kakaobank.ui.theme.b4Semi
import com.gdg.kakaobank.ui.theme.h5Bold
import com.gdg.kakaobank.ui.theme.h6Bold

@Composable
fun HomeRoute(
    navigator: HomeNavigator
) {
    HomeScreen(onTransferClick = {navigator.navigateToTransfer()})
}

@Composable
fun HomeScreen(onTransferClick: () -> Unit) {
    Scaffold(
        topBar = { HomeTopBar() }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 20.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            item { AccountCard("이가을의 통장", "100,000,000원", MainYellow, showTransferButton = true, onTransferClick = onTransferClick) }
            item {AccountCard("GDG 숙명", "70,000원", Pink) }
            item { AccountCard("제주도 계모임", "14원", DarkMint) }
            item { AccountCard("세이프박스", "300,000원", LightMint) }
            item { AccountCard("이현진", "500,000원", DeepBlue) }
            item { AccountCard("여행 경비 저금 통장", "1,000,000", Gray) }
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeTopBar() {
    TopAppBar(
        modifier = Modifier.background(White),
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = White),
        title = {
            Row (
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(R.string.username_gaeul),
                    style = h5Bold,
                    color = Black
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = stringResource(R.string.my_account),
                    style = b4Bold,
                    color = Black
                )
                Spacer(modifier = Modifier.weight(1f))
                Box(
                    modifier = Modifier.padding(end = 22.dp)
                ) {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = R.drawable.ic_bell),
                        contentDescription = "알림"

                    )
                }

            }
        }
    )
}

@Composable
fun AccountCard(name: String, amount: String, backgroundColor: Color, showTransferButton: Boolean = false, onTransferClick: () -> Unit = {}) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(132.dp)
            .background(backgroundColor, RoundedCornerShape(20.dp))
            .padding(16.dp)
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.ic_bank),
            contentDescription = "카카오뱅크 로고",
            tint = Color.Unspecified,
            modifier = Modifier
                .size(31.dp)
        )
        Spacer(modifier = Modifier.width(12.dp))
        Column(
            modifier = Modifier.weight(1f) // 남은 공간 텍스트 영역에 할당
        ) {
            Text(
                text = name,
                style = b4Regular
            )
            Text(
                text = amount,
                style = h6Bold
            )
        }
        Spacer(modifier = Modifier.width(16.dp))
        if (showTransferButton) {
            Box(
                modifier = Modifier
                    .offset(x = 30.dp, y = 65.dp)
            ) {
                Box(
                    modifier = Modifier
                        .size(width = 47.dp, height = 27.dp)
                        .background(Yellow, RoundedCornerShape(20.dp))
                        .clickable { onTransferClick() }
                ) {
                    Text(
                        text = "이체",
                        style = b4Semi,
                        color = Black,
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
            }
        }
        Box(
            modifier = Modifier
                .padding(end = 16.dp)
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_more_horizontal),
                contentDescription = "더보기",
                tint = Color.DarkGray
            )
        }
    }
}