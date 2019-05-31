package com.example.retailapplication.view

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.Glide.get
import com.bumptech.glide.Glide.init
import com.bumptech.glide.GlideContext
import com.example.retailapplication.R
import kotlinx.android.synthetic.main.activity_result.*
import java.security.AccessController.getContext

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        init()


    }

    fun init(){

        val bundle = intent.extras

        tvItemName.text = bundle.getString("name", "")
        tvItemPrice.text = bundle.getDouble("price", 0.0).toString()
        tvItemDescription.text = bundle.getString("description", "")
        val UrlResource : String = bundle.getString("imageUrl","")
        Glide.with(this).load(UrlResource).into(imgItemImageView)

    }
}
