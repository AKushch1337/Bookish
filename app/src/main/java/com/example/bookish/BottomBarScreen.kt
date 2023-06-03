package com.example.bookish

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarScreen(
    val route: String,
    val title: Int,
    val icon: ImageVector
) {
    object Library : BottomBarScreen(
        route = "library",
        title = R.string.library,
        icon = Icons.Default.Home
    )
    object Lists : BottomBarScreen(
        route = "lists",
        title = R.string.lists,
        icon = Icons.Default.List
    )
    object Settings : BottomBarScreen(
        route = "settings",
        title = R.string.settings,
        icon = Icons.Default.Settings
    )
}
