@file:OptIn(ExperimentalMaterial3Api::class)

package com.quiraadev.hadithcompose.common.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.quiraadev.hadithcompose.data.remote.response.content.HadithContents
import com.quiraadev.hadithcompose.data.remote.response.hadith.HadithDataResponse
import com.quiraadev.hadithcompose.ui.fonts.PlusJakartaSans

@Composable
fun HadithCard(
    hadith : HadithContents,
    onClick: (Int) -> Unit,
) {


    return ElevatedCard(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        onClick = {
            onClick(hadith.number)
        }
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
        ) {
            Text(
                text = "Hadith: ${hadith.number}",
                style = TextStyle(
                    fontFamily = PlusJakartaSans,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium
                ),
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        }
    }
}