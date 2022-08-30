package com.htetarkarlinn.retrofittesting.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.htetarkarlinn.retrofittesting.R
import com.htetarkarlinn.retrofittesting.adapter.MainAdapter
import com.htetarkarlinn.retrofittesting.databinding.ActivityMainBinding
import com.htetarkarlinn.retrofittesting.model.MovieModel
import com.htetarkarlinn.retrofittesting.services.RetrofitService
import com.htetarkarlinn.retrofittesting.viewModel.MainRepository
import com.htetarkarlinn.retrofittesting.viewModel.MainViewModel
import com.htetarkarlinn.retrofittesting.viewModel.ViewModelFactory

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding

    lateinit var viewModel: MainViewModel
    private val retrofitService = RetrofitService.getInstance()
    var movieList : MutableList<MovieModel> = mutableListOf()
    var errorMessage =""
    var adapter : MainAdapter? =null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel= ViewModelProvider(this,ViewModelFactory(MainRepository(retrofitService)))[MainViewModel::class.java]

        viewModel.movieList.observe(this, Observer {
            movieList=it as MutableList<MovieModel>
            binding.recyclerView.layoutManager=LinearLayoutManager(this)
            adapter= MainAdapter(this,movieList)
            Toast.makeText(this, movieList.size.toString(), Toast.LENGTH_SHORT).show()
            binding.recyclerView.adapter=adapter
        })
        viewModel.errorMessage.observe(this, Observer {
            errorMessage=it
        })
        viewModel.getAllMovies()



    }
}