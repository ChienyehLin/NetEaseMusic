package com.example.neteasemusic.feature.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.neteasemusic.R
import com.example.neteasemusic.util.SuperDateUtil


/**
 * Created by jadenlin on 10/5/24
 * @author jadenlin@bytedance.com
 */
@Composable
fun SplashRoute(
    toMain: () -> Unit,
    viewModel: SplashViewModel = viewModel()
) {
    val timeLeft by viewModel.timeLeft.collectAsStateWithLifecycle()
    val navigateToMain by viewModel.navigateToMain.collectAsState()

    SplashScreen(year = SuperDateUtil.getCurrentYear(), onSkipAdClick = viewModel::onSkipAdClick, timeLeft = timeLeft)
    if(navigateToMain) {
        LaunchedEffect(key1 = true) {
            toMain()
        }
    }
}


@Composable
fun SplashScreen(
    year: Int = 2024,
    onSkipAdClick: () -> Unit = {},
    timeLeft: Long = 0,
) {
    //box是相对布局
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primary)
            .statusBarsPadding()
    ) {
        //region 启动界面
        Image(
            painter = painterResource(id = R.drawable.splash_banner),
            contentDescription = "Splash logo",
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(150.dp)
                .clickable {
                    onSkipAdClick()
                }
        )

        Image(
            painter = painterResource(id = R.drawable.splash_logo),
            contentDescription = "Splash logo",
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(70.dp)
                .clickable {
                    onSkipAdClick()
                }
        )
        //endregion
        Text(
            text = stringResource(R.string.copyright, year),
            color = MaterialTheme.colorScheme.onPrimary,
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 30.dp)
                .clickable {
                    onSkipAdClick()
                }
        )
        Text(
            text = "倒计时$timeLeft",
            style = TextStyle(fontSize = 20.sp),
            modifier = Modifier.align(Alignment.TopEnd).padding(top=100.dp, end = 100.dp)
        )
    }

}
