package kr.co.snack655.myportfolio.adapter.callback

import androidx.recyclerview.widget.DiffUtil
import kr.co.snack655.domain.entitiy.HomeIntro
import kr.co.snack655.domain.entitiy.MainBanner
import kr.co.snack655.domain.entitiy.MainBook

object IntroDiffCallBack : DiffUtil.ItemCallback<HomeIntro>() {
    override fun areItemsTheSame(oldItem: HomeIntro, newItem: HomeIntro): Boolean {
        return oldItem === newItem
    }

    override fun areContentsTheSame(oldItem: HomeIntro, newItem: HomeIntro): Boolean {
        return oldItem == newItem
    }

}