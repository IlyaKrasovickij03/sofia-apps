package com.mk_sofia.sofiamain.presentation.categories_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.mk_sofia.sofiamain.domain.usecases.GetAllCategoriesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CategoriesViewModel(
    private val getAllCategoriesUseCase: GetAllCategoriesUseCase,
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
        viewModelScope.launch {
            val categories = getAllCategoriesUseCase.execute()
            _uiState.update { currentState ->
                currentState.copy(
                    categories = categories
                )

            }
        }
    }

    internal class Factory(
        private val getAllCategoriesUseCase: GetAllCategoriesUseCase,
    ) : ViewModelProvider.NewInstanceFactory() {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T =
            CategoriesViewModel(
                getAllCategoriesUseCase = getAllCategoriesUseCase
            ) as T
    }
}