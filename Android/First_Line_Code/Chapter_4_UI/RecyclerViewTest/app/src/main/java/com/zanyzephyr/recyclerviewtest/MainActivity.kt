package com.zanyzephyr.recyclerviewtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val fruitList = ArrayList<Fruit>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initFruits()

//        val layoutManager = LinearLayoutManager(this)
//        layoutManager.orientation = LinearLayoutManager.HORIZONTAL

//        val layoutManager = StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)
//        recyclerView.layoutManager = layoutManager

        val layoutManager = GridLayoutManager(this, 3)
        layoutManager.orientation = GridLayoutManager.VERTICAL
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = FruitAdapter(fruitList)
    }

    private fun initFruits() {
        repeat(5) {
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
