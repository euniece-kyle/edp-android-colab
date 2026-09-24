package com.liceo.account.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewmodel.compose.viewModel

private enum class Screen {
    Login, Register
}

@Composable
fun LiceoAccountApp(viewModel: AuthViewModel = viewModel()) {
    var currentScreen by remember { mutableStateOf(Screen.Login) }

    when (val state = viewModel.uiState) {
        is AuthUiState.LoggedIn -> {
            ProfileScreen(
                user = state.user,
                onLogout = { viewModel.logout() }
            )
        }
        else -> {
            when (currentScreen) {
                Screen.Login -> {
                    LoginScreen(
                        state = state,
                        onLogin = { email, password ->
                            viewModel.login(email, password)
                        },
                        onGoToRegister = {
                            viewModel.clearMessage()
                            currentScreen = Screen.Register
                        }
                    )
                }
                Screen.Register -> {
                    RegisterScreen(
                        state = state,
                        onCreate = { fullName, email, password, birthdate ->
                            viewModel.register(fullName, email, password, birthdate)
                        },
                        onGoToLogin = {
                            viewModel.clearMessage()
                            currentScreen = Screen.Login
                        }
                    )
                }
            }
        }
    }
}
