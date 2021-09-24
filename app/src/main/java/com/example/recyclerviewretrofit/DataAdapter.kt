package com.example.recyclerviewretrofit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList

class DataAdapter(private val datas:ArrayList<String>,private val listner:ItemClicked) : RecyclerView.Adapter<Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.item,parent,false)
        val viewHolder=Holder(view)
        view.setOnClickListener{
            listner.onItemClick(datas[viewHolder.adapterPosition])
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val currentData=datas[position]
        holder.itemTitle.text=currentData
    }

    override fun getItemCount(): Int {
      return datas.size
    }
}

class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val itemTitle : TextView=itemView.findViewById(R.id.textView)
}

interface ItemClicked{
    fun onItemClick(item:String)
}