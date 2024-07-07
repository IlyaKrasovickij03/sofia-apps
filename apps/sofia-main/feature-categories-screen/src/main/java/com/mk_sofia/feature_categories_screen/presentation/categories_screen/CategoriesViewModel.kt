package com.mk_sofia.feature_categories_screen.presentation.categories_screen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mk_sofia.feature_categories_screen.domain.models.ProductModel
import com.mk_sofia.feature_categories_screen.domain.usecases.GetAllCategoriesUseCase
import com.mk_sofia.feature_categories_screen.domain.usecases.GetProductsByCategoryIdUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.util.concurrent.CopyOnWriteArrayList

class CategoriesViewModel(
    private val getAllCategoriesUseCase: GetAllCategoriesUseCase,
    private val getProductsByCategoryIdUseCase: GetProductsByCategoryIdUseCase,
) : ViewModel(), CategoriesContract {

    private val _uiState = MutableStateFlow<CategoriesContract.UiState>(CategoriesContract.UiState.Loading)
    private val _effect = MutableStateFlow<CategoriesContract.Effect?>(null)
    override val uiState = _uiState.asStateFlow()
    override val effect = _effect.asStateFlow()

    private val productsByCategoryId = CopyOnWriteArrayList<ProductModel>()

    override fun event(event: CategoriesContract.Event) {
//        when(event) {
//            //CategoriesContract.Event.UpdateProductsByCategories -> updateProductsByCategoryId()
//        }
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
            Log.d("AAAAAAAA", categories.toString())
            categories.forEach {
                getProductsByCategoryId(it.id)
                Log.d("AAAAAAAA", "мы тут")
            }
            Log.d("AAAAAAAA", "а теперь там")
            _uiState.update {
                CategoriesContract.UiState.Success(
                    categoriesList = categories,
                    productsByCategoryIdList = productsByCategoryId
                )
            }
        }
    }

    private suspend fun getProductsByCategoryId(categoryId: Int) {
        val productsList = getProductsByCategoryIdUseCase.execute(categoryId = categoryId)
        productsByCategoryId.addAll(productsList)
    }
}