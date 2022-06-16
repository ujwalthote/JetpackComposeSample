package com.ujwal.grocerycomposesample.ui.screens.tabs.shop

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ujwal.grocerycomposesample.model.CategoryProducts
import com.ujwal.grocerycomposesample.model.DataState
import com.ujwal.grocerycomposesample.model.getError
import com.ujwal.grocerycomposesample.repository.ShopRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject
import kotlin.collections.ArrayList

@HiltViewModel
class ShopViewModel @Inject public constructor(val shopRepository: ShopRepository) : ViewModel() {
    private val _location: MutableLiveData<String> = MutableLiveData("Pune, MH")
    val location: LiveData<String> = _location

    fun onLocationChange(location: String) {
        _location.postValue(location)
    }


    private val _searchTerm: MutableLiveData<String> = MutableLiveData("Search Product")
    val searchTerm: LiveData<String> = _searchTerm

    fun onSearchTermChanged(searchTerm: String) {
        _searchTerm.postValue(searchTerm)
    }


    private val _categoryProducts: MutableLiveData<DataState<List<CategoryProducts>>> =
        MutableLiveData()
    val categoryProducts: LiveData<DataState<List<CategoryProducts>>> = _categoryProducts

    fun getDashboardContent(): LiveData<DataState<List<CategoryProducts>>> {
        _categoryProducts.postValue(DataState.LOADING)
        viewModelScope.launch {
            val responseCategories = shopRepository.getCategories()
            if (responseCategories.isSuccessful) {
                val categoryList: ArrayList<CategoryProducts> = arrayListOf()
                responseCategories.body()?.forEach {
                    val products = shopRepository.getProductsByCategory(it)
                    if (products.isSuccessful) {
                        categoryList.add(CategoryProducts(it, products.body()))
                    }
                }
                _categoryProducts.postValue(DataState.SUCCESS(categoryList))
            } else {
                _categoryProducts.postValue(
                    responseCategories.getError()
                )
            }
        }
        return categoryProducts
    }

}