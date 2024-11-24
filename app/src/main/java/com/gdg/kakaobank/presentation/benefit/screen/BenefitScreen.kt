package com.gdg.kakaobank.presentation.benefit.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gdg.kakaobank.R
import com.gdg.kakaobank.presentation.benefit.navigation.BenefitNavigator
import com.gdg.kakaobank.ui.theme.DeepBlue
import com.gdg.kakaobank.ui.theme.LightMint
import com.gdg.kakaobank.ui.theme.MainYellow
import com.gdg.kakaobank.ui.theme.White
import com.gdg.kakaobank.ui.theme.Yellow
import com.gdg.kakaobank.ui.theme.b3Bold
import com.gdg.kakaobank.ui.theme.b4Regular
import com.gdg.kakaobank.ui.theme.h4Bold
import com.gdg.kakaobank.ui.theme.h6Bold
import com.google.accompanist.systemuicontroller.rememberSystemUiController


@Composable
fun BenefitRoute(
    navigator: BenefitNavigator
) {
    val systemUiController = rememberSystemUiController()

    SideEffect {
        systemUiController.setStatusBarColor(
            color = White
        )
    }

    BenefitScreen()
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BenefitScreen() {
    val colors = listOf(LightMint, Yellow, DeepBlue )
    val texts = listOf("GDG Android", "GDG Flutter", "GDG Spring")


    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier.background(White),
                title = {
                    Text(
                        text = stringResource(R.string.tv_benefit_title),
                        style = h4Bold,
                    )
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = White
                )
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(color = White)
                .padding(horizontal = 20.dp)
        ) {

            Box(
                modifier = Modifier
                    .height(57.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(20.dp))
                    .background(color = MainYellow)

            ) {
                Column(
                    modifier = Modifier
                        .padding(top = 14.dp)
                        .padding(horizontal = 18.dp)
                ) {
                    Text(stringResource(R.string.tv_benefit_ad1), style = b4Regular)
                    Text(stringResource(R.string.tv_benefit_ad2), style = b3Bold)

                }
            }

            Spacer(modifier = Modifier.height(30.dp))

            Text(stringResource(R.string.tv_benefit_listname), style = h6Bold)

            Spacer(modifier = Modifier.height(20.dp))

            Column(
                verticalArrangement = Arrangement.spacedBy(18.dp),
                modifier = Modifier
                    .fillMaxWidth()
                ) {
                for (i in 1..5) {
                    BenefitSendItem()
                }
            }

            Spacer(modifier = Modifier.height(35.dp))

            LazyRow (
                horizontalArrangement = Arrangement.spacedBy(12.dp),
            ){
                items(3) { index ->
                    BenefitLikeItem(
                        color = colors[index],
                        text = texts[index]
                    )
                }
            }

        }
    }


}

@Preview
@Composable
fun BenefitScreenPreview(){
    BenefitScreen()
}