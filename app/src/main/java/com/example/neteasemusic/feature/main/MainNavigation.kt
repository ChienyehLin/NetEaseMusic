package com.example.neteasemusic.feature.main

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.neteasemusic.feature.splash.SPLASH_ROUTE

const val MAIN_ROUTE = "MAIN"


/**
 * 跳转到这个界面
 */
fun NavController.navigateToMain() {
    navigate(MAIN_ROUTE) {
        //不开启多个界面
        launchSingleTop = true
        //关闭splash界面以及以前所有界面
        popUpTo(SPLASH_ROUTE){
            inclusive = true
        }
    }
}

/**
 * 配置导航
 */
fun NavGraphBuilder.mainScreen(
    finishPage: ()->Unit
): Unit {

    composable(MAIN_ROUTE) {
        MainRoute(finishPage = finishPage)
    }
}