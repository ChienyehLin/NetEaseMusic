package com.example.neteasemusic.feature.splash

import android.os.CountDownTimer
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

/**
 * 启动界面VM
 */
class SplashViewModel: ViewModel() {
    private var timer: CountDownTimer? = null

    /**
     * 倒计时秒数
     */
    private val _timeLeft = MutableStateFlow(0L)
    val timeLeft: StateFlow<Long> = _timeLeft

    /**
     * 是否跳转到主界面
     */
    val navigateToMain = MutableStateFlow(false)


    init {
        delayToNextPage(1)
    }

    private fun delayToNextPage(timeLeft :Long = 3000) {
        timer = object : CountDownTimer(timeLeft,1000L){
            override fun onTick(millisUntilFinished: Long) {
                //每次倒计时执行
                _timeLeft.value = millisUntilFinished/ 1000 +1
            }

            override fun onFinish() {
                toNext()
            }
        }.start()
    }

    private fun toNext() {
         navigateToMain.value = true
    }

    fun onSkipAdClick() {
        timer?.cancel()
        toNext()

    }

}