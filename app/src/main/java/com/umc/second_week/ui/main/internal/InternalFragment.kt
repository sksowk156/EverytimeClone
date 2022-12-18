package com.umc.second_week.ui.main.internal

import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.umc.second_week.R
import com.umc.second_week.databinding.FragmentViewpagerBinding
import com.umc.second_week.ui.BaseFragment
import com.umc.second_week.ui.main.internal.adapt.InternalViewpagerAdapter
import com.umc.second_week.ui.main.internal.message.MessageFragment
import com.umc.second_week.ui.main.internal.notice.NoticeFragment

class InternalFragment : BaseFragment<FragmentViewpagerBinding>(R.layout.fragment_viewpager) {
    override fun init() {
        initViewPager()
    }
//    private var _binding: FragmentViewpagerBinding? = null
//    private val binding: FragmentViewpagerBinding get() = _binding!!
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        _binding = FragmentViewpagerBinding.inflate(inflater, container, false)
//        return binding.root
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        initViewPager()
//    }

    private fun initViewPager() {
        //ViewPager2 Adapter 셋팅
        var internalViewpagerAdapter = InternalViewpagerAdapter(requireActivity())
        internalViewpagerAdapter.addFragment(NoticeFragment())
        internalViewpagerAdapter.addFragment(MessageFragment())


        //Adapter 연결
        binding.viewpager.apply {
            adapter = internalViewpagerAdapter

            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                }
            })
        }

        //ViewPager, TabLayout 연결
        TabLayoutMediator(binding.tablayout, binding.viewpager) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "알림"
                }
                1 -> {
                    tab.text = "쪽지함"
                }
            }
        }.attach()
    }

//    override fun onDestroyView() {
//        super.onDestroyView()
//        _binding = null
//    }
}
