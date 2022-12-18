package com.umc.second_week.ui.popup

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import com.umc.second_week.data.WriteData
import com.umc.second_week.databinding.FragmentPopupBinding


class PopupFragment : DialogFragment() {

    private lateinit var binding: FragmentPopupBinding
    private lateinit var writeData: WriteData


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("adddd", parentFragmentManager.backStackEntryCount.toString())

        binding = FragmentPopupBinding.inflate(inflater, container, false)
        writeData =
            ViewModelProvider(this.requireActivity(), ViewModelProvider.NewInstanceFactory()).get(
                WriteData::class.java
            )

        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.yesbtn.setOnClickListener {
            requireActivity().supportFragmentManager.findFragmentByTag("tthird")!!.childFragmentManager
                .popBackStackImmediate(null, 0)

            writeData.eraseEditTextData()
            dismiss()
        }

        binding.nobtn.setOnClickListener {
            dismiss()
        }
    }
}