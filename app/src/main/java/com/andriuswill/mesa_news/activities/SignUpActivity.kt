package com.andriuswill.mesa_news.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.andriuswill.mesa_news.R
import com.andriuswill.mesa_news.databinding.ActivityLoginBinding
import com.andriuswill.mesa_news.databinding.ActivitySignupBinding
import com.andriuswill.mesa_news.viewmodels.HomeViewModel
import com.andriuswill.mesa_news.viewmodels.SignUpViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class SignUpActivity : AppCompatActivity() {

    private val viewmodel: SignUpViewModel by viewModel()

    private lateinit var binding: ActivitySignupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignupBinding.inflate(layoutInflater).apply {
            viewmodel = this@SignUpActivity.viewmodel
        }
        setContentView(binding.root)

    }

}