package com.example.neteasemusic.song.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.neteasemusic.R
import com.example.neteasemusic.core.design.theme.NetEaseMusicTheme
import com.example.neteasemusic.core.design.theme.SpaceMedium
import com.example.neteasemusic.core.design.theme.SpaceSmallHeight
import com.example.neteasemusic.core.design.theme.extraSmallRoundedCornerShape
import com.example.neteasemusic.core.model.Song
import com.example.neteasemusic.core.ui.DiscoveryPreviewParameterData.SONG


/**
 * 单曲Item
 */
@Composable
fun SongItem(song: Song, modifier: Modifier = Modifier) {

    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(R.drawable.placeholder),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(50.dp)
                .clip(extraSmallRoundedCornerShape)
            //.background(LocalDividerColor.current)
        )

        Column(modifier = Modifier
            .weight(1f)
            .padding(horizontal = SpaceMedium)) {
            Text(
                text = song.title,
                maxLines = 2,
                style = MaterialTheme.typography.titleSmall,
                color = MaterialTheme.colorScheme.onSurface
            )
            SpaceSmallHeight()
            Text(
                text = "${song.artist} - ${song.album}",
                maxLines = 2,
                style = MaterialTheme.typography.titleSmall,
                color = MaterialTheme.colorScheme.onSurface
            )
        }
    }

}


@Preview
@Composable
fun SongItemPreview(
) {
    NetEaseMusicTheme {
        SongItem(SONG)
    }
}