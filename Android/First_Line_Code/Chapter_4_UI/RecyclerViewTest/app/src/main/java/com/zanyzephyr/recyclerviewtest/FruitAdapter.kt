package com.zanyzephyr.recyclerviewtest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class FruitAdapter(private val fruitList: List<Fruit>): RecyclerView.Adapter<FruitAdapter.ViewHolder>() {
    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val fruitImage: ImageView = view.findViewById(R.id.fruitImage)
        val fruitName: TextView = view.findViewById(R.id.fruitName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fruit_item, parent, false)
        val holder = ViewHolder(view)

        // 注册点击事件
        holder.itemView.setOnClickListener {
            val position = holder.adapterPosition
            val fruit = fruitList[position]
            Toast.makeText(parent.context, "You clicked view ${fruit.name}", Toast.LENGTH_SHORT).show()
        }
        holder.fruitImage.setOnClickListener {
            val position = holder.adapterPosition
            val fruit = fruitList[position]
            Toast.makeText(parent.context, "You clicked image ${fruit.name}", Toast.LENGTH_SHORT).show()
        }

        return holder
    }

    override fun getItemCount(): Int = fruitList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val fruit = fruitList[position]
        holder.apply {
            fruitImage.setImageResource(fruit.imageId)
            fruitName.text = fruit.name
        }
    }
}