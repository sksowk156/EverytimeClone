package com.umc.second_week.ui.main.external

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.umc.second_week.R
import com.umc.second_week.databinding.FragmentThirdBinding
import com.umc.second_week.databinding.FragmentTthirdBinding
import com.umc.second_week.ui.BaseFragment
import com.umc.second_week.ui.main.external.allboard.ThirdFragment
import com.umc.second_week.ui.main.external.course.CourseFragment
import com.umc.second_week.ui.main.external.group.GroupFragment
import com.umc.second_week.ui.main.external.promotion.PromotionFragment
import com.umc.second_week.ui.main.external.adapt.ExternalViewpagerAdapter


class TthirdFragment : BaseFragment<FragmentTthirdBinding>(R.layout.fragment_tthird) {
    override fun init() {
        initViewPager()
    }
//    private var _binding: FragmentTthirdBinding? = null
//    private val binding: FragmentTthirdBinding get() = _binding!!
//
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View {
//        _binding = FragmentTthirdBinding.inflate(inflater, container, false)
//
//        return binding.root
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
////        // 자식 fragment들을 가지고 있는 fragment
////        if (savedInstanceState == null) {
////            childFragmentManager
////                .beginTransaction()
////                .replace(binding.secondFragmentFrame.id, ThirdFragment())
////                .commitAllowingStateLoss()
////        }
//        initViewPager()
//    }


    private fun initViewPager() {
        //ViewPager2 Adapter 셋팅
        var ExternalViewpagerAdapter = ExternalViewpagerAdapter(requireActivity())
        ExternalViewpagerAdapter.addFragment(ThirdFragment())
        ExternalViewpagerAdapter.addFragment(CourseFragment())
        ExternalViewpagerAdapter.addFragment(GroupFragment())
        ExternalViewpagerAdapter.addFragment(PromotionFragment())


        //Adapter 연결
        binding.viewpager2.apply {
            adapter = ExternalViewpagerAdapter

            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                }
            })
        }

        //ViewPager, TabLayout 연결
        TabLayoutMediator(binding.tablayout2, binding.viewpager2) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "게시판"
                }
                1 -> {
                    tab.text = "진로"
                }
                2-> {
                    tab.text = "홍보"
                }
                3-> {
                    tab.text = "단체"
                }
            }
        }.attach()
    }

//    override fun onDestroyView() {
//        super.onDestroyView()
//        _binding = null
//    }
}