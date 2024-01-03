package com.quiraadev.hadithcompose.common.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Clear
import androidx.compose.material.icons.rounded.Refresh
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.quiraadev.hadithcompose.R
import com.quiraadev.hadithcompose.common.constants.WarningMessageState
import java.util.Locale


class Warning(
    val title: String,
    val icon: Painter
)


@Composable
fun WarningMessage(
    warningType: WarningMessageState,
    errorCode: String = "",
    callback: () -> Unit? = {}
) {
    val warn: Warning = when (warningType) {
        WarningMessageState.ERROR -> Warning(
            title = "Click Here to Retry",
            icon = painterResource(id = R.drawable.error)
        )
        WarningMessageState.LOADING -> Warning(
            title = "Loading...",
            icon = painterResource(id = R.drawable.loading_icon)
        )
        WarningMessageState.EMPTY -> Warning(
            title = "Empty",
            icon = painterResource(id = R.drawable.empty)
        )
    }

    val onClick: () -> Unit = {
        if (warningType == WarningMessageState.ERROR) {
            callback()
        }
    }

    return Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(painter = warn.icon, contentDescription = "Icon", modifier = Modifier.size(48.dp))
        Spacer(modifier = Modifier.height(16.dp))
        if (warningType == WarningMessageState.ERROR) {
            Text(
                text = errorCode.uppercase(Locale.getDefault()),
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    lineHeight = 0.2.sp
                ),
                textAlign = TextAlign.Center
            )
        }
        TextButton(onClick = { onClick() }) {
            Text(
                text = warn.title,
                textAlign = TextAlign.Center,
                fontSize = 16.sp,
                color = MaterialTheme.colorScheme.onBackground
            )
        }
    }
}