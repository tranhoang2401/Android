package com.example.gmailapp

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.CheckBox
import android.widget.TextView
import androidx.cardview.widget.CardView
import java.util.Random


class CustomAdapter (var context: Context, var listItem : ArrayList<Item>) : BaseAdapter() {

    class MyViewHolder (row : View) {
        lateinit var tvFisrtName : TextView
        lateinit var tvName : TextView
        lateinit var tvInfo : TextView
        lateinit var tvTime : TextView
        lateinit var checked : CheckBox
        lateinit var cardView: CardView

        init {
            tvFisrtName = row.findViewById(R.id.tv_firstnameitem)
            tvName = row.findViewById(R.id.tv_name_item)
            tvInfo = row.findViewById(R.id.tv_info_item)
            tvTime = row.findViewById(R.id.tv_time_item)
            checked = row.findViewById(R.id.checked_item)
            cardView = row.findViewById(R.id.cardview_item)
        }
    }
    override fun getCount(): Int {
        return listItem.size
    }

    override fun getItem(p0: Int): Any {
        return listItem.get(p0)
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(position: Int, convertView: View?, p2: ViewGroup?): View {
        var view : View?
        var viewHolder : MyViewHolder
        if(convertView == null){
            var layoutInflater : LayoutInflater = LayoutInflater.from(context)
            view = layoutInflater.inflate(R.layout.item_mes, null)
            viewHolder = MyViewHolder(view)
            view.tag = viewHolder

        }else{
            view = convertView
            viewHolder = convertView.tag as MyViewHolder
        }
        var item : Item = getItem(position) as Item
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

        return view as View
    }
}