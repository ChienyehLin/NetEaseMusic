package com.example.neteasemusic.util

import java.util.Calendar

/**
 * Created by jadenlin on 10/19/24
 * @author jadenlin@bytedance.com
 */
object SuperDateUtil {
    /**
     * 获取当前年
     */
    fun getCurrentYear() :Int{
        return Calendar.getInstance().get(Calendar.YEAR)
    }
}