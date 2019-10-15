package com.example.mvvmcvglobantapp.summary

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cv_globant_app.data.GeneralRepository
import com.example.cv_globant_app.data.model.SummaryModel
import com.example.cv_globant_app.data.sources.GeneralDataSource

class SummaryViewModel(private val repository: GeneralRepository) : ViewModel() {

    private val _summary = MutableLiveData<SummaryModel>()
    val summary: LiveData<SummaryModel> = _summary

    fun start(){
        repository.getSummary(object: GeneralDataSource.GeneralLoadCallback{
            override fun <T> onSuccess(info: T) {
                _summary.value = info as SummaryModel
            }

            override fun onFailure(t: Throwable) {
                // ¯\_(ツ)_/¯
                Log.e("lol",t.message)
            }
        })
    }
}