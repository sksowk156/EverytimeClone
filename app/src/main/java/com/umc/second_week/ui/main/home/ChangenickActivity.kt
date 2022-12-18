package com.umc.second_week.ui.main.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.umc.second_week.R
import com.umc.second_week.databinding.ActivityChangenickBinding

class ChangenickActivity : AppCompatActivity() {
    private lateinit var binding: ActivityChangenickBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_changenick)

        val extras = intent.extras
        val data = extras!!["nickname"] as String
        binding.editnickText.setText(data)

        val newnick = binding.editnickText.text
        binding.changebtn.setOnClickListener {
            val intent = Intent(this, IndivisualActivity::class.java)
            intent.putExtra("newnickname", newnick.toString())
            setResult(RESULT_OK, intent)
            if(!isFinishing) finish()
        }
    }
}