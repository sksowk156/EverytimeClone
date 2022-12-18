package com.umc.second_week.ui.main.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.umc.second_week.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {

    private lateinit var binding : ActivityThirdBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val extras = intent.extras
        val data = extras!!["text"] as String

        binding.thirdtextview.text = data
    }
}