package ru.banknotifier.notifier.connection

import org.json.JSONObject
import retrofit2.Call
import retrofit2.http.*
import ru.banknotifier.notifier.Bank
import java.util.*

interface ApiGetBanks {
    @GET("banks")
    fun fetchAllBanks(
        @Header("Authorization") token: String
//        @QueryMap params:Map<String, String>
    ): Call<List<Bank>>
}

interface ApiPutBank {
    @PUT("banks/{id}")
    fun changeBank(
        @Path("id") id: Int,
        @Header("Authorization") token: String,
        @Body params: JSONObject
    ): Call<Bank>
}


interface ApiGetNotification {
    @GET("/notifications")
    fun fetchAllBanks(
        @Header("token") token: String
//        @QueryMap params:Map<String, String>
    ): Call<List<Bank>>
}