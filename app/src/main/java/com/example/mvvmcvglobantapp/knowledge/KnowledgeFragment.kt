package com.example.mvvmcvglobantapp.knowledge

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cv_globant_app.data.GeneralRepository
import com.example.cv_globant_app.data.model.KnowledgeModel
import com.example.mvvmcvglobantapp.R
import com.example.mvvmcvglobantapp.knowledge.adapters.KnowledgeAdapter
import kotlinx.android.synthetic.main.fragment_knowledge.*

class KnowledgeFragment : Fragment() {

    private val viewmodel = KnowledgeViewModel(GeneralRepository())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        initViewObservers()
        return inflater.inflate(R.layout.fragment_knowledge, container, false)
    }

    private fun initViewObservers() {
        viewmodel.knowledge.observe(this, object : Observer<KnowledgeModel> {
            override fun onChanged(knowledge: KnowledgeModel) {
                rv_items_knowledge.apply {
                    setHasFixedSize(true)
                    layoutManager = LinearLayoutManager(context)
                    adapter = KnowledgeAdapter(knowledge)
                }
            }
        })
        viewmodel.start()
    }
}
