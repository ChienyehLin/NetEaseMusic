package com.example.neteasemusic.feature.main

import android.app.Application
import com.example.neteasemusic.R
import com.example.neteasemusic.feature.discover.DISCOVERY_ROUTE
import com.example.neteasemusic.feature.feed.FEED_ROUTE
import com.example.neteasemusic.feature.me.ME_ROUTE
import com.example.neteasemusic.feature.shortvideo.SHORT_VIDEO_ROUTE


enum class TopLevelDestination(
    val selectedIcon: Int,
    val unselectedIcon: Int,
    val titleTextId: Int,
    val route: String
) {
    //发现界面
    DISCOVERY(
        selectedIcon = R.drawable.tab_mall_main_selected,
        unselectedIcon = R.drawable.tab_mall_main,
        titleTextId = R.string.home,
        route = DISCOVERY_ROUTE
    )    ,

    //发现界面
    SHORT_VIDEO(
        selectedIcon = R.drawable.tab_mall_video_selected,
        unselectedIcon = R.drawable.tab_mall_video,
        titleTextId = R.string.video,
        route = SHORT_VIDEO_ROUTE
    ),

    //发现界面
    ME(
        selectedIcon = R.drawable.tab_mall_me_selected,
        unselectedIcon = R.drawable.tab_mall_me,
        titleTextId = R.string.me,
        route = ME_ROUTE
    ),
    //发现界面
    FEED(
        selectedIcon = R.drawable.tab_mall_cart_selected,
        unselectedIcon = R.drawable.tab_mall_cart,
        titleTextId = R.string.feed,
        route = FEED_ROUTE
    )

}