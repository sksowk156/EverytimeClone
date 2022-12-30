package com.umc.second_week.ui.main.external.allboard.marketplace

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.umc.second_week.R
import com.umc.second_week.data.remote.marketplace.dto.MarketplaceDTO
import com.umc.second_week.data.remote.marketplace.dto.MarketplaceDTOItem
import com.umc.second_week.databinding.FragmentMarketplaceBinding
import com.umc.second_week.ui.BaseFragment
import com.umc.second_week.ui.main.external.allboard.marketplace.adapt.MarketplaceAdapter


class MarketplaceFragment :
    BaseFragment<FragmentMarketplaceBinding>(R.layout.fragment_marketplace) {

    private lateinit var viewModel: MarketplaceViewModel

    override fun init() {
        initAPI()
    }

    private fun initAPI() {
        with(binding) {
            // 1. 어댑터 생성 및 리사이클러뷰 연결
            val marketplaceAdapter = MarketplaceAdapter()
            marketplaceRecyclerview.adapter = marketplaceAdapter
            marketplaceRecyclerview.layoutManager = LinearLayoutManager(context)

//          //   기본 Retrofit의 비동기 처리
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

//            // 코루틴 + Repository + ViewModel + ViewModelFactory
//            val repository = MarketplaceRepository()
//            val viewModelFactory = MarketplaceViewModelFactory(repository)
//            viewModel = ViewModelProvider(this@MarketplaceFragment , viewModelFactory).get(MarketplaceViewModel::class.java)
//            viewModel.kotlinUsers()
//
//            viewModel.myResponse.observe(this@MarketplaceFragment.viewLifecycleOwner, Observer {
//                if(it.isSuccessful){
//                    it.body()?.let { result ->
//                        marketplaceAdapter.userList = result
//                        marketplaceAdapter.notifyDataSetChanged()
//                    }
//                }
//                else{
//                    Log.d("Response",it.errorBody().toString())
//                }
//            })
//


            // 코루틴 + Repository + ViewModel + ViewModelFactory + listadapter
            val repository = MarketplaceRepository()
            val viewModelFactory = MarketplaceViewModelFactory(repository)
            viewModel = ViewModelProvider(this@MarketplaceFragment, viewModelFactory).get(
                MarketplaceViewModel::class.java
            )

            // 검색 버튼 누르면
            search.setOnClickListener {
                // 검색할 문자열이 있을 경우
                if(marketplaceSearch.text.length!=0) {
                    viewModel.UsersLogin(marketplaceSearch.text.toString())

                    viewModel.myResponse_2.observe(this@MarketplaceFragment.viewLifecycleOwner, Observer {
                        if(it.isSuccessful){
                            it.body()?.let{ result-> // dto가 다르기 때문에 필요한 데이터만 임시 MarketplaceDTOItem 인스턴스에 삽입 후 생성한다.
                                var temp1 = MarketplaceDTOItem(id = result.id, login = result.login, avatar_url = result.avatar_url)

                                var temp_2 = MarketplaceDTO()
                                if (temp1 != null) {
                                    temp_2?.add(temp1)
                                }

                                marketplaceAdapter.submitList(temp_2) // adapter에는 리스트가 필요하므로 MarketplaceDTO 형태로 보내야 한다.
                            }
                        }else{
                            Toast.makeText(context,"데이터가 없습니다.",Toast.LENGTH_SHORT).show()
                        }
                    })
                }else{ // 검색할 문자열이 없는 경우
                    viewModel.Users() // 데이터 전부를 불러옴

                    viewModel.myResponse.observe(this@MarketplaceFragment.viewLifecycleOwner, Observer {
                        if (it.isSuccessful) {
                            it.body()?.let { result ->
                                marketplaceAdapter.submitList(result)
                            }
                        } else {
                            Log.d("Response", it.errorBody().toString())
                        }
                    })

                }
            }


//            // 코루틴 + @Path 경로 설정
//            search.setOnClickListener {
//                CoroutineScope(Dispatchers.IO).launch {
//                    if(marketplaceSearch.text.length==0){
//
//                        val response = marketplaceservice.Users()
//
//                        withContext(Dispatchers.Main) {
//                            if (response.isSuccessful) {
//                                response.body()?.let { result ->
//                                    marketplaceSearchresult.text = ""
//                                    marketplaceAdapter.userList = result
//                                    marketplaceAdapter.notifyDataSetChanged()
//                                }
//                            } else {
//                                Log.d("TAG", response.code().toString())
//                            }
//                        }
//                    }else{
//                        marketplaceAdapter.userList = null
//
//                        val response = marketplaceservice.UsersLogin(marketplaceSearch.text.toString())
//                        withContext(Dispatchers.Main) {
//                            if (response.isSuccessful) {
//                                response.body()?.let { result ->
//                                    marketplaceSearchresult.text = result.id.toString()
//                                }
//                            } else {
//                                marketplaceSearchresult.text = "없음"
//                                Log.d("TAG", response.code().toString())
//                            }
//                        }
//                    }
//                }
//           }
        }
    }
}
