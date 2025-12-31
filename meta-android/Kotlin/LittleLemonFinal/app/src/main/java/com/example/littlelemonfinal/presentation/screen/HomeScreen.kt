package com.example.littlelemonfinal.presentation.screen

import androidx.compose.runtime.Composable
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.littlelemonfinal.navigation.Destination
import com.example.littlelemonfinal.presentation.ui.HomeUIScreen
import com.example.littlelemonfinal.presentation.viewmodel.HomeViewModel

@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel,
    navController: NavController
) {
    val menuList = homeViewModel.menuList.collectAsStateWithLifecycle()
    val searchQuery = homeViewModel.searchQuery.collectAsStateWithLifecycle()
    val filter = homeViewModel.filter.collectAsStateWithLifecycle()

    HomeUIScreen(
        menuList = menuList.value,
        searchQuery = searchQuery.value,
        filterList = filter.value,
        onProfileClick = {
            navController.navigate(Destination.LogOut)
        },
        onSearchQuery = {
            homeViewModel.onSearchQuery(it)
        },
        onFilter = {
            homeViewModel.onFilter(it)
        }
    )
}