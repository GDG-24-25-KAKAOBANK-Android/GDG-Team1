package com.gdg.kakaobank.presentation.goods.screen.goodsRecommend

data class GoodsRecommendEntity (
    val image : Int, //image는 컴포저블 함수에서만 호출 가능 -> 뷰 모델에서 사용 못함, 리소스 ID로 관리
    val text1 : String,
    val text2 : String
)