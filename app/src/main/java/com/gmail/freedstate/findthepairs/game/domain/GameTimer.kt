package com.gmail.freedstate.findthepairs.game.domain

import java.lang.IllegalStateException
import java.util.Timer
import kotlin.concurrent.timer

class GameTimer {

    private var secondsCounter: Int = 0
    private var task: ((currentTime: String) -> Unit)? = null
    private var timer: Timer? = null
    private var timerState: Boolean = false

    fun setTask(task: (currentTime: String) -> Unit) {
        this.task = task
    }

    fun start() {
        if (task == null) throw IllegalStateException(
            "Task must be initialized. Call setTask() function with passing task lambda"
        )
        if (timerState) return
        timerState = true
        timer = timer(initialDelay = 1000L, period = 1000L) {
            if (secondsCounter == 3599) secondsCounter = 0
            else secondsCounter++
            task?.invoke(
                getFormattedTime(secondsCounter)
            )
        }
    }

    fun stop() {
        timer?.cancel()
        timer = null
        timerState = false
    }

    fun getSecondsPassedCount(): Int = secondsCounter

    private fun getFormattedTime(secondsCount: Int): String {
        val minutes = secondsCount / 60
        val seconds = secondsCount % 60
        val stringBuilder = StringBuilder()
        val minutesStr = minutes.toString().padStart(2, '0')
        val secondsStr = seconds.toString().padStart(2, '0')
        return stringBuilder.apply {
            append(minutesStr)
            append(":")
            append(secondsStr)
        }.toString()
    }
}