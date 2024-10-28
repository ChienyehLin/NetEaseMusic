package com.example.neteasemusic.coredesign.component

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.glance.text.Text
import com.example.neteasemusic.coredesign.theme.SpaceSmallHeight
import com.example.neteasemusic.feature.main.TopLevelDestination

/**
 * 底部导航
 */
@Composable
fun MyNavigationBar(
    destinations: List<TopLevelDestination>,
    currentDestination: String,
    onNavigateToDestination: (Int) -> Unit,
    modifier: Modifier = Modifier
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