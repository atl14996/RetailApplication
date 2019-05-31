package com.example.retailapplication

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import com.example.retailapplication.model.ClothingList
import com.example.retailapplication.model.getList
import com.example.retailapplication.view.ShoppingAdapter
import kotlinx.android.synthetic.main.activity_main.*
import javax.sql.DataSource

class MainActivity : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var shoppingList = getList(this)
        shoppingResultList(shoppingList)



    }

     fun shoppingResultList(shoppingList : ArrayList<ClothingList>) {
       rvRecyclerView.layoutManager = GridLayoutManager(this,2)
        rvRecyclerView.adapter = ShoppingAdapter(shoppingList)



    }





}
