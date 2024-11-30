package com.gdg.kakaobank.presentation.goods.screen.goodsAccount

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.gdg.kakaobank.api.User
import com.gdg.kakaobank.ui.component.GoodsBox
import com.gdg.kakaobank.ui.theme.Black
import com.gdg.kakaobank.ui.theme.Gray
import com.gdg.kakaobank.ui.theme.Pink
import com.gdg.kakaobank.ui.theme.White
import com.gdg.kakaobank.ui.theme.b3Bold
import com.gdg.kakaobank.ui.theme.b4Regular
import com.gdg.kakaobank.ui.theme.h6Bold

@Composable
fun GoodsAccountRoute() {
    GoodsAccountScreen()
}


@Composable
fun GoodsAccountScreen(){
    val goodsAccountViewModel: GoodsAccountViewModel = viewModel()
    val users by goodsAccountViewModel.users.observeAsState(emptyList())

    LaunchedEffect(Unit) {
        goodsAccountViewModel.getUsers()
    }
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(color = White)
            .padding(top = 15.dp)
            .padding(horizontal = 24.dp),
        verticalArrangement = Arrangement.spacedBy(18.dp)
    ) {
        item {
            GoodsBox( Pink, "기록하며 저축하는\n기록통장 만들기")

            Spacer(modifier = Modifier.height(34.dp))

            Text("전문가와 상담하기", style = h6Bold)
        }

        //유저 리스트 2개씩 묶음
        items(users.chunked(2)) { userPair ->
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(17.dp)
                //.weight(1f)

            ) {
                userPair.forEach { user ->
                    UserCard(
                        user
                    )
                }
            }
        }
    }


}

@Composable
fun UserCard(user: User) {
    Box(
        modifier = Modifier
            .size(170.dp, 170.dp)
            .background(color = White)
            .border(1.dp, color = Gray, RoundedCornerShape(20.dp))
            .padding(top = 36.dp, start = 17.dp)
    ) {
        Column {
            Text(
                text = user.firstName,
                color = Black,
                style = b3Bold
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = user.email,
                color = Black,
                style = b4Regular
            )
            Spacer(modifier = Modifier
                .height(9.dp)
            )
            AsyncImage(
                modifier = Modifier
                    .padding(start = 67.dp)
                    .size(70.dp)
                    .clip(RoundedCornerShape(50.dp)),
                model = user.avatar,
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
        }
    }
}
