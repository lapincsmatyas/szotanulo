package com.bme.szotanulo.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bme.szotanulo.databinding.CardListItemBinding
import com.bme.szotanulo.model.Card


class CardItemAdapter(val clickListener: CardListener) : ListAdapter<Card, CardItemAdapter.ViewHolder>(CardDiffCallback()) {
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(getItem(position)!!, clickListener)
        holder.bind(item, clickListener)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }


    class ViewHolder private constructor(val binding: CardListItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(cardDto: Card, clickListener: CardListener) {
            binding.card = cardDto
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding =
                    CardListItemBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }
}

class CardDiffCallback : DiffUtil.ItemCallback<Card>() {
    override fun areItemsTheSame(oldItem: Card, newItem: Card): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Card, newItem: Card): Boolean {
        return oldItem == newItem
    }
}

class CardListener(val clickListener: (cardId: Long) -> Unit) {
    fun onClick(cardDto: Card) = clickListener(cardDto.id)
}