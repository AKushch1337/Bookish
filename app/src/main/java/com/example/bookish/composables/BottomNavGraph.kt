package com.example.bookish.composables

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.bookish.BottomBarScreen

@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = BottomBarScreen.Library.route)
    {
        composable(route = BottomBarScreen.Library.route) {
            LibraryScreen()
        }
        composable(route = BottomBarScreen.Lists.route) {
            ListsScreen()
        }
        composable(route = BottomBarScreen.Settings.route) {
            SettingsScreen()
        }
    }
}