package ru.banknotifier.notifier.connection

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.QueryMap
import ru.banknotifier.notifier.Bank

interface ApiGetBanks {
    @GET("/banks")
    fun fetchAllBanks(
        @Header("token") token: String
//        @QueryMap params:Map<String, String>
    ): Call<List<Bank>>
}

interface ApiGetNotification {
    @GET("/notifications")
    fun fetchAllBanks(
        @Header("token") token: String
//        @QueryMap params:Map<String, String>
    ): Call<List<Bank>>
}