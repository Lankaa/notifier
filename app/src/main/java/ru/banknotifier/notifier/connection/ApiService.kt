package ru.banknotifier.notifier.connection

import org.json.JSONObject
import retrofit2.Call
import retrofit2.http.*
import ru.banknotifier.notifier.Bank
import ru.banknotifier.notifier.Notification
import ru.banknotifier.notifier.UserSettings
import java.util.*

interface ApiGetBanks {
    @GET("banks")
    fun fetchAllBanks(
        @Header("Authorization") token: String
//        @QueryMap params:Map<String, String>
    ): Call<List<Bank>>
}

interface ApiGetNotifications {
    @GET("notifications")
    fun fetchAllNotifications(
        @Header("Authorization") token: String
    ): Call<List<Notification>>
}

interface ApiGetUserSettings {
    @GET("me_settings")
    fun fetchUserSettings(
        @Header("Authorization") token: String
    ): Call<UserSettings>
}

interface ApiPostUserSettings {
    @POST("me_settings")
    fun fetchUserSettings(
        @Header("Authorization") token: String
//        @QueryMap params:Map<String, String>
    ): Call<UserSettings>
}

interface ApiPutBank {
    @PUT("banks/{id}")
    fun changeBank(
        @Path("id") id: Int,
        @Header("Authorization") token: String,
        @Body updateBank: Bank
    ): Call<Bank>
}


interface ApiGetNotification {
    @GET("/notifications")
    fun fetchAllBanks(
        @Header("token") token: String
//        @QueryMap params:Map<String, String>
    ): Call<List<Bank>>
}