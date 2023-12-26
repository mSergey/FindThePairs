package com.gmail.freedstate.findthepairs.menu.presentation

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.gmail.freedstate.findthepairs.R
import com.gmail.freedstate.findthepairs.design.LocalExtendedAppColors

@Composable
fun MenuScreen(
    playButtonClickListener: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 48.dp)
    ) {
        Text(
            text = stringResource(id = R.string.background_3),
            style = MaterialTheme.typography.headlineSmall,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(top = 16.dp)
                .fillMaxWidth()
        )
        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .fillMaxSize()
        ) {
            CoinCounter(coinCount = 100)
            Spacer(modifier = Modifier.height(36.dp))
            PlayGameIcon()
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = { playButtonClickListener() },
                modifier = Modifier
                    .width(142.dp)
                    .align(Alignment.CenterHorizontally)
            ) {
                Text(
                    text = stringResource(id = R.string.play),
                    style = MaterialTheme.typography.titleLarge
                )
            }
            Spacer(modifier = Modifier.height(36.dp))
            PrivacyIcon()
            Spacer(modifier = Modifier.height(12.dp))
        }
    }
}

@Composable
fun PrivacyIcon() {
    Box(
        contentAlignment = Alignment.CenterEnd,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(98.dp)
                .background(
                    color = LocalExtendedAppColors.current.privacyBackground,
                    shape = RoundedCornerShape(24.dp)
                )
        ) {
            Image(
                painter = painterResource(
                    id = R.drawable.privacy
                ),
                contentDescription = null,
                modifier = Modifier.padding(24.dp)
            )
        }
    }
}

@Composable
fun PlayGameIcon() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(176.dp)
                .background(
                    color = LocalExtendedAppColors.current.gameLogoBackground,
                    shape = RoundedCornerShape(32.dp)
                )
        ) {
            Text(
                text = stringResource(id = R.string.game_logo),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.headlineMedium
            )
        }
    }
}

@Composable
fun CoinCounter(
    coinCount: Int
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.End,
        modifier = Modifier
        .fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = R.drawable.coins),
            contentDescription = null
        )
        Spacer(
            modifier = Modifier.width(8.dp)
        )
        Text(
            text = coinCount.toString(),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}