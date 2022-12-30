package com.umc.second_week.ui.main.external.allboard.issue

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.umc.second_week.R
import com.umc.second_week.data.remote.marketplace.dto.MarketplaceDTO
import com.umc.second_week.data.remote.marketplace.dto.MarketplaceDTOItem
import com.umc.second_week.databinding.FragmentIssueBinding
import com.umc.second_week.ui.BaseFragment
import com.umc.second_week.ui.main.external.allboard.issue.adapt.IssueAdapter
import com.umc.second_week.ui.main.external.allboard.marketplace.MarketplaceRepository
import com.umc.second_week.ui.main.external.allboard.marketplace.MarketplaceViewModel
import com.umc.second_week.ui.main.external.allboard.marketplace.MarketplaceViewModelFactory

class IssueFragment : BaseFragment<FragmentIssueBinding>(R.layout.fragment_issue) {
    private lateinit var viewModel: IssueViewModel
    override fun init() {
        initAPI()
    }

    private fun initAPI() {
        with(binding) {
            val issueAdapter = IssueAdapter()
            issueRecyclerview.adapter = issueAdapter
            issueRecyclerview.layoutManager = LinearLayoutManager(context)


            val repository = IssueRepository()
            val viewModelFactory = IssueViewModelFactory(repository)
            viewModel = ViewModelProvider(this@IssueFragment, viewModelFactory).get(
                IssueViewModel::class.java
            )
            viewModel.issue("b08827bfc21dfdcb4841d808ca556c3d", "20201201")

            viewModel.myResponse.observe(this@IssueFragment.viewLifecycleOwner, Observer {
                if (it.isSuccessful) {
                    it.body()
                        ?.let { result ->
                            issueAdapter.submitList(result?.boxOfficeResult?.dailyBoxOfficeList)
                        }
                } else {
                    Toast.makeText(context, "데이터가 없습니다.", Toast.LENGTH_SHORT).show()
                }
            })


        }
    }
}