package com.gmail.freedstate.findthepairs.congratulations.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.gmail.freedstate.findthepairs.R
import com.gmail.freedstate.findthepairs.design.LocalExtendedAppColors

@Composable
fun CongratulationsScreen(
    coinCount: Int
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 56.dp)
    ) {
        Text(
            text = stringResource(id = R.string.gameplay),
            style = MaterialTheme.typography.headlineSmall,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(top = 16.dp)
                .fillMaxWidth()
        )
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp, alignment = Alignment.CenterVertically),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = R.drawable.congratulations),
                contentDescription = null,
                modifier = Modifier
                    .size(96.dp)
            )
            Text(
                text = stringResource(id = R.string.congratulation),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight(900),
                modifier = Modifier
                    .fillMaxWidth()
            )
            Text(
                text = stringResource(id = R.string.you_won),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier
                    .fillMaxWidth()
            )
            Box (
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .height(height = 92.dp)
                    .fillMaxWidth()
                    .background(
                        color = LocalExtendedAppColors.current.congratulationsCoinBackground,
                        shape = RoundedCornerShape(24.dp)
                    )
            ){
                CoinCounter(coinCount)
            }
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp)
            ) {
                Button(
                    onClick = {  },
                    modifier = Modifier
                        .height(76.dp)
                        .width(214.dp)

                ) {
                    Text(
                        text = stringResource(id = R.string.double_reward),
                        style = MaterialTheme.typography.titleLarge
                    )
                }
                ArrowIcon()
            }
        }
    }
}

@Composable
fun CoinCounter(coinCount: Int) {
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
        Text(text = coinCount.toString())
    }
}

@Composable
fun ArrowIcon() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(76.dp)
            .background(
                color = LocalExtendedAppColors.current.privacyBackground,
                shape = RoundedCornerShape(18.dp)
            )
    ) {
        Image(
            painter = painterResource(
                id = R.drawable.arrow_up
            ),
            contentDescription = null,
            modifier = Modifier.padding(24.dp)
        )
    }
}