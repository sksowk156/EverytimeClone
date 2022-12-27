package com.umc.second_week.ui.main.external.allboard.marketplace

import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.umc.second_week.R
import com.umc.second_week.data.remote.marketplace.service.MarketplaceService.marketplaceservice
import com.umc.second_week.databinding.FragmentMarketplaceBinding
import com.umc.second_week.ui.BaseFragment
import com.umc.second_week.ui.main.external.allboard.marketplace.adapt.MarketplaceAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class MarketplaceFragment :
    BaseFragment<FragmentMarketplaceBinding>(R.layout.fragment_marketplace) {

    private lateinit var viewModel : MarketplaceViewModel

    override fun init() {
        initAPI()
    }

    private fun initAPI() {
        with(binding) {
            // 1. 어댑터 생성 및 리사이클러뷰 연결
            val marketplaceAdapter = MarketplaceAdapter()
            marketplaceRecyclerview.adapter = marketplaceAdapter
            marketplaceRecyclerview.layoutManager = LinearLayoutManager(context)

//          //   기본 Retrofit의 비동기처리햣
//            marketplaceservice.kotlinUsers().enqueue(object : Callback<MarketplaceDTO> {
//                override fun onResponse(
//                    call: Call<MarketplaceDTO>,
//                    response: Response<MarketplaceDTO>
//                ) {
//                    response.body()?.let { result ->
//                        marketplaceAdapter.userList = result
//                        marketplaceAdapter.notifyDataSetChanged()
//                    }
//                }
//
//                override fun onFailure(call: Call<MarketplaceDTO>, t: Throwable) {
//                    Log.e("에러에러", "${t.localizedMessage}")
//                }
//            })

//            // 코루틴
//            CoroutineScope(Dispatchers.IO).launch {
//                val response = marketplaceservice.kotlinUsers()
//
//                withContext(Dispatchers.Main) {
//                    if (response.isSuccessful) {
//                        response.body()?.let { result ->
//                            marketplaceAdapter.userList = result
//                            marketplaceAdapter.notifyDataSetChanged()
//                        }
//                    } else {
//                        Log.d("TAG", response.code().toString())
//                    }
//                }
//            }

            // 코루틴 + Repository + ViewModel + ViewModelFactory
            val repository = MarketplaceRepository()
            val viewModelFactory = MarketplaceViewModelFactory(repository)
            viewModel = ViewModelProvider(this@MarketplaceFragment.requireActivity() , viewModelFactory).get(MarketplaceViewModel::class.java)
            viewModel.kotlinUsers()
            viewModel.myResponse.observe(this@MarketplaceFragment.viewLifecycleOwner, Observer {
                if(it.isSuccessful){
                    it.body()?.let { result ->
                        marketplaceAdapter.userList = result
                        marketplaceAdapter.notifyDataSetChanged()
                    }
                }
                else{
                    Log.d("Response",it.errorBody().toString())
                }
            })
        }
    }
}