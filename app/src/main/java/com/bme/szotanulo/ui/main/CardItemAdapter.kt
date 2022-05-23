package com.bme.szotanulo.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bme.szotanulo.R
import com.bme.szotanulo.model.Card

class TextItemViewHolder(val textView: TextView): RecyclerView.ViewHolder(textView)

class CardItemAdapter: RecyclerView.Adapter<TextItemViewHolder>() {
    var data =  listOf<Card>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount() = data.size
    override fun onBindViewHolder(holder: TextItemViewHolder, position: Int) {
        val item = data[position]
        holder.textView.text = item.frontSide
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater
            .inflate(R.layout.card_list_item, parent, false) as TextView
        return TextItemViewHolder(view)
    }
}
