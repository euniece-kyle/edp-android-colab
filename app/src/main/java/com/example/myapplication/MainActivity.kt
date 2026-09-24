package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplication.ui.theme.MyApplicationTheme
import com.liceo.account.ui.AuthUiState
import com.liceo.account.ui.AuthViewModel
import com.liceo.account.ui.LoginScreen
import com.liceo.account.ui.ProfileScreen
import com.liceo.account.ui.RegisterScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppNavigation()
                }
            }
        }
    }
}

private enum class Screen {
    Login, Register
}

@Composable
fun AppNavigation(viewModel: AuthViewModel = viewModel()) {
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
