package com.andriuswill.mesa_news.viewmodels


import android.view.View
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.andriuswill.mesa_news.api.Repository
import com.andriuswill.mesa_news.data.News
import io.reactivex.rxjava3.kotlin.subscribeBy

class HomeViewModel(
    private val repository: Repository
) : ViewModel() {

    val loaderVisibility = MutableLiveData(View.GONE)

    val highlightsList = MutableLiveData<ArrayList<News>>()
    val newsList = MutableLiveData<ArrayList<News>>()

    fun getHighLights() {
        repository.getHighlights()
            .doOnSubscribe {
                showLoader()
            }.doFinally {
                hideLoader()
            }.subscribeBy(
                onSuccess = {
                    highlightsList.postValue(it.data)
                },
                onError = {

                }
            )
    }

    fun getNews() {
        repository.getNews()
            .doOnSubscribe {
                showLoader()
            }.doFinally {
                hideLoader()
            }.subscribeBy(
                onSuccess = {
                    newsList.postValue(it.data)
                },
                onError = {

                }
            )
    }

    private fun hideLoader(){
        loaderVisibility.postValue(View.GONE)
    }

    private fun showLoader(){
        loaderVisibility.postValue(View.VISIBLE)
    }

}