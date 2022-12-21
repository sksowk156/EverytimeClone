package com.umc.second_week.ui.popup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.umc.second_week.R
import com.umc.second_week.databinding.FragmentKeeppopupBinding
import com.umc.second_week.ui.BaseDialogFragment
import com.umc.second_week.ui.main.external.allboard.board.FourthFragment

//class KeeppopupFragment : DialogFragment() {
//
//    private lateinit var binding : FragmentKeeppopupBinding
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        binding = FragmentKeeppopupBinding.inflate(inflater,container,false)
//        // Inflate the layout for this fragment
//        return binding.root
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        binding.yesbtn2.setOnClickListener {
//            dismiss()
//        }
//
//        binding.nobtn2.setOnClickListener {
//            parentFragmentManager
//                .beginTransaction()
//                .replace(R.id.secondFragmentFrame, FourthFragment())
//                .commitAllowingStateLoss()
//            dismiss()
//        }
//    }
//}

class KeeppopupFragment :
    BaseDialogFragment<FragmentKeeppopupBinding>(R.layout.fragment_keeppopup) {
    override fun init() {
        binding.yesbtn2.setOnClickListener {
            dismiss()
        }

        binding.nobtn2.setOnClickListener {
//            parentFragmentManager
//                .beginTransaction()
//                .replace(R.id.secondFragmentFrame, FourthFragment())
//                .commitAllowingStateLoss()
            requireActivity().supportFragmentManager.findFragmentByTag("tthird")!!.parentFragmentManager
                .popBackStackImmediate(null, 0)
            dismiss()
        }
    }
}