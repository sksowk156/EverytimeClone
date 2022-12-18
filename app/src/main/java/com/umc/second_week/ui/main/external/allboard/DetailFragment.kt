package com.umc.second_week.ui.main.external.allboard

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.*
import androidx.lifecycle.ViewModelProvider
import com.umc.second_week.R
import com.umc.second_week.data.WriteData
import com.umc.second_week.databinding.FragmentDetailBinding


class DetailFragment : Fragment() {
    // DataBinding
    private var _binding: FragmentDetailBinding? = null
    private val binding: FragmentDetailBinding get() = _binding!!

    // ViewModel
    private lateinit var writeData: WriteData

    // BackPress 이벤트 처리
    private lateinit var callback: OnBackPressedCallback

    // MytextFragment나 FourthFragment에서 position 정보를 받을 경우 position 정보를 저장하기 위함
    private var position: Int ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                requireActivity().supportFragmentManager.findFragmentByTag("tthird")!!.childFragmentManager
                    .popBackStack(null, 0)
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(this, callback)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentDetailBinding.inflate(inflater, container, false)

        // ViewModel
        writeData =
            ViewModelProvider(this.requireActivity(), ViewModelProvider.NewInstanceFactory()).get(
                WriteData::class.java
            )
        binding.lifecycleOwner = this.viewLifecycleOwner
        binding.writeData = writeData

        return binding.root
    }

    override fun onResume() {
        super.onResume()
        Log.d("adddd", parentFragmentManager.backStackEntryCount.toString())

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        // MytextFragment에서 position 데이터 받기
        setFragmentResultListener("positiondata") { positiondata, bundle ->
            position = bundle.getInt("_positiondata")
            // 전송 받은 데이터가 있을 경우
            position?.let { it1 -> writeData.findData(it1) }
        }

        // WriteFragment에서 Pop당해서 돌아와 다시 recreate될 때
        // WriteFragment에서 data1과 data2에 수정을 한 뒤 저장을 하지 않았다면, DetailFragment에서는 원래 데이터를 보여줘야한다.
        // 수정 내용을 저장하지 않았다면 data3(=position)에 데이터가 남아있기 때문에,
        // 그것을 이용해 DetailFragment가 recreate 될 때 다시 data3에 대한 data1과 data2를 초기화 시켜줘야 한다.
        if(writeData.data3 !=null)
        {
            writeData.findData(writeData.data3!!)
        }

        binding.toolbar.inflateMenu(R.menu.top_menu4)
        binding.toolbar.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24)
        binding.toolbar.setNavigationOnClickListener {
//            TthirdFragment().childFragmentManager
            requireActivity().supportFragmentManager.findFragmentByTag("tthird")!!.childFragmentManager
                .popBackStackImmediate(null, 0)

        }
        binding.toolbar.setOnMenuItemClickListener {

            when (it.itemId) {
                R.id.reload -> {
                    true
                }
                R.id.fix -> {
                    // 화면 전환
                    parentFragmentManager
                        .beginTransaction()
                        .replace(R.id.secondFragmentFrame, WriteFragment())
                        .addToBackStack(null)
                        .commitAllowingStateLoss()
                    true
                }
                R.id.delete -> {
                    // dialog로 삭제할건지 묻기
                    // 삭제하면 다시 MytextFragment로 이동하고 초기화된 recycler보여줌
                    // 삭제안하면 그 화면 그대로 유지
                    true
                }
                R.id.URL -> {
                    true
                }
                else -> false
            }
        }
    }

    override fun onDetach() {
        super.onDetach()
        callback.remove()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}