package com.andriuswill.mesa_news.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.andriuswill.mesa_news.R
import com.andriuswill.mesa_news.databinding.ActivityHomeBinding
import com.andriuswill.mesa_news.databinding.ActivityLoginBinding
import com.andriuswill.mesa_news.databinding.ActivitySignupBinding
import com.andriuswill.mesa_news.viewmodels.HomeViewModel
import com.andriuswill.mesa_news.viewmodels.LoginViewModel
import com.andriuswill.mesa_news.viewmodels.SignUpViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class SignUpActivity : AppCompatActivity() {

    private val viewmodel: SignUpViewModel by viewModel()

    private lateinit var binding: ActivitySignupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView<ActivitySignupBinding>(
            this,
            R.layout.activity_signup
        ).apply {
            viewmodel = this@SignUpActivity.viewmodel
            lifecycleOwner = this@SignUpActivity
        }

        with(viewmodel){
            action.subscribe(::observeActions)
        }

    }

    private fun goToHome() {
        finishAffinity()
        startActivity(
            Intent(this, HomeActivity::class.java)
        )
    }

    private fun observeActions(action: SignUpViewModel.SignUpActions){
        when(action){
            SignUpViewModel.SignUpActions.Home -> goToHome()
        }
    }


}