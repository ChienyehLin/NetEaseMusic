package com.example.neteasemusic.song.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.neteasemusic.R
import com.example.neteasemusic.core.design.theme.NetEaseMusicTheme
import com.example.neteasemusic.core.design.theme.SpaceSmallHeight
import com.example.neteasemusic.core.model.Song
import com.example.neteasemusic.core.ui.DiscoveryPreviewParameterData.SONG
import com.example.neteasemusic.core.ui.DiscoveryPreviewParameterData.SONGS


/**
 * 单曲Item
 */
@Composable
fun SongItem(song: Song, modifier: Modifier = Modifier) {

    Row(
        modifier = modifier.fillMaxWidth()
    ) {
        Image(
            painter = painterResource(R.drawable.placeholder),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(50.dp)
                .clip(MaterialTheme.shapes.small)
            //.background(LocalDividerColor.current)
        )

        Column(modifier = Modifier.weight(1f)) {
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
fun ItemPreview() {
    NetEaseMusicTheme {
        SongItem(SONG)
    }
}