package com.gdg.kakaobank.api

import retrofit2.http.GET
import retrofit2.http.Query

interface UserService {
    @GET("api/users")
    suspend fun getUsers(
        @Query("page") page: Int,
    ): ResposeUserDto
}