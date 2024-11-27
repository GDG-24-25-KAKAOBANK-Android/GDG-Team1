package com.gdg.kakaobank.presentation.goods.screen.goodsLoan

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gdg.kakaobank.R
import com.gdg.kakaobank.ui.component.GoodsBox
import com.gdg.kakaobank.ui.theme.DeepBlue
import com.gdg.kakaobank.ui.theme.Gray
import com.gdg.kakaobank.ui.theme.LightGray
import com.gdg.kakaobank.ui.theme.MainYellow
import com.gdg.kakaobank.ui.theme.White
import com.gdg.kakaobank.ui.theme.Yellow
import com.gdg.kakaobank.ui.theme.b3Semi
import com.gdg.kakaobank.ui.theme.h6Bold

@Composable
fun GoodsLoanRoute() {
    GoodsLoanScreen()
}


@OptIn(ExperimentalLayoutApi::class)
@Composable
fun GoodsLoanScreen() {
    val categoryList = listOf(
        "신용대출", "중신용대출", "비상금대출",
        "신용대출 갈아타기", "개인사업자 신용대출",
        "개인사업자 보증서대출", "중고차 구매대출",
        "저당대출", "전월세보증금 대출",
        "전월세보증금 대출 갈아타기", "담보대출",
        "주택담보대출", "주택담보대출 갈아타기"
    )
    val selectedCategories = remember { mutableStateOf(mutableSetOf<String>()) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = White)
            .padding(top = 15.dp)
            .padding(horizontal = 24.dp)
    ) {
        GoodsBox(DeepBlue, "아파트부터 빌라까지\n주택담보대출")

        Spacer(modifier = Modifier.height(34.dp))

        Text(stringResource(R.string.tv_goodsLoan_title), style = h6Bold)

        Spacer(modifier = Modifier.height(15.dp))

        FlowRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 50.dp),
            horizontalArrangement = Arrangement.spacedBy(13.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            categoryList.forEach { category ->
                Button(
                    shape = RoundedCornerShape(20.dp),
                    contentPadding = PaddingValues(horizontal = 15.dp, vertical = 9.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (selectedCategories.value.contains(category)) White else LightGray
                    ),
                    border = BorderStroke(
                        width = 1.dp,
                        color = if (selectedCategories.value.contains(category)) Yellow else LightGray
                    ),
                    onClick = {
                        // Toggle category selection
                        val newSet = selectedCategories.value.toMutableSet()
                        if (newSet.contains(category)) {
                            newSet.remove(category)
                        } else {
                            newSet.add(category)
                        }
                        selectedCategories.value = newSet
                    }
                ) {
                    Text(
                        text = category,
                        style = b3Semi,
                        color = if (selectedCategories.value.contains(category)) MainYellow else Gray
                    )
                }
            }
        }
    }
}


@Preview
@Composable
fun GoodsLoanScreenPreview(){
    GoodsLoanScreen()
}