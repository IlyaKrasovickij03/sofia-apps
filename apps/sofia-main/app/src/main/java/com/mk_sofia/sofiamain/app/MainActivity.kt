package com.mk_sofia.sofiamain.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.google.firebase.FirebaseApp
import com.mk_sofia.core.ui.theme.SofiaMainTheme
import com.mk_sofia.feature_auth_screens.presentation.screens.EnterRegisterScreen
import com.mk_sofia.feature_categories_screen.presentation.categories_screen.CategoriesScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SofiaMainTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    EnterRegisterScreen()
                }
            }
        }

        FirebaseApp.initializeApp(this)
    }
}