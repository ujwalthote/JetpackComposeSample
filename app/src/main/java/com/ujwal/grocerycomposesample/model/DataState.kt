package com.ujwal.grocerycomposesample.model

import okhttp3.ResponseBody
import retrofit2.Response

sealed class DataState<out T>() {
    object LOADING : DataState<Nothing>()
    data class SUCCESS<out T>(val result: T) : DataState<T>()
    data class ERROR(val error: String, val errorCode: Int) : DataState<Nothing>()
}

public fun Response<*>.getError(): DataState.ERROR = DataState.ERROR(message(), code())