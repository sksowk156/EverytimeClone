package com.umc.second_week.ui.popup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import com.umc.second_week.data.WriteData
import com.umc.second_week.databinding.FragmentMinipopupBinding

class MinipopupFragment() : DialogFragment() {

    private lateinit var binding : FragmentMinipopupBinding
    private lateinit var writeData : WriteData


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMinipopupBinding.inflate(inflater,container,false)
        writeData = ViewModelProvider(this.requireActivity(), ViewModelProvider.NewInstanceFactory()).get(
            WriteData::class.java)

        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.deletebt.setOnClickListener {
            writeData.deleteData()
            dismiss()
        }
    }
}