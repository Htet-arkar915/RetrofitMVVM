package com.htetarkarlinn.retrofittesting.viewModel

import com.htetarkarlinn.retrofittesting.services.RetrofitService

class MainRepository constructor(private val retrofitService: RetrofitService) {
    fun getAllMovies() =retrofitService.getAllMovies()
}