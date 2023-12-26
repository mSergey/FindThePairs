package com.gmail.freedstate.findthepairs.game.domain

data class GameElementModel(
    val id: Int,
    val imageResId: Int,
    val pairGuessed: Boolean,
    val selected: Boolean
)
