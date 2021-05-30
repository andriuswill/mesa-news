package com.andriuswill.mesa_news.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.andriuswill.mesa_news.R
import com.andriuswill.mesa_news.databinding.ActivityLoginBinding
import com.andriuswill.mesa_news.viewmodels.HomeViewModel
import com.andriuswill.mesa_news.viewmodels.LoginViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginActivity : AppCompatActivity() {

    private val viewmodel: LoginViewModel by viewModel()

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater).apply {
            viewmodel = this@LoginActivity.viewmodel
        }
        setContentView(binding.root)

        with(viewmodel){
            action.subscribe(::observeActions)
        }
    }

    private fun goToHome() {
        startActivity(
            Intent(this, HomeActivity::class.java)
        )
    }

    private fun goToSignUp() {
        startActivity(
            Intent(this, SignUpActivity::class.java)
        )
    }

    private fun observeActions(action: LoginViewModel.LoginActions){
        when(action){
            LoginViewModel.LoginActions.Home -> goToHome()
            LoginViewModel.LoginActions.SignUp -> goToSignUp()
        }
    }

}