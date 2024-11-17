package com.gdg.kakaobank.presentation.main.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.material.ripple.RippleAlpha
import androidx.compose.material.ripple.RippleTheme
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.gdg.kakaobank.R
import com.gdg.kakaobank.presentation.benefit.navigation.BenefitNavigator
import com.gdg.kakaobank.presentation.goods.navigation.GoodsNavigator
import com.gdg.kakaobank.presentation.home.navigation.HomeNavigator
import com.gdg.kakaobank.presentation.main.navigation.MainNavigator
import com.gdg.kakaobank.presentation.other.navigation.OtherNavigator
import com.gdg.kakaobank.presentation.benefit.screen.BenefitRoute
import com.gdg.kakaobank.presentation.goods.screen.GoodsRoute
import com.gdg.kakaobank.presentation.home.screen.HomeRoute
import com.gdg.kakaobank.presentation.other.screen.OtherRoute
import com.gdg.kakaobank.ui.component.BottomNavigationItem
import com.gdg.kakaobank.ui.theme.Black
import com.gdg.kakaobank.ui.theme.KakaoBankTheme
import com.gdg.kakaobank.ui.theme.White
import com.gdg.kakaobank.ui.theme.b4Regular

@Composable
fun MainRoute(
    navigator: MainNavigator,
) {
    MainScreen(
        navController = navigator.navController,
    )
}

@Composable
fun MainScreen(
    navController: NavHostController,
) {
    var selectedItem by rememberSaveable { mutableIntStateOf(0) }
    val items = listOf(
        BottomNavigationItem(
            selectedIcon = ImageVector.vectorResource(id = R.drawable.ic_home_selected),
            unselectedIcon = ImageVector.vectorResource(id = R.drawable.ic_home_unselected),
            label = "홈"
        ),
        BottomNavigationItem(
            selectedIcon = ImageVector.vectorResource(id = R.drawable.ic_benefit_selected),
            unselectedIcon = ImageVector.vectorResource(id = R.drawable.ic_benefit_unselected),
            label = "혜택"
        ),
        BottomNavigationItem(
            selectedIcon = ImageVector.vectorResource(id = R.drawable.ic_goods_selected),
            unselectedIcon = ImageVector.vectorResource(id = R.drawable.ic_goods_unselected),
            label = "상품"
        ),
        BottomNavigationItem(
            selectedIcon = ImageVector.vectorResource(id = R.drawable.ic_other_selected),
            unselectedIcon = ImageVector.vectorResource(id = R.drawable.ic_other_unselected),
            label = "전체"
        )
    )

    Scaffold(
        bottomBar = {
            NavigationBar(
                modifier = Modifier.background(White),
                containerColor = White
            ) {
                items.forEachIndexed { index, item ->
                    CompositionLocalProvider(LocalRippleTheme provides NoRippleTheme) {
                        NavigationBarItem(
                            icon = {
                                Icon(
                                    imageVector = if (selectedItem == index) item.selectedIcon else item.unselectedIcon,
                                    contentDescription = null,
                                    tint = Color.Unspecified
                                )
                            },
                            label = {
                                Text(
                                    text = item.label,
                                    style = b4Regular
                                )
                            },
                            selected = selectedItem == index,
                            onClick = { selectedItem = index },
                            colors = NavigationBarItemDefaults.colors(
                                selectedTextColor = Black,
                                unselectedTextColor = Black,
                                indicatorColor = White
                            ),
                        )
                    }
                }
            }
        }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            when (selectedItem) {
                0 -> {
                    HomeRoute(navigator = HomeNavigator(navController = navController))
                }
                1 -> {
                    BenefitRoute(navigator = BenefitNavigator(navController = navController))
                }
                2 -> {
                    GoodsRoute(navigator = GoodsNavigator(navController = navController))
                }
                3 -> {
                    OtherRoute(navigator = OtherNavigator(navController = navController))
                }
            }
        }

    }
}

// 눌러질때의 ripple 제거
private object NoRippleTheme : RippleTheme {
    @Composable
    override fun defaultColor() = Color.Unspecified

    @Composable
    override fun rippleAlpha(): RippleAlpha {
        return RippleAlpha(0.0f, 0.0f, 0.0f, 0.0f)
    }
}

@Preview
@Composable
fun MainScreenPreview() {
    KakaoBankTheme {
        MainScreen(
            navController = rememberNavController()
        )
    }
}