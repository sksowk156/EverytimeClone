package com.umc.second_week.ui.popup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import com.umc.second_week.ui.main.internal.notice.ViewpagernoticeViewModel
import com.umc.second_week.databinding.FragmentMinipopup3Binding

class Minipopup3Fragment : DialogFragment() {

    private lateinit var binding : FragmentMinipopup3Binding
    private lateinit var noticeView : ViewpagernoticeViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMinipopup3Binding.inflate(inflater,container,false)
        noticeView = ViewModelProvider(this.requireActivity(), ViewModelProvider.NewInstanceFactory()).get(
            ViewpagernoticeViewModel::class.java)

        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.deletebt.setOnClickListener {
            noticeView.deleteData()
            dismiss()
        }
    }
}