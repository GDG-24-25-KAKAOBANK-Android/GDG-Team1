package com.gdg.kakaobank.presentation.goods.screen.goodsRecommend

import androidx.lifecycle.ViewModel
import com.gdg.kakaobank.R
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GoodsRecommendViewModel @Inject constructor() : ViewModel(){
    val goodsRecommendList = listOf(
        GoodsRecommendEntity(
            image = R.drawable.ic_goods_money,
            text1 = "정기예금",
            text2 = "실시간 이자로 돈 모으는 재미가 쏠쏠"
        ),
        GoodsRecommendEntity(
            image = R.drawable.ic_goods_bankbook,
            text1 = "모임통장",
            text2 = "함께 쓰고 같이 보는 회비 관리"
        ),
        GoodsRecommendEntity(
            image = R.drawable.ic_goods_bank,
            text1 = "신용대출/중신용대출",
            text2 = "직장인이라면 쉽고 빠르게"
        ),
        GoodsRecommendEntity(
            image = R.drawable.ic_goods_truck,
            text1 = "전월세보증금대출",
            text2 = "이사를 가거나 보증금이 오른다면"
        ),
        GoodsRecommendEntity(
            image = R.drawable.ic_goods_loan,
            text1 = "신용대출 갈아타기",
            text2 = "방문 없이 원하는 대출로 간편하게"
        )
    )
}