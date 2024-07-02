package com.mk_sofia.sofiamain.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.mk_sofia.core.ui.theme.SofiaMainTheme
import com.mk_sofia.sofiamain.data.network.api.SofiaNetworkApi
import com.mk_sofia.sofiamain.data.repository.SofiaRepositoryImpl
import com.mk_sofia.sofiamain.domain.usecases.GetAllCategoriesUseCase
import com.mk_sofia.sofiamain.presentation.categories_screen.CategoriesScreen
import com.mk_sofia.sofiamain.presentation.categories_screen.CategoriesViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            com.mk_sofia.core.ui.theme.SofiaMainTheme {
                val viewModel: CategoriesViewModel by viewModel()
                val uiState by viewModel.uiState.collectAsState()
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CategoriesScreen(uiState = uiState)
                }
            }
        }
    }
}