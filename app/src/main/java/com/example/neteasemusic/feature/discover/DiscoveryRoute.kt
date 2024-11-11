package com.example.neteasemusic.feature.discover

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.exclude
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScaffoldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.neteasemusic.R
import com.example.neteasemusic.core.design.theme.LocalDividerColor
import com.example.neteasemusic.core.design.theme.NetEaseMusicTheme
import com.example.neteasemusic.core.design.theme.SpaceExtraMedium
import com.example.neteasemusic.core.design.theme.SpaceMedium
import com.example.neteasemusic.core.design.theme.SpaceOuter
import com.example.neteasemusic.core.model.Song
import com.example.neteasemusic.core.ui.DiscoveryPreviewParameterData.SONGS
import com.example.neteasemusic.core.ui.DiscoveryPreviewParameterProvider
import com.example.neteasemusic.song.component.SongItem


@Composable
fun DiscoveryRoute(viewModel: DiscoverViewModel = viewModel()) {

    val data by viewModel.data.collectAsState()
    DiscoveryScreen(songs = data)
}

@Composable
fun DiscoveryScreen(
    toggleDrawer: () -> Unit = {}, toSearch: () -> Unit = {},
    songs: List<Song> = listOf()
) {
    Scaffold(
        topBar = {
            DiscoverTopBar(
                toggleDrawer, toSearch
            )
        },
        //排除底部导航烂边距
        contentWindowInsets = ScaffoldDefaults.contentWindowInsets.exclude(WindowInsets.navigationBars)
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.surfaceVariant)
                .padding(paddingValues)

        ) {
            LazyColumn(
                modifier = Modifier.fillMaxWidth(),
                contentPadding = PaddingValues(horizontal = SpaceOuter),
                verticalArrangement = Arrangement.spacedBy(SpaceMedium)
            ) {
                items(songs) {
                    SongItem(song = it)
                }

            }
        }
    }
}

/**
 * 发现界面顶部标题栏
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DiscoverTopBar(toggleDrawer: () -> Unit, toSearch: () -> Unit) {
    CenterAlignedTopAppBar(navigationIcon = {
        IconButton(onClick = toggleDrawer) {
            Icon(
                imageVector = Icons.Default.Menu,
                contentDescription = null,
                modifier = Modifier.size(36.dp)
            )
        }
    }, title = {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(38.dp)
                .clip(RoundedCornerShape(50.dp))
                .background(LocalDividerColor.current)
                .clickable { toSearch() },
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
        ) {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.outline,
                modifier = Modifier.size(18.dp)
            )
            Text(
                text = stringResource(id = R.string.search_tip),
                color = MaterialTheme.colorScheme.outline,
                style = MaterialTheme.typography.bodySmall,
            )
        }
    }, actions = {
        Icon(
            painter = painterResource(R.drawable.message),
            contentDescription = null,
            tint = MaterialTheme.colorScheme.onSurface,
            modifier = Modifier
                .padding(horizontal = SpaceExtraMedium)
                .size(28.dp)
        )

    }, colors = TopAppBarDefaults.centerAlignedTopAppBarColors().copy(
        containerColor = MaterialTheme.colorScheme.surfaceVariant
    )
    )
}

@Preview(showBackground = true, apiLevel = 33)
@Composable
fun DiscoveryScreenPreview(
    @PreviewParameter(DiscoveryPreviewParameterProvider::class)
    song: List<Song>
) {
    NetEaseMusicTheme {
        DiscoveryScreen(songs = song)
    }
}