package com.umc.second_week.ui.main.internal.message

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.umc.second_week.R
import com.umc.second_week.databinding.FragmentMessageBinding
import com.umc.second_week.ui.BaseFragment
import com.umc.second_week.ui.fourth.Adapter.MessageAdapter
import com.umc.second_week.ui.popup.Minipopup2Fragment

class MessageFragment : BaseFragment<FragmentMessageBinding>(R.layout.fragment_message), MessageAdapter.ItemClickListener {
    override fun init() {
        baseinit()
    }

//    private var _binding: FragmentMessageBinding? = null
//    private val binding: FragmentMessageBinding get() = _binding!!
//
    // ViewModel
    private lateinit var viewpagermessageviewmodel: ViewpagermessageViewModel
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        _binding = FragmentMessageBinding.inflate(inflater, container, false)
//        // ViewModel
//        viewpagermessageviewmodel =
//            ViewModelProvider(this.requireActivity(), ViewModelProvider.NewInstanceFactory()).get(
//                ViewpagermessageViewModel::class.java
//            )
//        binding.lifecycleOwner = this
//        binding.messages = viewpagermessageviewmodel
//        binding.recyclerview.adapter = MessageAdapter(this)
////        binding.recyclerview.setHasFixedSize(true)
//
//        binding.swipe.setOnRefreshListener {
//            parentFragmentManager
//                .beginTransaction()
//                .detach(this)
//                .attach(this)
//                .commitAllowingStateLoss()
//            binding.swipe.isRefreshing = false
//        }
//        return binding.root
//    }

    fun baseinit(){
        viewpagermessageviewmodel =
            ViewModelProvider(this.requireActivity(), ViewModelProvider.NewInstanceFactory()).get(
                ViewpagermessageViewModel::class.java
            )
        binding.messages = viewpagermessageviewmodel
        binding.recyclerview.adapter = MessageAdapter(this)
        binding.swipe.setOnRefreshListener {
            parentFragmentManager
                .beginTransaction()
                .detach(this)
                .attach(this)
                .commitAllowingStateLoss()
            binding.swipe.isRefreshing = false
        }
    }
//    override fun onDestroyView() {
//        super.onDestroyView()
//        _binding = null
//    }

    override fun onItemClick(view: View, position: Int) {
    }

    override fun onItemLongClick(view: View, position: Int) {
        // 삭제할 건지 묻는 다이얼로그
        // 삭제시 fragment 초기화 or recyclerview 초기화 or viewmodel 초기화(이건 자동인가?? -> 확인해보자)
        // ViewModel에서 삭제할 데이터 position을 미리 저장
        viewpagermessageviewmodel.findData(position)
        val showpopup = Minipopup2Fragment()
        showpopup.show(parentFragmentManager, "showpopup")
    }
}