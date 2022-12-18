package com.umc.second_week.ui.main.external.allboard.board

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.lifecycle.ViewModelProvider
import com.umc.second_week.*
import com.umc.second_week.data.WriteData
import com.umc.second_week.databinding.FragmentFourthBinding
import com.umc.second_week.ui.main.external.allboard.board.adapt.MyfourthAdapter
import com.umc.second_week.ui.main.external.allboard.DetailFragment
import com.umc.second_week.ui.main.external.allboard.WriteFragment
import com.umc.second_week.ui.popup.MinipopupFragment

class FourthFragment : Fragment(), MyfourthAdapter.ItemClickListener {
    // DataBinding
    private var _binding: FragmentFourthBinding? = null
    private val binding: FragmentFourthBinding get() = _binding!!

    // ViewModel
    private lateinit var writeData: WriteData

    // BackPress 이벤트 처리
    private lateinit var callback: OnBackPressedCallback

    // RecyclerView
//    var recyclerView : RecyclerView?=null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        // DataBinding
        _binding = FragmentFourthBinding.inflate(inflater, container, false)

        // ViewModel
        writeData =
            ViewModelProvider(this.requireActivity(), ViewModelProvider.NewInstanceFactory()).get(
                WriteData::class.java
            )
        binding.lifecycleOwner = this.viewLifecycleOwner
        binding.writeData = writeData
        binding.recyclerView.adapter = MyfourthAdapter(this)
        binding.recyclerView.setHasFixedSize(true)
//        binding.recyclerView.adapter?.stateRestorationPolicy = RecyclerView.Adapter.StateRestorationPolicy.PREVENT_WHEN_EMPTY
        binding.swipelayout.setOnRefreshListener {
            parentFragmentManager
                .beginTransaction()
                .detach(this)
                .attach(this)
                .commitAllowingStateLoss()
            binding.swipelayout.isRefreshing = false
        }
        // RecyclerView
//        recyclerView = binding.recyclerView
//        recyclerView?.layoutManager = LinearLayoutManager(context)

//        writeData.userMutableLiveData?.observe(this.viewLifecycleOwner, userListUpdateObserver)
        return binding.root
    }


/*
// ArrayList<User>를 관찰하고 변화하면 변화된 값을 Adapter로 xml에 넣어주자.
    var userListUpdateObserver : Observer<ArrayList<User>?> =   Observer<ArrayList<User>?> { userArrayList ->
        recyclerViewAdapter = MyfourthAdapter()
        recyclerView!!.layoutManager = LinearLayoutManager(context)
        recyclerView!!.adapter = recyclerViewAdapter
    }
*/


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 뒤로가기를 눌렀을 때 이벤트 처리
        callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
//                parentFragmentManager
//                    .beginTransaction()
//                    .replace(R.id.secondFragmentFrame, ThirdFragment())
//                    .commitAllowingStateLoss()
                requireActivity().supportFragmentManager.findFragmentByTag("tthird")!!.parentFragmentManager
                    .popBackStackImmediate(null, 0)
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(this, callback)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.toolbar.inflateMenu(R.menu.top_menu)
        binding.toolbar.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24)
        binding.toolbar.setNavigationOnClickListener {
//            parentFragmentManager
//                .beginTransaction()
//                .replace(R.id.secondFragmentFrame, ThirdFragment())
//                .commitAllowingStateLoss()
            requireActivity().supportFragmentManager.findFragmentByTag("tthird")!!.parentFragmentManager
                .popBackStackImmediate(null, 0)
        }
        binding.toolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.search -> {
                    true
                }
                R.id.write -> {
                    writeData.eraseEditTextData()
                    parentFragmentManager
                        .beginTransaction()
                        .replace(R.id.secondFragmentFrame, WriteFragment())
                        .addToBackStack(null)
                        .commitAllowingStateLoss()
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

    override fun onResume() {
        super.onResume()
        Log.d("adddd", parentFragmentManager.backStackEntryCount.toString())
    }

    override fun onItemClick(view: View, position: Int) {
//        // ViewModel에서 확인할 데이터 position을 저장
//        writeData.findData(position)
//        // 화면 전환( 다른 fragment로 전환하게 되면, ViewModel로 데이터를 표현해주는데 그때 ViewModel 안에 어떤 데이터인지 정보가 필요함 그래서 위 코드가 필요

        // DetailFragment에 position 데이터를 전송하기 위함
        val _position = position
        setFragmentResult("positiondata", bundleOf("_positiondata" to _position))

        // 화면 전환
        parentFragmentManager
            .beginTransaction()
            .replace(R.id.secondFragmentFrame, DetailFragment())
            .setReorderingAllowed(true)
            .addToBackStack(null)
            .commitAllowingStateLoss()

    }

    override fun onItemLongClick(view: View, position: Int) {
        Log.d("whatisthis", position.toString())

        // 삭제할 건지 묻는 다이얼로그
        // 삭제시 fragment 초기화 or recyclerview 초기화 or viewmodel 초기화(이건 자동인가?? -> 확인해보자)
        // ViewModel에서 삭제할 데이터 position을 미리 저장
        writeData.findData(position)
        val showpopup = MinipopupFragment()
        showpopup.show(parentFragmentManager, "showpopup")
    }

}