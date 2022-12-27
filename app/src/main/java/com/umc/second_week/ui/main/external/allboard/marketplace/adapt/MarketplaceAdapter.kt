package com.umc.second_week.ui.main.external.allboard.marketplace.adapt

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.umc.second_week.data.remote.marketplace.dto.MarketplaceDTO
import com.umc.second_week.data.remote.marketplace.dto.MarketplaceDTOItem
import com.umc.second_week.databinding.ListItemMarketplaceBinding

//class MarketplaceAdapter : RecyclerView.Adapter<Holder>() {
//
//    var userList: MarketplaceDTO? = null
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
//        val binding =
//            ListItemMarketplaceBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//        return Holder(binding)
//    }
//
//    override fun onBindViewHolder(holder: Holder, position: Int) {
//        val user = userList?.get(position)
//
//        holder.setUser(user)
//    }
//
//    override fun getItemCount(): Int {
//        return userList?.size ?: 0
//    }
//}
//
//class Holder(val binding: ListItemMarketplaceBinding) : RecyclerView.ViewHolder(binding.root) {
//
//    fun setUser(user: MarketplaceDTOItem?) {
//        with(binding) {
//            userId.text = user?.node_id
//            userName.text = user?.full_name
//            Glide.with(userImage).load(user?.owner?.avatar_url).into(userImage)
//        }
//    }
//}

class MarketplaceAdapter : ListAdapter<MarketplaceDTOItem, MarketplaceAdapter.MyViewHolder>(
    MarketplaceDTODiffUtil
) {

    inner class MyViewHolder(val binding: ListItemMarketplaceBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(user: MarketplaceDTOItem) {
            with(binding) {
                userId.text = user?.node_id
                userName.text = user?.full_name
                Glide.with(userImage).load(user?.owner?.avatar_url).into(userImage)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding =
            ListItemMarketplaceBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

object MarketplaceDTODiffUtil : DiffUtil.ItemCallback<MarketplaceDTOItem>() {
    override fun areItemsTheSame(
        oldItem: MarketplaceDTOItem, newItem: MarketplaceDTOItem
    ): Boolean {
        return oldItem.hashCode() == newItem.hashCode()
    }

    override fun areContentsTheSame(
        oldItem: MarketplaceDTOItem, newItem: MarketplaceDTOItem
    ): Boolean {
        return oldItem == newItem
    }
}