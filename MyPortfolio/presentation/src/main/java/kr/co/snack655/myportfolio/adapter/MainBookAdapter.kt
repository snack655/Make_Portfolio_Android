package kr.co.snack655.myportfolio.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kr.co.snack655.domain.entitiy.MainBook
import kr.co.snack655.myportfolio.R
import kr.co.snack655.myportfolio.adapter.callback.MainBookDiffCallBack
import kr.co.snack655.myportfolio.databinding.ItemMainBookBinding
import kr.co.snack655.myportfolio.util.Book

class MainBookAdapter():
ListAdapter<MainBook, MainBookAdapter.MainBookViewHolder>(MainBookDiffCallBack){

    class MainBookViewHolder(private val binding : ItemMainBookBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data : MainBook) {
            with(data) {
                Glide.with(binding.root)
                    .load(data.bookBanner)
                    .centerCrop()
                    .error(R.drawable.book1)
                    .into(binding.ivBook)
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MainBookViewHolder {
        val binding = DataBindingUtil.inflate<ItemMainBookBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_main_book,
            parent,
            false
        )

        return MainBookViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainBookViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}