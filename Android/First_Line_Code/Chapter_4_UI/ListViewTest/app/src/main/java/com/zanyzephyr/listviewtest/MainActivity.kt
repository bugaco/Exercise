package com.zanyzephyr.listviewtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

//    private val data = listOf("Apple", "Banana", "Orange", "Watermelon",
//            "Pear", "Grape", "Pineapple", "Strawberry",
//            "Cherry", "Mango", "Apple", "Banana", "Orange", "Watermelon",
//            "Pear", "Grape", "Pineapple", "Strawberry",
//            "Cherry", "Mango","Apple", "Banana", "Orange", "Watermelon",
//            "Pear", "Grape", "Pineapple", "Strawberry",
//            "Cherry", "Mango")

    private val fruitList = ArrayList<Fruit>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initFruits()
        val adapter = FruitAdapter(this, R.layout.fruit_item, fruitList)
        listView.adapter = adapter
        listView.setOnItemClickListener { _, _, position, _ ->
            val fruit = fruitList[position]
            Toast.makeText(this, fruit.name, Toast.LENGTH_LONG).show()
        }

    }

    private fun initFruits() {
        repeat(2) {
            fruitList.apply {
                add(Fruit("Apple", R.drawable.apple_pic))
                add(Fruit("Banana", R.drawable.banana_pic))
                add(Fruit("Orange", R.drawable.orange_pic))
                add(Fruit("Watermelon", R.drawable.watermelon_pic))
                add(Fruit("Pear", R.drawable.pear_pic))
                add(Fruit("Grape", R.drawable.grape_pic))
                add(Fruit("Pineapple", R.drawable.pineapple_pic))
                add(Fruit("Strawberry", R.drawable.strawberry_pic))
                add(Fruit("Cherry", R.drawable.cherry_pic))
                add(Fruit("Mango", R.drawable.mango_pic))
            }
        }
    }
}
