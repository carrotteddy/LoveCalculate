package com.example.lovecalculate.onBoarding.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.lovecalculate.R
import com.example.lovecalculate.databinding.ItemOnBoardBinding
import com.example.lovecalculate.model.OnBoarding

class OnBoardAdapter(private val onClick: () -> Unit) :
    RecyclerView.Adapter<OnBoardAdapter.OnBoardViewHolder>() {

    val data = arrayListOf(
        OnBoarding("title 1", "desc 1"),
        OnBoarding("title 2", "desc 2"),
        OnBoarding("title 3", "desc 3"),
        OnBoarding("title 4", "desc 4")
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardViewHolder {
        return OnBoardViewHolder(
            ItemOnBoardBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: OnBoardViewHolder, position: Int) {
        holder.bind(data[position])
    }

    inner class OnBoardViewHolder(private val binding: ItemOnBoardBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(onBoarding: OnBoarding) {
            with(binding) {
                tvTitle.text = onBoarding.title
                tvDesc.text = onBoarding.desc

                when(adapterPosition){
                    0-> img.setAnimation(R.raw.animation_1)
                    1 -> img.setAnimation(R.raw.animation_2)
                    2 -> img.setAnimation(R.raw.animation_3)
                    3 -> img.setAnimation(R.raw.animation_4)
                }

                btnStart.isVisible = adapterPosition == data.lastIndex
                btnSkip.isVisible = adapterPosition != data.lastIndex

                btnSkip.setOnClickListener {
                    onClick()
                }

                btnStart.setOnClickListener {
                    onClick()
                }

            }
        }
    }
}