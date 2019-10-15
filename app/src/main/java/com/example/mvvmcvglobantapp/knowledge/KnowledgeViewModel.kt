package com.example.mvvmcvglobantapp.knowledge

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cv_globant_app.data.GeneralRepository
import com.example.cv_globant_app.data.model.KnowledgeModel
import com.example.cv_globant_app.data.sources.GeneralDataSource

class KnowledgeViewModel(private val repository: GeneralRepository) : ViewModel() {

    private val _knowledge = MutableLiveData<KnowledgeModel>()
    val knowledge: LiveData<KnowledgeModel> = _knowledge

    fun start() {
        repository.getKnowledge(object : GeneralDataSource.GeneralLoadCallback {
            override fun <T> onSuccess(info: T) {
                _knowledge.value = info as KnowledgeModel
            }

            override fun onFailure(t: Throwable) {
                // ¯\_(ツ)_/¯
                Log.e("lol", t.message)
            }
        })
    }
}