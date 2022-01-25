package kr.co.snack655.myportfolio.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kr.co.snack655.domain.entitiy.HomeIntro
import kr.co.snack655.myportfolio.R
import kr.co.snack655.myportfolio.adapter.callback.IntroDiffCallBack
import kr.co.snack655.myportfolio.databinding.ItemIntroBinding


class HomeIntroAdapter():
    ListAdapter<HomeIntro, HomeIntroAdapter.IntroViewHolder>(IntroDiffCallBack){

    class IntroViewHolder(private val binding : ItemIntroBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data : HomeIntro) {
            with(data) {
                binding.test.text = text
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): IntroViewHolder {
        val binding = DataBindingUtil.inflate<ItemIntroBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_intro,
            parent,
            false
        )

        return IntroViewHolder(binding)
    }

    override fun onBindViewHolder(holder: IntroViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}