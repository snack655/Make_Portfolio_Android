package kr.co.snack655.myportfolio.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kr.co.snack655.domain.entitiy.MainBanner
import kr.co.snack655.myportfolio.R
import kr.co.snack655.myportfolio.adapter.callback.MainBannerDiffCallBack
import kr.co.snack655.myportfolio.databinding.ItemBannerBinding


class MainBannerAdapter():
ListAdapter<MainBanner, MainBannerAdapter.MainBannerViewHolder>(MainBannerDiffCallBack){

    class MainBannerViewHolder(private val binding : ItemBannerBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data : MainBanner) {
            with(data) {
                Glide.with(binding.root)
                    .load(data.mainBanner)
                    .centerCrop()
                    .error(R.drawable.banner1)
                    .into(binding.ivBanner)
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MainBannerViewHolder {
        val binding = DataBindingUtil.inflate<ItemBannerBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_banner,
            parent,
            false
        )

        return MainBannerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainBannerViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}