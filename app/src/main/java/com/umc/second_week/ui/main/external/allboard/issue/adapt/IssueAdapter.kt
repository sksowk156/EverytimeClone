package com.umc.second_week.ui.main.external.allboard.issue.adapt

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.umc.second_week.data.remote.issue.dto.DailyBoxOffice
import com.umc.second_week.databinding.ListItemIssueBinding

class IssueAdapter: ListAdapter<DailyBoxOffice, IssueAdapter.MyViewHolder>(
    IssueDTODiffUtil
) {

    inner class MyViewHolder(val binding: ListItemIssueBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(issue: DailyBoxOffice) {
            with(binding) {
                issueNumber.text = issue.rank
                issueName.text = issue.movieNm
                issueDate.text = issue.openDt
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding =
            ListItemIssueBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

object IssueDTODiffUtil : DiffUtil.ItemCallback<DailyBoxOffice>() {
    override fun areItemsTheSame(
        oldItem: DailyBoxOffice, newItem: DailyBoxOffice
    ): Boolean {
        return oldItem.hashCode() == newItem.hashCode()
    }

    override fun areContentsTheSame(
        oldItem: DailyBoxOffice, newItem: DailyBoxOffice
    ): Boolean {
        return oldItem == newItem
    }
}