package com.thoen.zaladaandroid.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.thoen.zaladaandroid.R

@Composable
fun ButtonBack(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(100))
            .background(Color.White.copy(alpha = 0.1f))
            .border(
                width = 1.dp,
                color = Color.Gray.copy(alpha = 0.1f),
                shape = RoundedCornerShape(100)
            )
            .clickable(
                onClick = onClick
            )
            .padding(8.dp),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = painterResource(id = R.drawable.arrow_left),
            contentDescription = "Minus",
            tint = Color(0xFF2D3C52),
        )
    }

}
