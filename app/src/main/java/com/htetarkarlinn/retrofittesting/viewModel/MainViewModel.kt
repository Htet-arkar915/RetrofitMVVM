package com.htetarkarlinn.retrofittesting.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.htetarkarlinn.retrofittesting.model.MovieModel
import com.htetarkarlinn.retrofittesting.services.RetrofitService
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class MainViewModel constructor(private val repository: MainRepository) : ViewModel() {
    val movieList = MutableLiveData<List<MovieModel>>()
    val errorMessage =MutableLiveData<String>()

    fun getAllMovies(){
        val response =repository.getAllMovies()
        response.enqueue(object :  retrofit2.Callback<List<MovieModel>> {
            override fun onResponse(
                call: Call<List<MovieModel>>,
                response: Response<List<MovieModel>>
            ) {
                movieList.postValue(response.body())
            }

            override fun onFailure(call: Call<List<MovieModel>>, t: Throwable) {
                errorMessage.postValue(t.message)
            }

        })

    }

}