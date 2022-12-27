package com.umc.second_week.ui.main.external.allboard.marketplace

import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.umc.second_week.R
import com.umc.second_week.data.remote.marketplace.`interface`.MarketplaceRetrofitInterface
import com.umc.second_week.data.remote.marketplace.dto.MarketplaceDTO
import com.umc.second_week.data.remote.marketplace.service.MarketplaceService.marketplaceservice
import com.umc.second_week.databinding.FragmentMarketplaceBinding
import com.umc.second_week.ui.BaseFragment
import com.umc.second_week.ui.main.external.allboard.marketplace.adapter.MarketplaceAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MarketplaceFragment :
    BaseFragment<FragmentMarketplaceBinding>(R.layout.fragment_marketplace) {
    override fun init() {
        initAPI()
    }

    private fun initAPI() {
        with(binding) {
            // 1. 어댑터 생성 및 리사이클러뷰 연결
            val marketplaceAdapter = MarketplaceAdapter()
            marketplaceRecyclerview.adapter = marketplaceAdapter
            marketplaceRecyclerview.layoutManager = LinearLayoutManager(context)

//            // 2. 레트로핏 생성
//            val retrofit = Retrofit.Builder()
//                .baseUrl("https://api.github.com")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build()

//            // 3. MarketplaceRetrofitInterface(interface)를 실제 사용가능한 코드로 변환
//            val marketplaceRetrofitInterface = retrofit.create(MarketplaceRetrofitInterface::class.java)

            // 4. 버튼 클릭 시 데이터를 가져와서 어댑터에 달아준다.
            marketplaceservice.kotlinUsers().enqueue(object : Callback<MarketplaceDTO> {
                override fun onResponse(
                    call: Call<MarketplaceDTO>,
                    response: Response<MarketplaceDTO>
                ) {
                    response.body()?.let { result ->
                        marketplaceAdapter.userList = result
                        marketplaceAdapter.notifyDataSetChanged()
                    }
                }

                override fun onFailure(call: Call<MarketplaceDTO>, t: Throwable) {
                    Log.e("에러에러", "${t.localizedMessage}")
                }
            })
        }
    }
}