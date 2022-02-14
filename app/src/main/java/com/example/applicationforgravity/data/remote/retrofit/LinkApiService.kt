package com.example.applicationforgravity.data.remote.retrofit

import com.example.applicationforgravity.data.remote.retrofit.response.LinkAndHomeResponse
import retrofit2.http.GET


interface LinkApiService {

    @GET("prod")
    suspend fun getLinkAndHome(): LinkAndHomeResponse

}