package com.evj.redmine.data

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface IssuesService {
    @GET("issues.json")
    suspend fun loadIssues(
//        @Query("client_id") clientId: String,
//        @Query("page") page: Int,
//        @Query("per_page") pageSize:  Int
    ): String

//    issues.json?utf8=%E2%9C%93&set_filter=1&f%5B%5D=status_id&op%5Bstatus_id%5D=o&f%5B%5D=assigned_to_id&op%5Bassigned_to_id%5D=%3D&v%5Bassigned_to_id%5D%5B%5D=me&f%5B%5D=&c%5B%5D=project&c%5B%5D=tracker&c%5B%5D=status&c%5B%5D=priority&c%5B%5D=subject&c%5B%5D=assigned_to&c%5B%5D=estimated_hours&c%5B%5D=spent_hours&c%5B%5D=done_ratio&group_by=&t%5B%5D=spent_hours

    companion object {
        const val BASE_API_URL = "https://redmine.computools.org/"
        fun create(): AuthService {
            val client = OkHttpClient.Builder()
                .build()
            return Retrofit.Builder()
                .baseUrl(BASE_API_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(AuthService::class.java)
        }
    }
}