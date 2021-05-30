package com.andriuswill.mesa_news.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.andriuswill.mesa_news.databinding.ActivityHomeBinding
import com.andriuswill.mesa_news.viewmodels.HomeViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeActivity : AppCompatActivity() {

    private val viewmodel: HomeViewModel by viewModel()

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater).apply {
            viewmodel = this@HomeActivity.viewmodel
        }
        setContentView(binding.root)

    }

}