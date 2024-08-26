package com.thoen.zaladaandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.thoen.zaladaandroid.router.AppRouter
import com.thoen.zaladaandroid.ui.theme.ZaladaAndroidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ZaladaAndroidTheme {
                AppRouter()
            }
        }
    }
}
