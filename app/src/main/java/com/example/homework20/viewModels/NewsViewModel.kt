package com.example.homework20.viewModels

import android.util.Log.d
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.homework20.api.ResponseHandler
import com.example.homework20.api.RetrofitService
import com.example.homework20.models.News
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class NewsViewModel: ViewModel() {

    private var _newsLiveData = MutableLiveData<ResponseHandler<List<News>>>()
    val newsDataLiveData: LiveData<ResponseHandler<List<News>>> = _newsLiveData




    fun init() {
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                getNewsResponse()
            }
        }

    }




    private suspend fun getNewsResponse() {
        val result = RetrofitService.getAllNews().getNews()

        if (result.isSuccessful) {
            _newsLiveData.postValue(ResponseHandler.Success(result.body()))
            d("message", "${result.body()}")
        } else {
            result.code()
            ResponseHandler.Loading(false)
            ResponseHandler.Error("${result.errorBody()}")
        }
    }

}