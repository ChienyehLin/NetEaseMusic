package com.example.neteasemusic.coredesign.theme

import android.widget.Space
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


//region 分割线尺寸
val Space4XLarge = 40.dp
val Space3XL = 30.dp
val SpaceLarge = 20.dp
val SpaceOuter = 16.dp
val SpaceExtraOuter = 14.dp
val SpaceMedium = 10.dp
val SpaceExtraMedium = 7.dp
val SpaceSmall = 5.dp
val SpaceExtraSmall2 = 2.dp
val SpaceExtraSmall = 0.9.dp
// end

@Composable
fun SpaceSmallHeight(): Unit {
    Spacer(modifier = Modifier.height(SpaceSmall))
}