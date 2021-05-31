package com.andriuswill.mesa_news.viewmodels


import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.andriuswill.mesa_news.api.Repository
import com.andriuswill.mesa_news.data.LoginRequest
import com.andriuswill.mesa_news.data.SignUpRequest
import io.reactivex.rxjava3.kotlin.subscribeBy
import io.reactivex.rxjava3.subjects.PublishSubject

class LoginViewModel(
    private val repository: Repository
) : ViewModel() {


    val loaderVisibility = MutableLiveData(View.GONE)
    val fieldsVisibility = MutableLiveData(View.VISIBLE)

    val emailValue = MutableLiveData("")
    val passwordValue = MutableLiveData("")

    fun doLogin() {
        repository.login(
            LoginRequest(
                email = emailValue.value.orEmpty(),
                password = passwordValue.value.orEmpty()
            )
        ).doOnSubscribe {
            showLoader()
        }.doFinally {
            hideLoader()
        }.subscribeBy(
            onSuccess = {
                goToHome()
            },
            onError = {

            }
        )
    }

    private fun hideLoader() {
        loaderVisibility.postValue(View.GONE)
        fieldsVisibility.postValue(View.VISIBLE)
    }

    private fun showLoader() {
        loaderVisibility.postValue(View.VISIBLE)
        fieldsVisibility.postValue(View.GONE)
    }

    val action: PublishSubject<LoginActions> = PublishSubject.create<LoginActions>()

    fun goToHome() = action.onNext(LoginActions.Home)
    fun goToSignUp() = action.onNext(LoginActions.SignUp)


    sealed class LoginActions {
        object Home : LoginActions()
        object SignUp : LoginActions()
    }
}