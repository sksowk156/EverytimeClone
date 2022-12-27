package com.umc.second_week.ui.main.external.allboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.umc.second_week.R
import com.umc.second_week.databinding.FragmentThirdBinding
import com.umc.second_week.ui.main.external.allboard.board.FourthFragment
import com.umc.second_week.ui.main.external.allboard.marketplace.MarketplaceFragment
import com.umc.second_week.ui.main.external.allboard.mine.MytextFragment

class ThirdFragment : Fragment(), View.OnClickListener {

    private lateinit var binding : FragmentThirdBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentThirdBinding.inflate(inflater, container, false)
        binding.freeboard.setOnClickListener(this)
        binding.mytext.setOnClickListener(this)
        binding.marketplace.setOnClickListener(this)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /* onViewCreated 에서 클릭 리스너 이벤트 처리하기
        binding.freeboard.setOnClickListener{
            parentFragmentManager
                .beginTransaction()
                .replace(R.id.secondFragmentFrame, FourthFragment())
                .commitAllowingStateLoss()
        }*/
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.freeboard ->{
                parentFragmentManager // TthirdFragment를 가리킨다.
                    .beginTransaction()
                    .replace(R.id.secondFragmentFrame, FourthFragment())
                    .addToBackStack(null)
                    .commitAllowingStateLoss()
            }
            R.id.mytext ->{
                parentFragmentManager // TthirdFragment를 가리킨다.
                    .beginTransaction()
                    .replace(R.id.secondFragmentFrame, MytextFragment())
                    .addToBackStack(null)
                    .commitAllowingStateLoss()
            }
            R.id.marketplace ->{
                parentFragmentManager // TthirdFragment를 가리킨다.
                    .beginTransaction()
                    .replace(R.id.secondFragmentFrame, MarketplaceFragment())
                    .addToBackStack(null)
                    .commitAllowingStateLoss()
            }
        }
    }
}