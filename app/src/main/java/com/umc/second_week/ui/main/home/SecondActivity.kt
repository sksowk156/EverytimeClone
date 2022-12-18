package com.umc.second_week.ui.main.home

import android.content.Context
import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import com.umc.second_week.R
import com.umc.second_week.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        overridePendingTransition(R.anim.slide_right_to_left, R.anim.none)

        binding.imageView.imageTintList = ColorStateList.valueOf(Color.parseColor("#F2F2F2"))

        val data = binding.editText.text

        // 입력 모드
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE)
        // 키보드 열기
        showKeyboard(binding.editText)


        // 버튼 엔터
        binding.button.setOnClickListener {

            val intent = Intent(this, ThirdActivity::class.java)
            intent.putExtra("text",data.toString())
            startActivity(intent)

        }

        // editText에서 엔터
        binding.editText.setOnEditorActionListener{ textView, action, event ->
            var handled = false
            if (action == EditorInfo.IME_ACTION_SEARCH) {
                val intent = Intent(this, ThirdActivity::class.java)
                intent.putExtra("text",data.toString())
                startActivity(intent)
                handled = true
            }
            handled
        }
    }

    // 키보드 보여주기
    private fun showKeyboard(editText: EditText) {
        val manager : InputMethodManager =
            getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        // 키보드 보여주기
        manager.showSoftInput(binding.editText.rootView, InputMethodManager.SHOW_IMPLICIT)

        // 포커스 지정
        binding.editText.requestFocus()
    }


    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(R.anim.none, R.anim.slide_left_to_right)
    }
}