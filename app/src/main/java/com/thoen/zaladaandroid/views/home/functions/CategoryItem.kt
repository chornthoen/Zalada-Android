package com.thoen.zaladaandroid.views.home.functions

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
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
fun CategoryItem(
    onClick: () -> Unit,
    icon: Int,
    title: String
) {
    Box(
        modifier = Modifier
            .padding(end = 12.dp)
            .size(80.dp, 80.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(Color.White)
            .clickable(
                onClick = onClick
            )
            .padding(vertical = 4.dp, horizontal = 2.dp),


        contentAlignment = Alignment.Center
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(100))
                    .background(Color(0xFF576F85).copy(alpha = 0.2f))
                    .padding(8.dp)
            ) {
                Image(
                    painter = painterResource(id = icon),
                    contentDescription = "Mac",
                    modifier = Modifier
                        .size(26.dp)
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(8.dp)),
                    colorFilter = ColorFilter.tint(Color.White)
                )
            }
            Spacer(modifier = Modifier.size(4.dp))
            Text(
                text = title,
                fontSize = 12.sp,
                fontWeight = FontWeight.W500
            )
        }
    }
}