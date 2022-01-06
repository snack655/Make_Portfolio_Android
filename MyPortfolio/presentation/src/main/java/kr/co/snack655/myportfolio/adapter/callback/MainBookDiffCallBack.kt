package kr.co.snack655.myportfolio.adapter.callback

import androidx.recyclerview.widget.DiffUtil
import kr.co.snack655.domain.entitiy.MainBook

object MainBookDiffCallBack : DiffUtil.ItemCallback<MainBook>() {
    override fun areItemsTheSame(oldItem: MainBook, newItem: MainBook): Boolean {
        return oldItem === newItem
    }

    override fun areContentsTheSame(oldItem: MainBook, newItem: MainBook): Boolean {
        return oldItem == newItem
    }

}