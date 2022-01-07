package kr.co.snack655.myportfolio.adapter.callback

import androidx.recyclerview.widget.DiffUtil
import kr.co.snack655.domain.entitiy.MainBanner
import kr.co.snack655.domain.entitiy.MainBook

object MainBannerDiffCallBack : DiffUtil.ItemCallback<MainBanner>() {
    override fun areItemsTheSame(oldItem: MainBanner, newItem: MainBanner): Boolean {
        return oldItem === newItem
    }

    override fun areContentsTheSame(oldItem: MainBanner, newItem: MainBanner): Boolean {
        return oldItem == newItem
    }

}