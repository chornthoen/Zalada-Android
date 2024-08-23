package com.thoen.zaladaandroid.views.cart.functions

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
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
fun ButtonAdd(
    onClick: () -> Unit,
    icon: Int
) {
    Box(
        modifier = Modifier
            .size(34.dp)
            .clip(RoundedCornerShape(100))
            .background(Color.Gray.copy(alpha = 0.1f))
            .clickable(
                onClick = onClick
            ),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = "Minus",
            tint = Color(0xFF2D3C52),
        )
    }
}
