package com.gmail.freedstate.findthepairs.game.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gmail.freedstate.findthepairs.game.domain.GameTimer
import com.gmail.freedstate.findthepairs.game.domain.GetRewardsUseCase
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class GameViewModel : ViewModel() {

    private val _uiState: MutableStateFlow<GameUiState> =
        MutableStateFlow(
            value = GameUiState.createStartState()
        )

    val uiState: StateFlow<GameUiState>
        get() = _uiState

    private val gameTimer: GameTimer = GameTimer().apply {
        setTask {
            viewModelScope.launch {
                _uiState.emit(
                    value = uiState.value.copy(
                        timePassed = it
                    )
                )
            }
        }
    }

    private val getRewardsUseCase = GetRewardsUseCase()

    lateinit var onGameEndListener: (Int) -> Unit

    fun sendAction(action: GameAction) {
        when (action) {
            is GameAction.ElementSelected -> {
                gameTimer.start()
                viewModelScope.launch {

                    when (uiState.value.gameElements.count { it.selected }) {
                        0 -> {
                            val nextElements = uiState.value.gameElements.toMutableList()
                            uiState.value.gameElements.forEachIndexed { index, item ->
                                if (item.id == action.id) {
                                    nextElements[index] = item.copy(selected = true)
                                }
                            }
                            _uiState.emit(
                                value = uiState.value.copy(
                                    gameElements = nextElements
                                )
                            )
                        }
                        1 -> {
                            val nextElements = uiState.value.gameElements.toMutableList()
                            uiState.value.gameElements.forEachIndexed { index, item ->
                                if (item.id == action.id) {
                                    nextElements[index] = item.copy(selected = true)
                                }
                            }
                            _uiState.emit(
                                value = uiState.value.copy(
                                    gameElements = nextElements
                                )
                            )
                            val filtered = uiState.value.gameElements.filter { it.selected }
                            if (filtered.size !=2) return@launch
                            if (filtered[0].imageResId != filtered[1].imageResId) {
                                val previousElements = uiState.value.gameElements.toMutableList()
                                uiState.value.gameElements.forEachIndexed { index, item ->
                                    if (item.selected) {
                                        previousElements[index] = item.copy(selected = false)
                                    }
                                }
                                delay(450)
                                _uiState.emit(
                                    value = uiState.value.copy(
                                        gameElements = previousElements
                                    )
                                )
                            } else {
                                val elementsWithFoundPairs = uiState.value.gameElements.toMutableList()
                                uiState.value.gameElements.forEachIndexed { index, item ->
                                    if (item.selected) {
                                        elementsWithFoundPairs[index] = item.copy(
                                            selected = false,
                                            pairGuessed = true
                                        )
                                    }
                                }
                                _uiState.emit(
                                    value = uiState.value.copy(
                                        gameElements = elementsWithFoundPairs
                                    )
                                )

                                if (uiState.value.gameElements.count { it.pairGuessed } == 20) {
                                    gameTimer.stop()
                                    val rewards = getRewardsUseCase.execute(
                                        timePassed = gameTimer.getSecondsPassedCount()
                                    )
                                    onGameEndListener.invoke(rewards)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}