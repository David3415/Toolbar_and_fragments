package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.myapplication.databinding.Fragment1Binding

class BlankFragment : Fragment() {
    lateinit var binding: Fragment1Binding
    private val dataModel: DataModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = Fragment1Binding.inflate(inflater)
        return binding.root
        // return inflater.inflate(R.layout.fragment_1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.bSendToActivity.setOnClickListener { dataModel.message_for_activity.value = "Hello Activity fragment 1" }
        binding.bSendToFrag2.setOnClickListener { dataModel.message_for_activity.value = "Hello fragment 1" }
    }

    companion object {
        @JvmStatic
        fun newInstance() = BlankFragment()

    }
}