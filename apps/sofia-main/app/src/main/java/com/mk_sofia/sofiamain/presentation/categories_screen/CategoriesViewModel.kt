package com.mk_sofia.sofiamain.presentation.categories_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mk_sofia.core.extensions.launchOnIo
import com.mk_sofia.sofiamain.domain.usecases.GetAllCategoriesUseCase
import com.mk_sofia.sofiamain.domain.usecases.GetProductsByCategoryIdUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class CategoriesViewModel(
    private val getAllCategoriesUseCase: GetAllCategoriesUseCase,
    private val getProductsByCategoryIdUseCase: GetProductsByCategoryIdUseCase,
) : ViewModel(), CategoriesContract {
    private val _uiState = MutableStateFlow(CategoriesContract.State.initial())
    private val _effect = MutableStateFlow<CategoriesContract.Effect?>(null)

    override val uiState = _uiState.asStateFlow()
    override val effect = _effect.asStateFlow()

    override fun event(event: CategoriesContract.Event) {
        when(event) {
            CategoriesContract.Event.GetAllCategories -> getAllCategories()
        }
    }

    override fun consume() {
        _effect.update { null }
    }

    init {
        getAllCategories()
    }

    private fun getAllCategories() {
        viewModelScope.launchOnIo {
            val categories = getAllCategoriesUseCase.execute()
            _uiState.update { currentState ->
                currentState.copy(
                    categoriesList = categories
                )

            }
        }
    }
}