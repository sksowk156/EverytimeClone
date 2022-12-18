package com.umc.second_week.ui.main.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.umc.second_week.data.User
import com.umc.second_week.databinding.FragmentFirstBinding
import com.umc.second_week.ui.main.home.adapt.MyAdapter

class FirstFragment : Fragment() {

    private lateinit var binding : FragmentFirstBinding
    private lateinit var userArrayList: ArrayList<User>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstBinding.inflate(inflater, container, false)

        val titles = arrayOf("자유게시판","비밀게시판","졸업생게시판","시사·이슈","장터게시판",
            "정보게시판","취업·진로","홍보게시판","동아리·학회"
        )

        val contents = arrayOf("너무많아너무많아너무많아너무많아너무많아너무많아너무많아너무많아","너무많아너무많아너무많아너무많아","너무많아너무많아너무많아너무많아","너무많아너무많아너무많아너무많아",
            "너무많아너무많아너무많아너무많아","너무많아너무많아너무많아너무많아","너무많아너무많아너무많아너무많아","너무많아너무많아너무많아너무많아",
            "너무많아너무많아너무많아너무많아"
        )

        userArrayList = ArrayList()
        for(i in 0..titles.size-1){
            val user = User(titles[i],contents[i])
            userArrayList.add(user)
        }

        binding.customListView.isClickable = false
        binding.customListView.adapter = MyAdapter(requireActivity(), userArrayList)

        return binding.root
    }
}