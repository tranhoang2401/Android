package com.example.googleplaystore

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemAdapter() : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>(){
    private lateinit var listItem : ArrayList<ItemApplication>
    private lateinit var context : Context
    constructor(listItem : ArrayList<ItemApplication>, context : Context):this() {
        this.listItem = listItem
        this.context = context
    }
    class ItemViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        lateinit var image : ImageView
        lateinit var tvName : TextView
        init {
            tvName = itemView.findViewById(R.id.text_item)
            image = itemView.findViewById(R.id.image_item)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_app, parent, false))
    }

    override fun getItemCount(): Int {
        return listItem.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        var item = listItem.get(position)
        if(item == null){
            return
        }
        holder.image.setImageResource(R.drawable.iconapp)
        holder.tvName.text = item.name
    }
}