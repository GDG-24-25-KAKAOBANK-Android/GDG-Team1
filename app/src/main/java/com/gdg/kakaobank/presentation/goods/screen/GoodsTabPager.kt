package com.gdg.kakaobank.presentation.goods.screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults.SecondaryIndicator
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gdg.kakaobank.presentation.goods.screen.goodsAccount.GoodsAccountRoute
import com.gdg.kakaobank.presentation.goods.screen.goodsCard.GoodsCardRoute
import com.gdg.kakaobank.presentation.goods.screen.goodsInvest.GoodsInvestRoute
import com.gdg.kakaobank.presentation.goods.screen.goodsLoan.GoodsLoanRoute
import com.gdg.kakaobank.presentation.goods.screen.goodsRecommend.GoodsRecommendRoute
import com.gdg.kakaobank.presentation.goods.screen.goodsSaving.GoodsSavingRoute
import com.gdg.kakaobank.ui.theme.Black
import com.gdg.kakaobank.ui.theme.Gray
import com.gdg.kakaobank.ui.theme.b2Bold
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun GoodsTabPager() {

    val coroutineScope = rememberCoroutineScope() // 코루틴 스코프 생성
    val tabs = listOf("추천", "통장", "저축", "카드", "투자", "대출")
    val pagerState = rememberPagerState {
        tabs.size
    }


    Column {
        // 탭 구현
        TabRow(
            selectedTabIndex = pagerState.currentPage,
            indicator = { tabPositions ->
                SecondaryIndicator(
                    modifier = Modifier.tabIndicatorOffset(tabPositions[pagerState.currentPage])
                        .width(49.dp),
                    height = 1.dp, // 인디케이터 높이 설정
                    color = Black // 인디케이터 색상 변경
                )
            },
            containerColor = Color.White, // 배경색 설정
            contentColor = Gray,
            modifier = Modifier
                .fillMaxWidth()
                .height(30.dp)
                .padding(horizontal = 21.dp),
        ) {
            tabs.forEachIndexed { index, title ->
                Tab(
                    text = {
                        Text(title,
                            style = b2Bold,
                            color = if (pagerState.currentPage == index) Color.Black else Gray,
                            modifier = Modifier.fillMaxWidth()

                    ) },
                    selected = pagerState.currentPage == index,
                    modifier = Modifier
                        .height(25.dp),
                    onClick = {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(index)
                        }
                    }
                )
            }
        }

        // 뷰페이저 구현
        HorizontalPager(
            state = pagerState
        ) { page ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // 페이지별 컨텐츠
                when (page) {
                    0 -> GoodsRecommendRoute()
                    1 -> GoodsAccountRoute()
                    2 -> GoodsSavingRoute()
                    3 -> GoodsCardRoute()
                    4 -> GoodsInvestRoute()
                    5 -> GoodsLoanRoute()
                }
            }
        }
    }
}

@Preview
@Composable
fun GoodsTabPagerPreview(){
    GoodsTabPager()
}