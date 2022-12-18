package com.umc.second_week.ui.main.internal.notice

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.umc.second_week.R
import com.umc.second_week.databinding.FragmentNoticeBinding
import com.umc.second_week.ui.BaseFragment
import com.umc.second_week.ui.fourth.Adapter.NoticeAdapter
import com.umc.second_week.ui.popup.Minipopup3Fragment

class NoticeFragment : BaseFragment<FragmentNoticeBinding>(R.layout.fragment_notice), NoticeAdapter.ItemClickListener {
    override fun init() {
        baseinit()
    }

    // ViewModel
    private lateinit var viewpagernotice: ViewpagernoticeViewModel


    fun baseinit(){
        viewpagernotice =
            ViewModelProvider(this.requireActivity(), ViewModelProvider.NewInstanceFactory()).get(
                ViewpagernoticeViewModel::class.java
            )
        binding.notice = viewpagernotice
        binding.recyclerview.adapter = NoticeAdapter(this)
        binding.swipe.setOnRefreshListener {
            parentFragmentManager
                .beginTransaction()
                .detach(this)
                .attach(this)
                .commitAllowingStateLoss()
            binding.swipe.isRefreshing = false
        }
    }

    override fun onItemClick(view: View, position: Int) {
    }

    override fun onItemLongClick(view: View, position: Int) {
        // 삭제할 건지 묻는 다이얼로그
        // 삭제시 fragment 초기화 or recyclerview 초기화 or viewmodel 초기화(이건 자동인가?? -> 확인해보자)
        // ViewModel에서 삭제할 데이터 position을 미리 저장
        viewpagernotice.findData(position)
        val showpopup = Minipopup3Fragment()
        showpopup.show(parentFragmentManager, "showpopup")
    }
}