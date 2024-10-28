package com.example.neteasemusic.design.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.neteasemusic.design.theme.SpaceSmallHeight

import com.example.neteasemusic.feature.main.TopLevelDestination


/**
 * 底部导航
 */
@Composable
fun MyNavigationBar(
    destinations: List<TopLevelDestination>,
    currentDestination: String,
    modifier: Modifier = Modifier,
    onNavigateToDestination: (Int) -> Unit,
): Unit {
    Row(modifier = Modifier.fillMaxWidth()) {

        destinations.forEachIndexed { index, destionation ->
            Column(modifier = Modifier.weight(1f)) {
                Image(
                    painter = painterResource(id = destionation.unselectedIcon),
                    contentDescription = stringResource(destionation.titleTextId),
                    modifier = Modifier.size(25.dp)
                )
                SpaceSmallHeight()
                Text(text = stringResource(id = destionation.titleTextId))
            }

        }

    }
}