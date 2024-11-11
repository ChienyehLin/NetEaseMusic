package com.example.neteasemusic.feature.discover

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.neteasemusic.core.model.Song
import com.example.neteasemusic.core.network.datasource.MyRetrofitDaraSource
import com.example.neteasemusic.core.ui.DiscoveryPreviewParameterData
import com.example.neteasemusic.core.ui.DiscoveryPreviewParameterData.SONG
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json


/**
 * 发现界面VM
 */
class DiscoverViewModel: ViewModel() {

    private val _data = MutableStateFlow<List<Song>>(emptyList())
    val data : StateFlow<List<Song>> = _data

    init {

        loadData()
    }

    private fun loadData() {
        //_data.value = DiscoveryPreviewParameterData.SONGS

//        val json = Json.encodeToString(SONG)
//        Log.d(TAG, "encodeToString: $json")
//        val obj = Json.decodeFromString<Song>(json)
//        Log.d(TAG, "encodeToString: $obj")
        //测试网路请求
        viewModelScope.launch {
            val songs = MyRetrofitDaraSource.getSongs()
            _data.value = songs.data?.list ?: emptyList()
        }
    }

    companion object{
        const val TAG= "DiscoverViewModel"
    }
}