package com.gdg.kakaobank.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.gdg.kakaobank.ui.theme.Black
import com.gdg.kakaobank.ui.theme.ButtonGray
import com.gdg.kakaobank.ui.theme.MainYellow
import com.gdg.kakaobank.ui.theme.White
import com.gdg.kakaobank.ui.theme.b2Regular
import com.gdg.kakaobank.ui.theme.h5Semi
import com.gdg.kakaobank.ui.theme.h7Bold
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun KaKaoBottomSheet(
    onDismiss: () -> Unit,
    onConfirm: () -> Unit,
    title : String,
    subtitle : String,
    confirmButtonText : String
) {
    val sheetState = rememberModalBottomSheetState()

    ModalBottomSheet(
        sheetState = sheetState,
        onDismissRequest = { onDismiss() },
        containerColor = White,
    ) {
        val scope = rememberCoroutineScope()

        Column(
            modifier = Modifier
                //.padding(horizontal = 9.5.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = title,
                style = h5Semi,
                modifier = Modifier.padding(bottom = 2.dp)
            )
            Text(
                text = subtitle,
                style = b2Regular,
                modifier = Modifier.padding(bottom = 2.dp)
            )
            Spacer(modifier = Modifier.height(47.dp))
            Row(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(
                    modifier = Modifier.weight(1f)
                        .height(57.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = ButtonGray,
                    ),
                    shape = RoundedCornerShape(40.dp),
                    contentPadding = PaddingValues(vertical = 19.dp),
                    onClick = {
                        scope.launch { sheetState.hide() }.invokeOnCompletion {
                            if (!sheetState.isVisible) {
                                onDismiss()
                            }
                        }
                    }
                ) {
                    Text(
                        text = "취소",
                        color = White,
                        style = h7Bold
                    )
                }
                Spacer(modifier = Modifier.width(8.dp))
                Button(
                    modifier = Modifier.weight(1f)
                        .height(57.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MainYellow,
                    ),
                    shape = RoundedCornerShape(40.dp),
                    contentPadding = PaddingValues(vertical = 19.dp),
                    onClick = {
                        scope.launch { sheetState.hide() }.invokeOnCompletion {
                            if (!sheetState.isVisible) {
                                onConfirm()
                            }
                        }
                    }
                ) {
                    Text(
                        text = confirmButtonText,
                        color = Black,
                        style = h7Bold
                    )
                }
            }
            Spacer(modifier = Modifier.height(30.dp))
        }
    }
}