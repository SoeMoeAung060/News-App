package com.example.shoppingapp

import android.app.ActionBar
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.Window
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.lifecycleScope
import com.example.shoppingapp.domain.usecases.AppEntryUseCases
import com.example.shoppingapp.presentations.onboarding.OnBoardingScreen
import com.example.shoppingapp.presentations.onboarding.OnBoardingViewModel
import com.example.shoppingapp.ui.theme.ShoppingAppTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var appEntryUseCases: AppEntryUseCases


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycleScope.launch {
            appEntryUseCases.readAppEntry().collect{
                Log.d("Test", it.toString())
            }

        }

        WindowCompat.setDecorFitsSystemWindows(window, false)
        installSplashScreen()
        setContent {
            ShoppingAppTheme {
                Surface {
                    val viewModel : OnBoardingViewModel = hiltViewModel()
                    OnBoardingScreen(
                     //   event = {
                        //   viewModel.onEvent(it)
                        //   }  or
                        event = viewModel::onEvent
                    )
                }
            }
        }
    }
}
