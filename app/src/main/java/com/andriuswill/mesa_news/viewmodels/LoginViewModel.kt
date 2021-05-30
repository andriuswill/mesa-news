package com.andriuswill.mesa_news.viewmodels


import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.subjects.PublishSubject

class LoginViewModel : ViewModel() {

    val action = PublishSubject.create<LoginActions>()

    fun goToHome() = action.onNext(LoginActions.Home)
    fun goToSignUp() = action.onNext(LoginActions.SignUp)

    fun login(){
        goToHome()
    }

    sealed class LoginActions {
        object Home : LoginActions()
        object SignUp : LoginActions()
    }
}