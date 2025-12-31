package com.example.littlelemonfinal.presentation.screen

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.littlelemonfinal.navigation.Destination
import com.example.littlelemonfinal.presentation.ui.LogoutUIScreen
import com.example.littlelemonfinal.presentation.viewmodel.LogoutViewModel

@Composable
fun LogoutScreen(
    viewModel: LogoutViewModel,
    navController: NavController
) {
    LogoutUIScreen(
        data = viewModel.getData(),
        onLogoutAction = {
            viewModel.logout()
            navController.navigate(Destination.Register) {
                popUpTo(0) {
                    inclusive = true
                }
                launchSingleTop = true
            }
        }
    )
}