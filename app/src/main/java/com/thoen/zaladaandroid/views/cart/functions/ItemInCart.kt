package com.thoen.zaladaandroid.views.cart.functions

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.thoen.zaladaandroid.R


@Composable
fun ItemInCart(
    modifier: Modifier = Modifier,
    onDeleted: () -> Unit = {},
    onMinus: () -> Unit = {},
    onPlus: () -> Unit = {},
    title: String,
    originalPrice: Double,
    discountPrice: Double,
    image: Int,
    quantity: Int,
    isChecked: Boolean,
    onCheckedChange: (Boolean) -> Unit = {}
) {
    var isChecke by remember { mutableStateOf(false) }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp)
            .padding(horizontal = 16.dp)
            .clip(shape = RoundedCornerShape(16.dp))
            .background(Color.White)
            .padding(vertical = 8.dp),
        contentAlignment = Alignment.CenterStart
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = isChecked,
                onCheckedChange = {
                    isChecke = it
                    onCheckedChange(it)
                },
                colors = CheckboxDefaults.colors(
                    checkmarkColor = Color.White,
                    checkedColor = Color(0xFF2D3C52),
                    uncheckedColor = Color(0xFF2D3C52)
                )
            )
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(4.dp))
                    .padding(4.dp)
            ) {
                Image(
                    painter = painterResource(id = image),
                    contentDescription = "Product Image",
                    modifier = Modifier.size(100.dp)
                )
            }
            Spacer(modifier = Modifier.size(8.dp))
            Column(
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Text(
                    text = title,
                    fontWeight = FontWeight.W500,
                    fontSize = 14.sp,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "$discountPrice\$",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF2D3C52)
                    )
                    Spacer(modifier = Modifier.size(4.dp))
                    Text(
                        text = "$originalPrice\$",
                        fontSize = 10.sp,
                        color = Color.Gray,
                        textDecoration = TextDecoration.LineThrough
                    )
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    ButtonAdd(
                        onClick = {
                            onMinus()
                        },
                        icon = R.drawable.remove
                    )
                    Spacer(modifier = Modifier.size(8.dp))
                    Box {
                        Text(
                            text = "$quantity",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF2D3C52)
                        )
                    }
                    Spacer(modifier = Modifier.size(8.dp))
                    ButtonAdd(
                        onClick = {
                            onPlus()
                        },
                        icon = R.drawable.add_
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    ButtonDelete(
                        onClick = {
                            onDeleted()
                        },
                        icon = R.drawable.delete
                    )
                }
            }
        }
    }
}

