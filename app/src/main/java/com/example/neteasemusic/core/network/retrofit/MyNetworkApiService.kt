package com.example.neteasemusic.core.network.retrofit

import com.example.neteasemusic.core.model.Song
import com.example.neteasemusic.core.model.response.NetworkPageData
import com.example.neteasemusic.core.model.response.NetworkResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

/**
 * 网络请求接口
 */
interface MyNetworkApiService {

    @GET("v1/songs/page")
    suspend fun getSongs(): NetworkResponse<NetworkPageData<Song>>

    @GET("v1/songs/info")
    suspend fun getSongDetail(@Query(value = " id") id: String): NetworkResponse<Song>

/*    @POST("v1/login")
    suspend fun login(@Body data:User): NetworkResponse<Session>*/



}