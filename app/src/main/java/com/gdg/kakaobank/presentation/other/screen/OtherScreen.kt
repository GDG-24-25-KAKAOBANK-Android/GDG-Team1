package com.gdg.kakaobank.presentation.other.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gdg.kakaobank.R
import com.gdg.kakaobank.presentation.other.navigation.OtherNavigator
import com.gdg.kakaobank.ui.theme.Black
import com.gdg.kakaobank.ui.theme.White
import com.gdg.kakaobank.ui.theme.Yellow
import com.gdg.kakaobank.ui.theme.h5Bold
import com.gdg.kakaobank.ui.theme.pretendardSemiBoldStyle

@Composable
fun OtherRoute(
    navigator: OtherNavigator
) {
    OtherScreen()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OtherScreen() {
    val textStyle18 = pretendardSemiBoldStyle.copy(fontSize = 16.sp)
    val textStyle15 = pretendardSemiBoldStyle.copy(fontSize = 12.sp)

    var showLogoutDialog by remember { mutableStateOf(false) }
    var showWithdrawDialog by remember { mutableStateOf(false) }

    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(White)
                .padding(innerPadding)
                .padding(horizontal = 20.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp)
            ) {
                Text(
                    text = "이가을님",
                    style = h5Bold,
                    color = Black,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Text(
                    text = "카카오뱅크 서비스",
                    style = h5Bold,
                    color = Yellow,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Text(
                    text = "관련 안내사항입니다",
                    style = h5Bold,
                    color = Black,
                )
            }
            Text(
                text = "이용안내",
                style = textStyle18,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp)
            )
            MenuItem(title = "서비스 이용약관", textStyle = textStyle15)
            MenuItem(title = "개인정보 처리방침", textStyle = textStyle15)
            MenuItem(title = "버전 정보", textStyle = textStyle15)

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "기타",
                style = textStyle18,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp)
            )
            MenuItem(title = "고객센터", textStyle = textStyle15)
            MenuItem(
                title = "로그아웃",
                textStyle = textStyle15,
                onClick = {showLogoutDialog = true}
            )
            if (showLogoutDialog) {
                LogoutDialog(
                    onDismiss = { showLogoutDialog = false },
                    onLogout = { showLogoutDialog = false }
                )
            }
            MenuItem(title = "회원 탈퇴",
                textStyle = textStyle15,
                onClick = {showWithdrawDialog = true}
                )
            if (showWithdrawDialog) {
                WithDrawDialog(
                    onDismiss = { showWithdrawDialog = false },
                    onWithdraw = { showWithdrawDialog = false }
                )
            }
        }
    }
}

@Composable
fun MenuItem(title: String, textStyle: TextStyle, onClick: () -> Unit = {}) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = title,
            style = textStyle,
            //텍스트가 남은 공간 차지하도록 설정(화살표 우측 정렬)
            modifier = Modifier.weight(1f)
        )
        Image(
            painter = painterResource(id = R.drawable.ic_next),
            contentDescription = "화살표",
            modifier = Modifier.size(24.dp)

        )
    }
}