package com.thoen.zaladaandroid.views.profile.functions

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
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
fun SwitcherNotification(
    onCheckedChange: (Boolean) -> Unit = {},
    icon: Int,
    title: String,
    checked: Boolean = false,

    ){
    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(4.dp))
            .background(Color.White)
    ) {
        Row (
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(8.dp)
        ){
            Box (
                modifier = Modifier
                    .clip(RoundedCornerShape(100))
                    .background(Color(0xFF2D3C52).copy(alpha = 0.1f))
                    .padding(4.dp)
            ) {
                Image(
                    painter = painterResource(id = icon),
                    contentDescription = "",
                    modifier = Modifier.size(24.dp),
                    colorFilter = ColorFilter.tint(Color(0xFF2D3C52))
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
            Switch(
                checked = checked,
                onCheckedChange = onCheckedChange,
                colors = SwitchDefaults.colors(
                    checkedThumbColor = Color.White,
                    checkedTrackColor = Color(0xFF2D3C52),
                    uncheckedThumbColor = Color.White,
                    uncheckedTrackColor = Color(0xFF2D3C52).copy(alpha = 0.2f)
                )
            )
        }
    }
}
