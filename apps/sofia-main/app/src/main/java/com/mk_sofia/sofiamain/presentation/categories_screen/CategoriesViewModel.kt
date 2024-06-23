package com.mk_sofia.sofiamain.presentation.categories_screen

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class CategoriesViewModel : ViewModel(), CategoriesContract {
    private val _uiState = MutableStateFlow(CategoriesContract.State.initial())
    private val _effect = MutableStateFlow<CategoriesContract.Effect?>(null)

    override val uiState = _uiState.asStateFlow()
    override val effect = _effect.asStateFlow()

    override fun event(event: CategoriesContract.Event) {
        TODO("Not yet implemented")
    }

    override fun consume() {
        _effect.update { null }
    }
}