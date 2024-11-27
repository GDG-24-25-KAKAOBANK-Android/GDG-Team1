package com.gdg.kakaobank.presentation.goods.screen.goodsCard

import androidx.lifecycle.ViewModel
import com.gdg.kakaobank.ui.theme.DarkGray
import com.gdg.kakaobank.ui.theme.DarkMint
import com.gdg.kakaobank.ui.theme.DeepBlue
import com.gdg.kakaobank.ui.theme.Pink
import com.gdg.kakaobank.ui.theme.Yellow
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GoodsCardViewModel @Inject constructor() : ViewModel() {
    val goodsCardList = listOf(
        GoodsCardEntity(
            circleColor = Yellow,
            text1 ="혜택 좋은 신용카드",
            text2 = "9개 카드사의 혜택 좋은 카드만 모아"
        ),
        GoodsCardEntity(
            circleColor = Pink,
            text1 ="프렌즈 체크카드",
            text2 = "쓸 때마다 캐시백, 주말엔 2배"
        ),
        GoodsCardEntity(
            circleColor = DarkMint,
            text1 ="모임 체크카드",
            text2 = "결제하면 바로 받는 랜덤 캐시백"
        ),
        GoodsCardEntity(
            circleColor = DeepBlue,
            text1 ="개인사업자 체크카드",
            text2 = "사업자에게 꼭 필요한 혜택만 담아"
        ),
        GoodsCardEntity(
            circleColor = DarkGray,
            text1 ="개인사업자 제휴 신용카드",
            text2 = "기본할인부터 사업자 특화혜택까지"
        ),

    )
}