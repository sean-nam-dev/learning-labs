package com.example.littlelemonfinal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.littlelemonfinal.navigation.Destination
import com.example.littlelemonfinal.presentation.screen.LogoutScreen
import com.example.littlelemonfinal.presentation.screen.RegisterScreen
import com.example.littlelemonfinal.presentation.viewmodel.LogoutViewModel
import com.example.littlelemonfinal.presentation.viewmodel.MainViewModel
import com.example.littlelemonfinal.presentation.viewmodel.RegisterViewModel
import com.example.littlelemonfinal.ui.theme.LittleLemonFinalTheme
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val mainViewModel: MainViewModel by viewModel()
            val navController = rememberNavController()

            LittleLemonFinalTheme {
                NavHost(
                    startDestination = when (mainViewModel.getStartDestination()) {
                        Destination.Home.toString() -> Destination.Home
                        else -> Destination.Register
                    },
                    navController = navController
                ) {
                    composable<Destination.Register> {
                        val registerViewModel: RegisterViewModel by viewModel()

                        RegisterScreen(
                            viewModel = registerViewModel,
                            navController = navController
                        )
                    }
                    composable<Destination.Home> {

                    }
                    composable<Destination.LogOut> {
                        val logoutViewModel: LogoutViewModel by viewModel()

                        LogoutScreen(
                            viewModel = logoutViewModel,
                            navController = navController
                        )
                    }
                }
            }
        }
    }
}