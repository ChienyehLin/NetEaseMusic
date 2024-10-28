package com.example.neteasemusic.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.neteasemusic.feature.main.mainScreen
import com.example.neteasemusic.feature.main.navigateToMain
import com.example.neteasemusic.feature.splash.SPLASH_ROUTE
import com.example.neteasemusic.feature.splash.SplashRoute
import com.example.neteasemusic.feature.splash.splashScreen

@Composable
fun MyApp(navController: NavHostController) {
    NavHost(navController = navController, startDestination = SPLASH_ROUTE) {
        //配置导航
        splashScreen(toMain = navController::navigateToMain)
        mainScreen(finishPage = navController::popBackStack)
    }

/*    // A surface container using the 'background' color from the theme
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.primary
    ) {
        SplashRoute()
    }*/
}