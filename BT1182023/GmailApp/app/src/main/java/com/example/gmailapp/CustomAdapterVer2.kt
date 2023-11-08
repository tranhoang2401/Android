package com.example.gmailapp

import android.content.Context
import android.graphics.Color
import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import java.util.Random

class CustomAdapterVer2() : RecyclerView.Adapter<CustomAdapterVer2.MyViewHolderVer2>() {
    private lateinit var listItem : ArrayList<Item>
    private lateinit var context : Context
    constructor(listItem : ArrayList<Item>, context : Context) : this() {
        this.listItem = listItem
        this.context = context
    }
    class MyViewHolderVer2(itemView: View) : RecyclerView.ViewHolder(itemView){
        lateinit var tvFisrtName : TextView
        lateinit var tvName : TextView
        lateinit var tvInfo : TextView
        lateinit var tvTime : TextView
        lateinit var checked : CheckBox
        lateinit var cardView: CardView
        init {
            tvFisrtName = itemView.findViewById(R.id.tv_firstnameitem)
            tvName = itemView.findViewById(R.id.tv_name_item)
            tvInfo = itemView.findViewById(R.id.tv_info_item)
            tvTime = itemView.findViewById(R.id.tv_time_item)
            checked = itemView.findViewById(R.id.checked_item)
            cardView = itemView.findViewById(R.id.cardview_item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolderVer2 {
        return MyViewHolderVer2(LayoutInflater.from(parent.context).inflate(R.layout.item_mes, parent, false))
    }

    override fun getItemCount(): Int {
        return listItem.size
    }

    override fun onBindViewHolder(viewHolder: MyViewHolderVer2, position: Int) {
        var item : Item = listItem.get(position)
        if(item==null){
            return
        }
        viewHolder.tvName.text = item.name
        viewHolder.tvInfo.text = item.info
        viewHolder.tvTime.text = item.time
        viewHolder.checked.setOnClickListener {
            listItem[position].checked = (it as CheckBox).isChecked
            notifyDataSetChanged()
        }
        viewHolder.tvFisrtName.text = item.name[0].toUpperCase().toString()

        val random = Random()
        val red: Int = random.nextInt(256)
        val green: Int = random.nextInt(256)
        val blue: Int = random.nextInt(256)
        val randomColor = Color.rgb(red, green, blue)
        viewHolder.cardView.setCardBackgroundColor(randomColor)
    }
}