package com.example.recyclerviewretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewretrofit.adapters.DataAdapter
import com.example.recyclerviewretrofit.adapters.ItemClicked
import com.example.recyclerviewretrofit.api.ApiSet
import com.example.recyclerviewretrofit.api.NameService
import com.example.recyclerviewretrofit.repository.NameDataRepository
import com.example.recyclerviewretrofit.viewModel.MainViewModel
import com.example.recyclerviewretrofit.viewModel.MainViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ItemClicked {

    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView.layoutManager=LinearLayoutManager(this)

        val nameService=NameService.apiSet

        val repository=NameDataRepository(nameService)

        mainViewModel= ViewModelProvider(this,MainViewModelFactory(repository)).get(MainViewModel::class.java)

        mainViewModel.names.observe(this, Observer {
            Log.d("checkdata",it.name.toString())
            val nameArr=it.name
            val adapter= DataAdapter(nameArr,this@MainActivity)
            recyclerView.adapter=adapter
        })

        //getNames()
        //val items=generateData()

    }
//
//    private fun getNames() {
//        val names=NameService.apiSet.getNames()
//        names.enqueue(object :Callback<Names>{
//            override fun onResponse(call: Call<Names>, response: Response<Names>) {
//                val nameArr=response.body()
//                val adapter= DataAdapter(nameArr!!.name,this@MainActivity)
//                recyclerView.adapter=adapter
//            }
//
//            override fun onFailure(call: Call<Names>, t: Throwable) {
//                TODO("Not yet implemented")
//            }
//        })
//    }

//    private fun generateData():ArrayList<String>
//    {
//        val list=ArrayList<String>()
//        for(i in 0 until 100)
//            list.add("Item $i")
//        return list
//    }

    override fun onItemClick(item: String) {
        Toast.makeText(this,"You clicked $item",Toast.LENGTH_LONG).show()
    }
}