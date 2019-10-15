package com.example.mvvmcvglobantapp.summary

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.cv_globant_app.data.GeneralRepository
import com.example.cv_globant_app.data.model.SummaryModel
import com.example.mvvmcvglobantapp.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_summary.*

class SummaryFragment : Fragment() {

    private val viewmodel = SummaryViewModel(GeneralRepository())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        initViewObservers()
        return inflater.inflate(R.layout.fragment_summary, container, false)
    }

    private fun initViewObservers() {
        val observer =  Observer<SummaryModel> { summary ->
            tv_name_summary.text = summary.name
            tv_experience_summary.text = summary.experience.toString()
            tv_expertise_summary.text = summary.expertise
            Picasso.get().load(summary.picURL).fit().centerCrop().into(iv_summary)
        }
        viewmodel.summary.observe(this,observer)

        viewmodel.start()
    }
}
