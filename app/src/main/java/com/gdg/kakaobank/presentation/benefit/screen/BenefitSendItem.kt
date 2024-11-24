package com.gdg.kakaobank.presentation.benefit.screen
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gdg.kakaobank.R
import com.gdg.kakaobank.ui.theme.White
import com.gdg.kakaobank.ui.theme.b3Bold
import com.gdg.kakaobank.ui.theme.b4Regular

@Composable
fun BenefitSendItem(
) {
    Box(
        modifier = Modifier
            .background(color = White)
            .height(44.dp)
    ){
        Image(
            painter = painterResource(id = R.drawable.ic_benefit_send),
            contentDescription = "ic_benefit_send",
        )

        Column (
            modifier = Modifier
                .padding(horizontal = 54.dp)
                .padding(vertical = 6.dp)

        ){
            Text(stringResource(R.string.tv_benefit_senditem1), style = b3Bold)
            Text(stringResource(R.string.tv_benefit_senditem2), style = b4Regular)
        }

    }
}

@Preview
@Composable
fun BenefitSendItemPreview(){
    BenefitSendItem()
}