package com.example.mvvmcvglobantapp.experience

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cv_globant_app.data.GeneralRepository
import com.example.cv_globant_app.data.model.ExperienceModel
import com.example.mvvmcvglobantapp.R
import com.example.mvvmcvglobantapp.experience.adapters.ExperienceAdapter
import kotlinx.android.synthetic.main.fragment_experience.*

class ExperienceFragment : Fragment() {
    private val viewmodel = ExperienceViewModel(GeneralRepository())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        initViewObservers()
        return inflater.inflate(R.layout.fragment_experience, container, false)
    }

    private fun initViewObservers() {
        viewmodel.experience.observe(this, object : Observer<ExperienceModel> {
            override fun onChanged(experience: ExperienceModel) {
                rv_items_experience.apply {
                    setHasFixedSize(true)
                    layoutManager = LinearLayoutManager(context)
                    adapter = ExperienceAdapter(experience.experienceItems)
                }
            }
        })
        viewmodel.start()
    }
}
