package com.ellies.simplefactum

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.ellies.simplefactum.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var factumViewModel: FactumListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        factumViewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        ).get(FactumListViewModel::class.java)

        binding.apply {
            lifecycleOwner = this@MainActivity
            viewModel = factumViewModel
        }

        setContentView(binding.root)
        factumViewModel.factumList
    }
}