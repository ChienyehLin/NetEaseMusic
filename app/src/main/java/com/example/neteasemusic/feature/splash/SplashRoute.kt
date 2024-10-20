package com.example.neteasemusic.feature.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.neteasemusic.ui.theme.NetEaseMusicTheme
import com.example.neteasemusic.util.SuperDateUtil
import com.quick.app.R

/**
 * Created by jadenlin on 10/5/24
 * @author jadenlin@bytedance.com
 */
@Composable
fun SplashRoute() {

    SplashScreen(year = SuperDateUtil.getCurrentYear())
}

@Composable
fun SplashScreen(
    year: Int = 2024
) {
    //box是相对布局
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primary)
    ) {
        //region 启动界面
        Image(
            painter = painterResource(id = R.drawable.splash_banner),
            contentDescription = "Splash logo",
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(150.dp)
        )

        Image(
            painter = painterResource(id = R.drawable.splash_logo),
            contentDescription = "Splash logo",
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(70.dp)
        )
        //endregion
        Text(
            text = stringResource(R.string.copyright, year),
            color = MaterialTheme.colorScheme.onPrimary,
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 30.dp)
        )
    }

}

@Preview(showBackground = true)
@Composable
fun SplashRoutePreview(): Unit {
    NetEaseMusicTheme {
        SplashScreen()
    }
}