package com.thoen.zaladaandroid.views.home.functions

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LabelAndAction(
    label: String,
    onClick: () -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Text(
            text = label,
            fontSize = 16.sp,
            fontWeight = FontWeight.W600,
        )
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = "See All",
            fontSize = 14.sp,
            fontWeight = FontWeight.W500,
            color = Color(0xFF1B5EC9),
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                .clickable(
                    onClick = onClick,

                    )
                .clip(RoundedCornerShape(8.dp))
                .padding(4.dp)
        )
    }
}




@Composable
fun ShapeIcon(
    onClick: () -> Unit,
    icon: Int,
    count : Int = 0
) {
    Box (
        contentAlignment = Alignment.TopEnd
    ){
        Box(
            modifier = Modifier
                .size(50.dp)
                .clip(RoundedCornerShape(100))
                .background(Color.White.copy(alpha = 0.2f))
                .clickable(
                    onClick = onClick
                ),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = icon),
                contentDescription = "Icon",
                modifier = Modifier
                    .height(280.dp),
                colorFilter = ColorFilter.tint(Color.White),

                alignment = Alignment.CenterEnd
            )
        }
        if (count > 0) {
            Box(
                modifier = Modifier
                    .size(20.dp)
                    .clip(RoundedCornerShape(100))
                    .background(Color(0xFFFF5944)),
                contentAlignment = Alignment.Center

            ) {
                Text(
                    text = "3",
                    color = Color.White,
                    fontSize = 12.sp,
                    lineHeight = 16.sp,
                    fontWeight = FontWeight.W600
                )
            }
        }
    }
}
