package com.gdg.kakaobank.presentation.other.screen

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
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
fun LogoutDialog(
    onDismiss: () -> Unit,
    onLogout: () -> Unit
) {
    val context = LocalContext.current

    AlertDialog(
        onDismissRequest = { onDismiss() },
        title = {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally

            ) {
                Text(
                    text = "로그아웃 하시겠습니까?",
                    style = h5Bold,
                    color = Black,
                    textAlign = TextAlign.Center
                )
            }
        },

        dismissButton = {
            Button(
                onClick = { onDismiss() },
                colors = ButtonDefaults.buttonColors(containerColor = Gray),
                shape = RoundedCornerShape(50)
            ) {
                Text(text = "취소", color = White)
            }
        },
        containerColor = White,
        shape = RoundedCornerShape(16.dp),

        confirmButton = {

            Button(
                onClick = {
                    onLogout()
                    Toast.makeText(context, "로그아웃 되었습니다.", Toast.LENGTH_SHORT).show()
                },
                colors = ButtonDefaults.buttonColors(containerColor = MainYellow),
                shape = RoundedCornerShape(50)
            ) {
                Text(text = "로그아웃", color = Black)
            }
        }

    )
}