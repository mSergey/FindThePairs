package com.gmail.freedstate.findthepairs.game.domain

class GetRewardsUseCase {
    fun execute(
        timePassed: Int
    ): Int {
        return when (timePassed) {
            in 0..20 -> 100
            else -> {
                val rewards = 100 - 5 * (timePassed - 20)
                rewards.coerceAtLeast(10)
            }
        }
    }
}