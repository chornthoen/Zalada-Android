package com.thoen.zaladaandroid.views.profile.functions

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.KeyboardArrowRight
import androidx.compose.material3.HorizontalDivider
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
fun ItemProfile(
    onClick:  () -> Unit = {},
    icon: Int,
    title: String,
    end: Boolean = false,
    modifier: Modifier = Modifier,
    color: Color = Color(0xFF2D3C52)

){
    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(4.dp))
            .background(Color.White)
            .clickable(
                onClick = onClick
            )
    ) {
        Row (
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(8.dp)
        ){
            Box (
                modifier = Modifier
                    .clip(RoundedCornerShape(100))
                    .background(color.copy(alpha = 0.1f))
                    .padding(4.dp)
            ) {
                Image(
                    painter = painterResource(id = icon),
                    contentDescription = "",
                    modifier = Modifier.size(24.dp),
                    colorFilter = ColorFilter.tint(color)
                )
            }
            Spacer(modifier = Modifier.size(8.dp))
            Text(
                text = title,
                color = Color.Black,
                fontWeight = FontWeight.W400,
                fontSize = 14.sp
            )
            Spacer(modifier = Modifier.weight(1f))
            Image(
                imageVector = Icons.AutoMirrored.Rounded.KeyboardArrowRight,
                contentDescription = "",
                modifier = Modifier.size(24.dp),
                colorFilter = ColorFilter.tint(Color.Gray)
            )
        }
        if (!end)
            HorizontalDivider(
                thickness = 1.dp,
                color = Color.Gray.copy(alpha = 0.2f)
            )
    }
}
