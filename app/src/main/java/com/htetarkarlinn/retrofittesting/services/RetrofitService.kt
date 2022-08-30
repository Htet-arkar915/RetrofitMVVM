package com.htetarkarlinn.retrofittesting.services

import com.htetarkarlinn.retrofittesting.model.MovieModel
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface RetrofitService {

    @GET("movielist.json")
    fun getAllMovies() : Call<List<MovieModel>>

    companion object{
        var retrofitService : RetrofitService?= null
        fun getInstance() : RetrofitService {
            if (retrofitService== null){
                val retrofit =Retrofit.Builder()
                    .baseUrl("https://howtodoandroid.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitService=retrofit.create(RetrofitService::class.java)
            }
            return retrofitService!!
        }
    }
}