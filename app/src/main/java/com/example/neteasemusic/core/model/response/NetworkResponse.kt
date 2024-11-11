package com.example.neteasemusic.core.model.response

import kotlinx.serialization.Serializable

/**
 * 解析网路响应
 */
@Serializable
data class NetworkResponse<T>(

    /**
     * 真实数据
     * 类型是泛型
     */
    val data: T? = null,
    /**
     * 状态码
     */
    val status: Int = 0,

    /**
     * 出错的信息
     */
    val message: String? = null
)