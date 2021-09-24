package com.example.recyclerviewretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ItemClicked {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView.layoutManager=LinearLayoutManager(this)
        val items=generateData()
        val adapter= DataAdapter(items,this)
        recyclerView.adapter=adapter
    }
    private fun generateData():ArrayList<String>
    {
        val list=ArrayList<String>()
        for(i in 0 until 100)
            list.add("Item $i")
        return list
    }

    override fun onItemClick(item: String) {
        Toast.makeText(this,"You clicked $item",Toast.LENGTH_LONG).show()
    }
}