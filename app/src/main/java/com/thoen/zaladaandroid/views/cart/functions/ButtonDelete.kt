package com.thoen.zaladaandroid.views.cart.functions

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp


@Composable
fun ButtonDelete(
    onClick: () -> Unit,
    icon: Int
) {
    Box(
        modifier = Modifier
            .padding(end = 12.dp)
            .size(34.dp)
            .clip(RoundedCornerShape(12))
            .background(Color(0xFFFF5944).copy(alpha = 0.09f))
            .clickable(
                onClick = onClick
            ),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = "Minus",
            tint = Color(0xFFFF5944),
            modifier = Modifier.size(24.dp)
        )
    }
}
