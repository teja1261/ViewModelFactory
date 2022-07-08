package com.example.viewmodelfactory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.viewmodelfactory.databinding.ActivityMainBinding
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainActivityViewModel
    private lateinit var viewModelFactory: MainActivityViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModelFactory = MainActivityViewModelFactory(120)

        viewModel = ViewModelProvider(this, viewModelFactory).get(MainActivityViewModel::class.java)

        binding.tvAddCount.text = viewModel.getAddResult().toString()

        binding.btAddButton.setOnClickListener {
            viewModel.add(binding.etNumber.text.toString().toInt())
            binding.tvAddCount.text = viewModel.getAddResult().toString()
        }

    }
}