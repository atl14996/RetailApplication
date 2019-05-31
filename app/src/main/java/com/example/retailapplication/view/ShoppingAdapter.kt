package com.example.retailapplication.view

import android.content.Intent
import android.os.Bundle
import android.support.v7.view.menu.MenuView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.retailapplication.R
import com.example.retailapplication.model.ClothingList
import com.example.retailapplication.model.getList
import com.example.retailapplication.model.shoppingData
import kotlinx.android.synthetic.main.shopping_list_item.view.*
import java.io.File

class ShoppingAdapter (val shoppingList: ArrayList<ClothingList>): RecyclerView.Adapter<ShoppingAdapter.ViewHolder>() {


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


        fun bindJson(clothingList: ClothingList) {



            itemView.tvName.text = clothingList.ItemName
            itemView.tvDescription.text = clothingList.ItemDescription
            itemView.tvPrice.text = clothingList.Price.toString()
            Glide.with(itemView.getContext()).load(clothingList.UrlImage).into(itemView.imgImageView)

             itemView.setOnClickListener() {view -> onItemClicked(clothingList)}
        }

        fun onItemClicked(clothingList: ClothingList) {
            val bundle = Bundle()
            bundle.putString("name", clothingList.ItemName)
            bundle.putString("imageUrl", clothingList.UrlImage)
            bundle.putString("description", clothingList.ItemDescription)
            bundle.putDouble("price", clothingList.Price)
            val intent = Intent(itemView.context, ResultActivity::class.java)
            intent.putExtras(bundle)
            itemView.context.startActivity(intent)
        }

    }

        override fun onCreateViewHolder(viewGroup: ViewGroup, p1: Int): ViewHolder {


            return ViewHolder(
                LayoutInflater.from(viewGroup.context).inflate(
                    R.layout.shopping_list_item,
                    viewGroup,
                    false
                )
            )
        }

        override fun getItemCount(): Int {

            return shoppingList.size

        }

        override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

            viewHolder.bindJson(shoppingList.get(position))
        }





}