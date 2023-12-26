package com.gmail.freedstate.findthepairs.game.presentation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.gmail.freedstate.findthepairs.R
import com.gmail.freedstate.findthepairs.design.LocalExtendedAppColors
import com.gmail.freedstate.findthepairs.game.domain.GameElementModel

@Composable
fun GameScreen(
    onGameFinishedListener: (Int) -> Unit
) {
    val vm = viewModel<GameViewModel>()
    vm.onGameEndListener = onGameFinishedListener
    val uiState by vm.uiState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 48.dp)
    ) {
        Text(
            text = stringResource(id = R.string.background_6),
            style = MaterialTheme.typography.headlineSmall,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(top = 16.dp)
                .fillMaxWidth()
        )
        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    TimeCounter(time = uiState.timePassed)
                    Text(
                        text = stringResource(id = R.string.less_time),
                        style = MaterialTheme.typography.bodySmall,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                    )
                }
                CoinCounter(coinCount = uiState.coinCountText)
            }

            Spacer(modifier = Modifier.height(16.dp))

            GameCellsArea(
                cellsModels = uiState.gameElements,
                viewModel = vm
            )

            Text(
                text = stringResource(id = R.string.game_descr),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier
                    .fillMaxWidth()
            )

            Text(
                text = stringResource(id = R.string.fast),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier
                    .fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(24.dp))
        }


    }

}

@Composable
fun CoinCounter(coinCount: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .wrapContentSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.coins),
            contentDescription = null
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = coinCount,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Composable
fun TimeCounter(
    time: String
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
    ) {
        Image(
            painter = painterResource(id = R.drawable.clock),
            contentDescription = null,
            modifier = Modifier
                .width(164.dp)
        )
        Text(
            text = time,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier
                .padding(top = 10.dp, start = 10.dp)
        )
    }
}

@Composable
fun GameCellsArea(
    cellsModels: List<GameElementModel>,
    viewModel: GameViewModel
) {
    LazyVerticalGrid(
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        columns = GridCells.Fixed(count = 4),
        userScrollEnabled = false
    ) {
        items(items = cellsModels) { gameElementModel ->
            GameElement(
                model = gameElementModel
            ) {
                viewModel.sendAction(
                    action = GameAction.ElementSelected(
                        id = it
                    )
                )
            }
        }
    }
}

@Composable
fun GameElement(
    model: GameElementModel,
    onClick: (Int) -> Unit
) {
    val cellColor =
        if (model.pairGuessed) LocalExtendedAppColors.current.guessedCellBackground
        else LocalExtendedAppColors.current.notGuessedCellBackground

    MaterialTheme(
        colorScheme = lightColorScheme(
            surfaceVariant = cellColor
        )
    ) {
        Card(
            shape = RoundedCornerShape(size = 18.dp),
            modifier = Modifier
                .aspectRatio(ratio = 1f)
                .clip(RoundedCornerShape(size = 18.dp))
                .clickable(enabled = !model.pairGuessed) {
                    onClick.invoke(model.id)
                }
        ) {
            AnimatedVisibility(
                visible = model.selected || model.pairGuessed,
                enter = scaleIn() + fadeIn(),
                exit = fadeOut()
            ) {
                Image(
                    painter = painterResource(
                        id = model.imageResId
                    ),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(12.dp)
                )
            }
        }
    }
}