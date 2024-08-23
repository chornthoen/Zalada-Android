package com.thoen.zaladaandroid.data

data class ItemCartModel(
    val id: Int,
    val name: String,
    val originalPrice: Double,
    val discountPrice: Double,
    val image: Int,
    val quantity: Int,
    val isChecked: Boolean = false
)
