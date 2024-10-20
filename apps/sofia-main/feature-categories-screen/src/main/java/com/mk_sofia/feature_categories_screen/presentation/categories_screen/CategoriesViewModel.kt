package com.mk_sofia.feature_categories_screen.presentation.categories_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mk_sofia.feature_categories_screen.domain.models.CategoryModel
import com.mk_sofia.feature_categories_screen.domain.models.ProductModel
import com.mk_sofia.feature_categories_screen.domain.usecases.GetAllCategoriesUseCase
import com.mk_sofia.feature_categories_screen.domain.usecases.GetProductsByCategoryIdUseCase
import com.mk_sofia.feature_categories_screen.domain.usecases.GetProductsByCategoryIdWithLimitUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.util.concurrent.CopyOnWriteArrayList

class CategoriesViewModel(
    private val getAllCategoriesUseCase: GetAllCategoriesUseCase,
    private val getProductsByCategoryIdUseCase: GetProductsByCategoryIdUseCase,
    private val getProductsByCategoryIdWithLimitUseCase: GetProductsByCategoryIdWithLimitUseCase,
) : ViewModel(), CategoriesContract {

    private val _uiState = MutableStateFlow<CategoriesContract.UiState>(CategoriesContract.UiState.Loading)
    private val _effect = MutableStateFlow<CategoriesContract.Effect?>(null)
    override val uiState = _uiState.asStateFlow()
    override val effect = _effect.asStateFlow()

    companion object {
        private const val CATEGORY_PRODUCTS_LIMIT = 4
    }

    private val productsByCategoryId = mutableListOf<ProductModel>()

    override fun event(event: CategoriesContract.Event) {

    }

    override fun consume() {
        _effect.update { null }
    }

    init {
        initCategoriesScreen()
    }

    private fun initCategoriesScreen() {
        viewModelScope.launch {
            val categories = getAllCategoriesUseCase.execute()
            getProductsByCategoryIdWithLimit(categories)

            _uiState.update {
                CategoriesContract.UiState.Success(
                    categoriesList = categories,
                    productsByCategoryIdList = productsByCategoryId
                )
            }
        }
    }

    private suspend fun getProductsByCategoryIdWithLimit(categories: List<CategoryModel>) {
        categories.forEach { category ->
            getProductsByCategoryIdWithLimitUseCase
                .execute(categoryId = category.id, limit = CATEGORY_PRODUCTS_LIMIT.toLong())
                .map {
                productsByCategoryId.add(it)
            }
        }
    }
}