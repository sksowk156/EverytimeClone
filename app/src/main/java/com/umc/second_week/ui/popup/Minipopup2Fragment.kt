package com.umc.second_week.ui.popup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import com.umc.second_week.R
import com.umc.second_week.ui.main.internal.message.ViewpagermessageViewModel
import com.umc.second_week.databinding.FragmentMinipopup2Binding
import com.umc.second_week.ui.BaseDialogFragment

//class Minipopup2Fragment : DialogFragment() {
//
//    private lateinit var binding : FragmentMinipopup2Binding
//    private lateinit var noticeView : ViewpagermessageViewModel
//
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        binding = FragmentMinipopup2Binding.inflate(inflater,container,false)
//        noticeView = ViewModelProvider(this.requireActivity(), ViewModelProvider.NewInstanceFactory()).get(
//            ViewpagermessageViewModel::class.java)
//
//        // Inflate the layout for this fragment
//        return binding.root
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        binding.deletebt.setOnClickListener {
//            noticeView.deleteData()
//            dismiss()
//        }
//    }
//}

class Minipopup2Fragment :
    BaseDialogFragment<FragmentMinipopup2Binding>(R.layout.fragment_minipopup2) {
    private lateinit var noticeView: ViewpagermessageViewModel
    override fun init() {
        noticeView = ViewModelProvider(
            this.requireActivity(),
            ViewModelProvider.NewInstanceFactory()
        ).get(
            ViewpagermessageViewModel::class.java
        )

        binding.deletebt.setOnClickListener {
            noticeView.deleteData()
            dismiss()
        }
    }
}