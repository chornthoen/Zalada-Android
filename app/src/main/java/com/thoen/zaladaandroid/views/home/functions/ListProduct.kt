package com.thoen.zaladaandroid.views.home.functions

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.thoen.zaladaandroid.R

@Composable
fun ListProducts(
    end: Boolean = false,
    onClick: () -> Unit = {},
) {

    Box(
        modifier = Modifier
            .padding(end = if (end) 12.dp else 0.dp)
            .width(186.dp)
            .height(255.dp)
            .clip(RoundedCornerShape(16.dp))

            .background(Color.Transparent)

    ) {
        Box(
            modifier = Modifier
                .width(186.dp)
                .height(245.dp)
                .clip(RoundedCornerShape(16.dp))
                .clickable(
                    onClick = onClick
                )
                .background(Color.White)
                .padding(horizontal = 12.dp, vertical = 12.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.mac),
                    contentDescription = "Mac",
                    modifier = Modifier
                        .height(120.dp)
                        .width(130.dp)
                        .clip(RoundedCornerShape(16.dp))
                )
                Spacer(modifier = Modifier.size(8.dp))
                Text(
                    text = "Macbook Pro 2019 15” - Intel core i7",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.W600,
                    textAlign = TextAlign.Center,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.size(6.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "$1,200",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.W700,
                        color = Color(0xFF1B5EC9)
                    )
                    Spacer(modifier = Modifier.size(4.dp))
                    Text(
                        text = "$1,500",
                        fontSize = 10.sp,
                        color = Color(0xFF7C7D82),
                        fontWeight = FontWeight.W400,
                        textDecoration = TextDecoration.LineThrough
                    )
                }
            }
        }

        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .clip(RoundedCornerShape(16.dp))
                .background(Color(0xFFFF9C44))
                .padding(horizontal = 12.dp)
        ) {
            Text(
                text = "NEW ARRIVAL",
                fontSize = 10.sp,
                fontWeight = FontWeight.W600,
                color = Color.White
            )
        }
    }
}
