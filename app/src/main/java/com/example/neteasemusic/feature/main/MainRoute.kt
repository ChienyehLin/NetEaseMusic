package com.example.neteasemusic.feature.main

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRowScopeInstance.weight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.unit.dp
import com.example.neteasemusic.coredesign.component.MyNavigationBar
import com.example.neteasemusic.feature.discover.DiscoveryRoute
import com.example.neteasemusic.feature.feed.FeedRoute
import com.example.neteasemusic.feature.me.MeRoute
import com.example.neteasemusic.feature.shortvideo.ShortVideoRoute

@Composable
fun MainRoute(
    finishPage: () -> Unit
) {

    MainScreen(finishPage)
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MainScreen(finishPage: () -> Unit = {}) {
    val pageState = rememberPagerState {
        4
    }

    Column(modifier = Modifier.fillMaxSize()) {
        HorizontalPager(
            state = pageState,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            userScrollEnabled = false,
            beyondBoundsPageCount = 4, //加载屏幕外更多特面的数量
        ) { page ->
            when (page) {
                0 -> DiscoveryRoute()
                1 -> ShortVideoRoute()
                2 -> MeRoute()
                3 -> FeedRoute()
            }

        }

        MyNavigationBar()

    }

}
