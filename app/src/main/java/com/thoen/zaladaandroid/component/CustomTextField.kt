package com.thoen.zaladaandroid.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.thoen.zaladaandroid.R


@Composable
fun CustomTextField(
    modifier: Modifier = Modifier,
    keyboardType: KeyboardType = KeyboardType.Text,
    label: String = "",
    value: String = "",
    onTextChanged: (value: String) -> Unit,
    passwordVisible: Boolean = false
) {

    var passwordVisible by rememberSaveable { mutableStateOf(passwordVisible) }
    TextField(
        value = value,
        onValueChange = onTextChanged,
        label = { Text(text = label) },
        singleLine = true,
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Color.Transparent,
            unfocusedBorderColor = Color.Transparent,
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.White,
            focusedSuffixColor = Color.Blue,
            focusedLabelColor = Color.Gray,
        ),
        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        trailingIcon = {
            if (keyboardType == KeyboardType.Password) {
                val image = if (passwordVisible)
                    painterResource(id = R.drawable.show)
                else painterResource(id = R.drawable.hide)

                val description = if (passwordVisible) "Hide" else "Show"

                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    Image(
                        painter = image,
                        contentDescription = description
                    )
                }
            }
        },
        modifier = Modifier
            .padding(12.dp)
            .fillMaxWidth()
            .border(
                width = 1.dp,
                color = Color(0xFF495E57),
                shape = RoundedCornerShape(8.dp)
            )


            .background(Color(0xFFFFFFFF))
    )
}