package com.test.restaurantes.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.test.restaurantes.domain.usecase.GetRecordsUseCase
import com.test.restaurantes.framework.database.RestaurantEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import javax.inject.Inject

@HiltViewModel
class RestaurantViewModel @Inject constructor(
    private val getRecordsUseCase: GetRecordsUseCase
): ViewModel() {

    fun getRestaurants() = liveData {
        getRecordsUseCase.execute().collectLatest{
            emit(it)
        }
    }

}