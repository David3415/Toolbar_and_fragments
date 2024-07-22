package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import com.example.myapplication.databinding.Fragment1Binding

class Fragment1 : Fragment() {
    lateinit var binding: Fragment1Binding
    private val dataModel: DataModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = Fragment1Binding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataModel.message_for_fragment1.observe(activity as LifecycleOwner,
            { binding.tvMessage.text = it })
        binding.bSendToActivity.setOnClickListener {
            dataModel.message_for_activity.value = "Hello Activity from fragment 1"
        }
        binding.bSendToFrag2.setOnClickListener {
            dataModel.message_for_fragment2.value = "Hello from fragment 1"
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = Fragment1()
    }
}