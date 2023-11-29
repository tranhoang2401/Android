package com.example.contactapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView


class ItemAdapter() : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    interface ClickContactListener{
        fun clickLn(id : Int)
        fun onItemLongClick(contact: Contact, view: View)
    }

    private lateinit var clickContactListener: ClickContactListener
    private lateinit var listItem : ArrayList<Contact>
    private lateinit var context : Context

    constructor(listItem : ArrayList<Contact>, context : Context, clickContactListener: ClickContactListener):this() {
        this.listItem = listItem
        this.context = context
        this.clickContactListener = clickContactListener
    }

    class ItemViewHolder(itemView : View): RecyclerView.ViewHolder(itemView){ // lớp dùng để gán / cập nhật dữ liệu vào các phần tử
        lateinit var tvfirstName : TextView
        lateinit var tvName : TextView
        lateinit var cardView: CardView
        lateinit var lnItem: LinearLayout
        init {
            tvName = itemView.findViewById(R.id.tvNameItem)
            tvfirstName = itemView.findViewById(R.id.tvFirstNameItem)
            cardView = itemView.findViewById(R.id.cardview)
            lnItem = itemView.findViewById(R.id.lnItem)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder { //tạo ra đối tượng ViewHolder, trong nó chứa View hiện thị dữ liệu
        return ItemViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_item, parent, false))
    }

    override fun getItemCount(): Int {
        return listItem.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) { //chuyển dữ liệu phần tử vào ViewHolder
        var contact = listItem.get(position)
        holder.tvName.text = contact.name
        holder.tvfirstName.text = contact.name[0].toUpperCase().toString()
        holder.lnItem.setOnClickListener {
            clickContactListener.clickLn(position)
        }
        holder.lnItem.setOnLongClickListener {
            clickContactListener.onItemLongClick(contact, it)
            true
        }
    }
}