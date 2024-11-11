package com.example.neteasemusic.core.network.datasource

import com.example.neteasemusic.core.config.Config
import com.example.neteasemusic.core.model.Song
import com.example.neteasemusic.core.model.response.NetworkPageData
import com.example.neteasemusic.core.model.response.NetworkResponse
import com.example.neteasemusic.core.network.di.NetworkModule
import com.example.neteasemusic.core.network.retrofit.MyNetworkApiService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import okhttp3.Call
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

object MyRetrofitDaraSource {

    /**
     * 网络请求接口
     */
    private val service =
        Retrofit.Builder().baseUrl(Config.ENDPOINT).callFactory(NetworkModule.provideOkHttpClient())
            .addConverterFactory(
                NetworkModule.providesNetworkJson()
                    .asConverterFactory("application/json".toMediaType())
            ).build().create(MyNetworkApiService::class.java)

    suspend fun getSongs(): NetworkResponse<NetworkPageData<Song>> {
        return service.getSongs()
    }

    suspend fun getSongDetail(id: String): NetworkResponse<Song> {
        return service.getSongDetail(id)
    }
}
