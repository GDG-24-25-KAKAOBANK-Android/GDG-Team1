package com.gdg.kakaobank.presentation.other.screen

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.gdg.kakaobank.ui.theme.Black
import com.gdg.kakaobank.ui.theme.Gray
import com.gdg.kakaobank.ui.theme.MainYellow
import com.gdg.kakaobank.ui.theme.White
import com.gdg.kakaobank.ui.theme.h5Bold

@Composable
fun WithDrawDialog(
    onDismiss: () -> Unit,
    onWithdraw: () -> Unit
) {
    val context = LocalContext.current

    AlertDialog(
        onDismissRequest = { onDismiss() },
        title = {
            Text(
                text = "회원 탈퇴 하시겠습니까?",
                style = h5Bold,
                color = Black,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp)
            )
        },

        confirmButton = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Button(
                    onClick = { onDismiss() },
                    colors = ButtonDefaults.buttonColors(containerColor = Gray),
                    shape = RoundedCornerShape(50),
                    modifier = Modifier
                        .size(width = 122.dp, height = 49.dp) // 버튼 크기 고정
                        .padding(end = 3.5.dp) // 중앙에서 오른쪽으로 떨어진 거리
                ) {
                    Text(text = "취소", color = White)
                }

                Button(
                    onClick = {
                        onWithdraw()
                        Toast.makeText(context, "회원 탈퇴 되었습니다.", Toast.LENGTH_SHORT).show()
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = MainYellow),
                    shape = RoundedCornerShape(50),
                    modifier = Modifier
                        .size(width = 122.dp, height = 49.dp) // 버튼 크기 고정
                        .padding(start = 3.5.dp) // 중앙에서 왼쪽으로 떨어진 거리
                ) {
                    Text(text = "회원 탈퇴", color = Black)
                }
            }
        },
        containerColor = White,
        shape = RoundedCornerShape(20.dp)
    )
}