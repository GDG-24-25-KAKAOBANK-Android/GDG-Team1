package com.gdg.kakaobank.ui.component

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import com.gdg.kakaobank.ui.theme.DarkGray
import com.gdg.kakaobank.ui.theme.Gray

data class BottomNavigationItem(
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val label: String,
    val selectedText: Color = DarkGray,
    val unselectedText: Color = Gray
)