@file:OptIn(ExperimentalMaterial3Api::class)

package com.quiraadev.hadithcompose.common.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.rounded.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.quiraadev.hadithcompose.data.remote.response.authors.AuthorsResponseItem
import com.quiraadev.hadithcompose.ui.fonts.PlusJakartaSans

@Composable
fun AuthorCard(
    author: AuthorsResponseItem,
    onClick: (String) -> Unit?
) {
    return ElevatedCard(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        onClick = {
            onClick(author.id)
        }
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(16.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = author.name,
                    style = TextStyle(
                        fontFamily = PlusJakartaSans,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                    )
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Available Hadiths : ${author.available}",
                    style = TextStyle(
                        fontFamily = PlusJakartaSans,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium
                    )
                )
            }
            Icon(imageVector = Icons.Rounded.KeyboardArrowRight, contentDescription = "Icon")
        }
    }
}