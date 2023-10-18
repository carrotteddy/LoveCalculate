package com.example.lovecalculate

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface LoveApi {

    @GET("getPercentage")
    fun getPercentage(
        @Query("fname") firsName: String,
        @Query("sname") secondName: String,
        @Header("X-RapidAPI-Key") key: String = "b6c24ad4f5msh95166ba8a22c4fcp1fca91jsnfdc86304564b",
        @Header("X-RapidAPI-Host") host: String = "love-calculator.p.rapidapi.com"

    ): Call<LoveModel>

}