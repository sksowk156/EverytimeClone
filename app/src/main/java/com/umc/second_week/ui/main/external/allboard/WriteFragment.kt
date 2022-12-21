package com.umc.second_week.ui.main.external.allboard

import android.app.Activity
import android.content.Context
import android.os.Bundle

import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.umc.second_week.R
import com.umc.second_week.data.WriteData

import com.umc.second_week.databinding.FragmentWriteBinding
import com.umc.second_week.ui.popup.KeeppopupFragment
import com.umc.second_week.ui.popup.PopupFragment

class WriteFragment : Fragment() {

    // DataBinding
    private var _binding: FragmentWriteBinding? = null
    private val binding: FragmentWriteBinding get() = _binding!!

    lateinit var writeData: WriteData

    lateinit var callback: OnBackPressedCallback

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // DataBinding
        _binding = FragmentWriteBinding.inflate(inflater, container, false)

        writeData =
            ViewModelProvider(this.requireActivity(), ViewModelProvider.NewInstanceFactory()).get(
                WriteData::class.java
            )
        binding.lifecycleOwner = this.viewLifecycleOwner
        binding.writeData = writeData

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.toolbar2.inflateMenu(R.menu.top_menu2)
        binding.toolbar2.setNavigationIcon(R.drawable.ic_baseline_close_24)
        binding.toolbar2.setNavigationOnClickListener {
            requireActivity().supportFragmentManager.findFragmentByTag("tthird")!!.parentFragmentManager
                .popBackStackImmediate(null, 0)
        }

        writeData.showtitleErrorToast.observe(this.viewLifecycleOwner, Observer {
            it.getContentIfNotHandled()?.let {
                Toast.makeText(requireActivity(), "제목을 쓰세요", Toast.LENGTH_SHORT).show()
            }
        })

        writeData.showcontentsErrorToast.observe(this.viewLifecycleOwner, Observer {
            it.getContentIfNotHandled()?.let {
                Toast.makeText(requireActivity(), "내용을 쓰세요", Toast.LENGTH_SHORT).show()
            }
        })

        writeData.savecompleteBt.observe(this.viewLifecycleOwner, Observer {
            it.getContentIfNotHandled()?.let {
                Toast.makeText(requireActivity(), "데이터가 저장되었습니다.", Toast.LENGTH_SHORT).show()
                hideKeyboard()
                requireActivity().supportFragmentManager.findFragmentByTag("tthird")!!.parentFragmentManager
                    .popBackStackImmediate(null, 0)
            }
        })
    }

    fun Fragment.hideKeyboard() {
        view?.let { activity?.hideKeyboard(it) }
    }
    fun Context.hideKeyboard(view: View) {
        val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                // 다이얼로그 띄우기
                if (binding.titleplace.length() > 0 || binding.contentsplace.length() > 0) {
                    val showpopup = PopupFragment()
                    showpopup.show(parentFragmentManager, "showpopup")
                } else {
                    requireActivity().supportFragmentManager.findFragmentByTag("tthird")!!.parentFragmentManager
                        .popBackStackImmediate(null,0)
                }
                /* editText의 텍스트 변화 감지 리스너,
                handleOnBackPressed 메소드 안에서 선언한거라 뒤로가기 누를때만 작동할줄 알앗는데
                그거랑 상관없이 글자 수 변화 감지만 열심히 해서 사용하지 못함

                binding.editTextt.addTextChangedListener(object:TextWatcher{
                    override fun beforeTextChanged(
                        s: CharSequence?,
                        start: Int,
                        count: Int,
                        after: Int
                    ) {
                        if(binding.editTextt.length() >0 || binding.editTextt2.length() >0){
                            Log.d("backbt","okay??")

                        }else{
                            Log.d("backbt","okay!!")
                        }
                    }

                    override fun onTextChanged(
                        s: CharSequence?,
                        start: Int,
                        before: Int,
                        count: Int
                    ) {
                    }

                    override fun afterTextChanged(s: Editable?) {
                        if(binding.editTextt.length() >0 || binding.editTextt2.length() >0){
                            Log.d("backbt","okay??")

                        }else{
                            Log.d("backbt","okay!!")
                        }
                    }
                })
                */
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(this, callback)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onDetach() {
        super.onDetach()
        callback.remove()
    }

    override fun onResume() {
        super.onResume()
        Log.d("adddd",parentFragmentManager.backStackEntryCount.toString())
    }

    override fun onStart() {
        super.onStart()
        // 이어서 작성할 건지 물어보기
        if (binding.titleplace.length() != 0 || binding.contentsplace.length() != 0) {
            val showpopup = KeeppopupFragment()
            showpopup.show(parentFragmentManager, "showcheckpopup")
        }
    }
}