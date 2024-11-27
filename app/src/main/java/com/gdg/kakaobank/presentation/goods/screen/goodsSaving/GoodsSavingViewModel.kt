package com.gdg.kakaobank.presentation.goods.screen.goodsSaving

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GoodsSavingViewModel @Inject constructor() : ViewModel() {
    val goodsSavingList = listOf(
        GoodsSavingEntity(
            text1 ="자유 적금",
            text2 = "매일/매주/매월 자유롭게",
            rate = "최고 연 3.70%"
        ),
        GoodsSavingEntity(
            text1 ="26주 적금",
            text2 = "캐릭터와 함께 즐거운 도전",
            rate = "최고 연 5.50%"
        ),
        GoodsSavingEntity(
            text1 ="한달적금",
            text2 = "춘식이와 한달동안 매일매일 저금",
            rate = "최고 연 7.00%"
        ),
        GoodsSavingEntity(
            text1 ="정기예금",
            text2 = "실시간 이자로 돈 모으는 재미가 쏠쏠",
            rate = "최고 연 3.10%"
        ),
        GoodsSavingEntity(
            text1 ="저금통",
            text2 = "숨어있던 잔돈을 알아서 차곡차곡",
            rate = "최고 연 8.00%"
        ),
        GoodsSavingEntity(
            text1 ="mini 26일저금",
            text2 = "매일 꾸준하게 용돈 자동저금",
            rate = "최고 연 2.50%"
        ),
        )
}