package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import com.example.myapplication.databinding.Fragment2Binding


class Fragment2 : Fragment() {
    private val dataModel: DataModel by activityViewModels()
    lateinit var binding: Fragment2Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = Fragment2Binding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataModel.message_for_fragment2.observe(activity as LifecycleOwner,
            { binding.tvMessage.text = it })
        binding.bSendToActivity.setOnClickListener {
            dataModel.message_for_activity.value = "Hello Activity from fragment 2"
        }
        binding.bSendToFrag1.setOnClickListener {
            dataModel.message_for_fragment1.value = "Hello from fragment 2"
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = Fragment2()
    }
}