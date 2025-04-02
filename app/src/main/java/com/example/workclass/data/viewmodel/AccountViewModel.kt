package com.example.workclass.data.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.workclass.data.model.AccountModel
import com.example.workclass.data.network.RetrofitClient
import com.google.gson.JsonObject
import kotlinx.coroutines.launch
import retrofit2.Response

class AccountViewModel : ViewModel() {
    val api = RetrofitClient.api

    fun getAccounts(onResult: (Response<List<AccountModel>>) -> Unit){
        viewModelScope.launch {
            try{
                val response = api.getAccounts()
                Log.d("debug", response.toString())
                onResult(response)
            }catch(exception: Exception){
                Log.d("debug", "API ERROR: $exception")

            }
        }

    }
}