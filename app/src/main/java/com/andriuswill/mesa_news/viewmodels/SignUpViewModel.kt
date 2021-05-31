package com.andriuswill.mesa_news.viewmodels


import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.andriuswill.mesa_news.api.Repository
import com.andriuswill.mesa_news.data.SignUpRequest
import io.reactivex.rxjava3.kotlin.subscribeBy
import io.reactivex.rxjava3.subjects.PublishSubject

class SignUpViewModel(
    private val repository: Repository
) : ViewModel() {

    val loaderVisibility = MutableLiveData(View.GONE)
    val fieldsVisibility = MutableLiveData(View.VISIBLE)

    val nameValue = MutableLiveData("")
    val emailValue = MutableLiveData("")
    val passwordValue = MutableLiveData("")

    fun doSignUp() {
        repository.signup(
            SignUpRequest(
                name = nameValue.value.orEmpty(),
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

    val action: PublishSubject<SignUpActions> = PublishSubject.create<SignUpActions>()

    private fun goToHome() = action.onNext(SignUpActions.Home)

    sealed class SignUpActions {
        object Home : SignUpActions()
    }

}