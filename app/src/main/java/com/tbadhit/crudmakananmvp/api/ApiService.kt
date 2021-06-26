package com.tbadhit.crudmakananmvp.api

import com.tbadhit.crudmakananmvp.model.action.ResponseAction
import com.tbadhit.crudmakananmvp.model.auth.ResponseAuth
import com.tbadhit.crudmakananmvp.model.detail.ResponseDetailMakanan
import com.tbadhit.crudmakananmvp.model.getMakanan.ResponseGetMakanan
import retrofit2.Call
import retrofit2.http.*

interface ApiService {

    // 1.
    @GET("api/getMakanan")
    fun getAllMakanan(): Call<ResponseGetMakanan>

    // 2.
    @FormUrlEncoded
    @POST("api/insertMakanan")
    fun insertMakanan(
        @Field("name") name: String,
        @Field("price") price: String,
        @Field("gambar") gambar: String
    ): Call<ResponseAction>

    // 3
    @GET("api/getDetailMakanan/{id}")
    fun getDetailMakanan(@Path("id") id: String): Call<ResponseDetailMakanan>

    // 3.
    @FormUrlEncoded
    @POST("api/updateMakanan")
    fun updateMakanan(
        @Field("id") id: String,
        @Field("name") name: String,
        @Field("price") price: String,
        @Field("gambar") gambar: String
    ): Call<ResponseAction>

    // 3.
    @FormUrlEncoded
    @POST("api/deleteMakanan")
    fun deleteMakanan(@Field("id") id: String): Call<ResponseAction>

    // 4.
    @FormUrlEncoded
    @POST("api/login")
    fun login(
        @Field("email") email: String,
        @Field("password") password: String
    ): Call<ResponseAuth>

    // 5.
    @FormUrlEncoded
    @POST("api/register")
    fun register(
        @Field("name") name: String,
        @Field("email") email: String,
        @Field("password") password: String,
        @Field("hp") hp: String
    ): Call<ResponseAuth>

}