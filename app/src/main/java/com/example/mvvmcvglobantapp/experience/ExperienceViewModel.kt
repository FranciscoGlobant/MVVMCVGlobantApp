package com.example.mvvmcvglobantapp.experience

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cv_globant_app.data.GeneralRepository
import com.example.cv_globant_app.data.model.ExperienceModel
import com.example.cv_globant_app.data.sources.GeneralDataSource

class ExperienceViewModel(private val repository: GeneralRepository) : ViewModel() {

    private val _experience = MutableLiveData<ExperienceModel>()
    val experience: LiveData<ExperienceModel> = _experience

    fun start(){
        repository.getExperience(object: GeneralDataSource.GeneralLoadCallback{
            override fun <T> onSuccess(info: T) {
                _experience.value = info as ExperienceModel
            }

            override fun onFailure(t: Throwable) {
                // ¯\_(ツ)_/¯
                Log.e("lol",t.message)
            }
        })
    }
}