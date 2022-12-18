package com.umc.second_week.ui.main.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.umc.second_week.data.IndivisualViewModel
import com.umc.second_week.R
import com.umc.second_week.databinding.ActivityIndivisualBinding

class IndivisualActivity : AppCompatActivity() {
    private lateinit var binding: ActivityIndivisualBinding
    private lateinit var getResultText: ActivityResultLauncher<Intent>
    private lateinit var indivisualViewModel: IndivisualViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_indivisual)
        indivisualViewModel = ViewModelProvider(this).get(IndivisualViewModel::class.java)
        binding.lifecycleOwner = this
        binding.indivisual = indivisualViewModel

        getResultText = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()) { result->
            if(result.resultCode == RESULT_OK){
                val mString = result.data?.getStringExtra("newnickname")
                Toast.makeText(this, mString,Toast.LENGTH_SHORT).show()
                indivisualViewModel.changeNick(mString.toString())
            }
        }

        binding.nickTxt.setOnClickListener{
            val intent = Intent(this@IndivisualActivity, ChangenickActivity::class.java)
            intent.putExtra("nickname",binding.myID.text.toString())
            getResultText.launch(intent)
        }
    }
}