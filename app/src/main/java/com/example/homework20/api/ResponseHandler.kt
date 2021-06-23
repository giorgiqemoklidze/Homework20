package com.example.homework20.api

sealed class ResponseHandler<out T> {
    data class Loading(val loading: Boolean) : ResponseHandler<Nothing>()
    data class Success<out T>(val data: T?) : ResponseHandler<T>()
    data class Error(val errorMessage: String?) : ResponseHandler<Nothing>()
}
