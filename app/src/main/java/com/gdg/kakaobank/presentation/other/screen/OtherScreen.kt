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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.gdg.kakaobank.R
import com.gdg.kakaobank.presentation.other.navigation.OtherNavigator
import com.gdg.kakaobank.ui.theme.Black
import com.gdg.kakaobank.ui.theme.White
import com.gdg.kakaobank.ui.theme.Yellow
import com.gdg.kakaobank.ui.theme.b1Semi
import com.gdg.kakaobank.ui.theme.h5Bold
import com.gdg.kakaobank.ui.theme.h6Semi

@Composable
fun OtherRoute(
    navigator: OtherNavigator
) {
    OtherScreen()
}

@Composable
fun OtherScreen() {

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
                    text = stringResource(R.string.username_gaeul),
                    style = h5Bold,
                    color = Black,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Text(
                    text = stringResource(R.string.kakaobank_service),
                    style = h5Bold,
                    color = Yellow,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Text(
                    text = stringResource(R.string.introduction),
                    style = h5Bold,
                    color = Black,
                )
            }
            Text(
                text = stringResource(R.string.use_guide),
                style = h6Semi,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp)
            )
            MenuItem(title = stringResource(R.string.terms_of_service), textStyle = b1Semi)
            MenuItem(title = stringResource(R.string.policy_of_personal_info), textStyle = b1Semi)
            MenuItem(title = stringResource(R.string.information_of_version), textStyle = b1Semi)

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = stringResource(R.string.etc),
                style = h6Semi,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp)
            )
            MenuItem(title = stringResource(R.string.service_center), textStyle = b1Semi)
            MenuItem(
                title = stringResource(R.string.logout),
                textStyle = b1Semi,
                onClick = {showLogoutDialog = true}
            )
            if (showLogoutDialog) {
                LogoutDialog(
                    onDismiss = { showLogoutDialog = false },
                    onLogout = { showLogoutDialog = false }
                )
            }
            MenuItem(title = stringResource(R.string.user_execute),
                textStyle = b1Semi,
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