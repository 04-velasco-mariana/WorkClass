package com.example.workclass.data.network

import com.example.workclass.data.model.AccountModel
import com.example.workclass.data.model.UserModel
import com.google.gson.JsonObject
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @POST("user")
    suspend fun login(@Body user: UserModel): Response<JsonObject>


    @GET("service")
    suspend fun getAccounts():Response<List<AccountModel>>

}
