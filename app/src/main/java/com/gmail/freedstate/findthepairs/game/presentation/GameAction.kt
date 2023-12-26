package com.gmail.freedstate.findthepairs.game.presentation

sealed class GameAction {
    data class ElementSelected(val id: Int): GameAction()
}
