package com.mk_sofia.sofiamain.presentation.categories_screen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mk_sofia.core.extensions.launchOnIo
import com.mk_sofia.sofiamain.domain.models.CategoryModel
import com.mk_sofia.sofiamain.domain.models.ProductModel
import com.mk_sofia.sofiamain.domain.usecases.GetAllCategoriesUseCase
import com.mk_sofia.sofiamain.domain.usecases.GetProductsByCategoryIdUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CategoriesViewModel(
    private val getAllCategoriesUseCase: GetAllCategoriesUseCase,
    private val getProductsByCategoryIdUseCase: GetProductsByCategoryIdUseCase,
) : ViewModel(), CategoriesContract {

    private val _uiState = MutableStateFlow<CategoriesContract.UiState>(CategoriesContract.UiState.Loading)
    private val _effect = MutableStateFlow<CategoriesContract.Effect?>(null)
    override val uiState = _uiState.asStateFlow()
    override val effect = _effect.asStateFlow()

    private val productsByCategoryId = mutableListOf<ProductModel>()

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
           // val categories = listOf(CategoryModel(des))
            Log.d("AAAAAAAA_CATEGORIES", categories.toString())
            categories.forEach {
                getProductsByCategoryId(it.id)
                Log.d("AAAAAAAA_CATEGORIES", "мы тут")
            }
            Log.d("AAAAAAAA_CATEGORIES", "а теперь там")
            _uiState.update {
                CategoriesContract.UiState.Success(
                    categoriesList = categories,
                    productsByCategoryIdList = productsByCategoryId
                )
            }
        }
    }

    private fun getAllCategories() {
        viewModelScope.launchOnIo {
            val categories = getAllCategoriesUseCase.execute()
//            _uiState.update { currentState ->
//                currentState.copy(
//                    categoriesList = categories
//                )
//            }
            Log.d("AAAAAAAA_CATEGORIES", categories.toString())

            categories.forEach {
                getProductsByCategoryId(it.id)
            }
        }
    }


    private fun getProductsByCategoryId(categoryId: Int) {
        viewModelScope.launchOnIo {
            val productsList = getProductsByCategoryIdUseCase.execute(categoryId = categoryId)
            productsByCategoryId.addAll(productsList)
        }
    }

//    private fun updateProductsByCategoryId() {
//        viewModelScope.launchOnIo {
//            _uiState.update { currentState ->
//                currentState.copy(
//                    productsByCategoryIdList = productsByCategoryId
//                )
//            }
//        }
//    }
}