package com.gmail.freedstate.findthepairs.game.presentation

import com.gmail.freedstate.findthepairs.R
import com.gmail.freedstate.findthepairs.game.domain.GameElementModel
private const val DEFAULT_COIN_COUNT = "100"
private const val DEFAULT_TIME_PASSED = "00:00"

data class GameUiState(
    val backgroundTextResId: Int,
    val lessTimeTextResId: Int,
    val gameDescrTextResId: Int,
    val fastTextResId: Int,
    val coinCountText: String,
    val timePassed: String,
    val gameElements: List<GameElementModel>
) {

    companion object {
        fun createStartState(): GameUiState {
            val gameElements = mutableListOf<GameElementModel>()
            val gameElementImageIds = mutableListOf(
                R.drawable.blue_diamond,
                R.drawable.blue_stone,
                R.drawable.blue_heart,
                R.drawable.yellow_diamond,
                R.drawable.yellow_heart,
                R.drawable.yellow_stone,
                R.drawable.green_diamond,
                R.drawable.green_heart,
                R.drawable.pink_diamond,
                R.drawable.pink_stone,
            )
            val newElements = gameElementImageIds.apply {
                addAll(this)
                shuffle()
                //sortBy { it }
            }

            repeat(20) {
                val newGameElement = GameElementModel(
                    id = it,
                    imageResId = newElements[it],
                    pairGuessed = false,
                    selected = false
                )
                gameElements.add(newGameElement)
            }

            return GameUiState(
                backgroundTextResId = R.string.background_6,
                lessTimeTextResId = R.string.less_time,
                gameDescrTextResId = R.string.game_descr,
                fastTextResId = R.string.fast,
                coinCountText = DEFAULT_COIN_COUNT,
                timePassed = DEFAULT_TIME_PASSED,
                gameElements = gameElements,
            )
        }
    }
}
