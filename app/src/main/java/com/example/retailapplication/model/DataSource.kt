package com.example.retailapplication.model

import android.content.Context
import android.content.res.Resources
import android.support.annotation.RawRes
import com.example.retailapplication.MainActivity
import com.example.retailapplication.R
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.annotations.SerializedName
import com.google.gson.reflect.TypeToken
import java.io.BufferedReader
import java.io.InputStreamReader
import java.security.AccessController.getContext

val shoppingData = """
    {"results":[{ "ItemName":"Red Tee Shirt", "ItemDescription":"With this red tee you will attract lots of attention and will surely be the most popular person at the party", "Price":49.99, "UrlImage":"https://images.pexels.com/photos/795810/pexels-photo-795810.jpeg?cs=srgb&dl=apparel-facebook-farm-795810.jpg&fm=jpg" },
{ "ItemName":"Black T-Shirt", "ItemDescription":"Styled to be plain in appearance, this tee will accenuate your most attrctive features", "Price":49.99, "UrlImage":"https://svgsilh.com/svg/303371.svg"},
{ "ItemName":"Blue T-Shirt","ItemDescription":"With its Christian theme and stylish looks, this shirt give praise to the Most High One" ,"Price":79.99,"UrlImage":"https://setfreeapparel.com/wp-content/uploads/2015/11/set-free-mens-christian-tshirt_02.jpg"},
{ "ItemName":"Green T-Shirt","ItemDescription":"The athletic outline is perfect for men who like to enjoy the summer" ,"Price":29.99,"UrlImage":"https://setfreeapparel.com/wp-content/uploads/2015/11/set-free-mens-christian-tshirt_02.jpg"},
{"ItemName":"Blue Polo Shirt","ItemDescription":"Perfect for casual and more formal occasions, this polo is both a good fit for men who don't mind being casual" ,"Price":99.99,"UrlImage":"https://cdn.pixabay.com/photo/2013/07/13/14/07/apparel-162180_960_720.png"},
{"ItemName":"Gloves","ItemDescription":"These gloves will protect you from the cold wether in fashion.  You'll stay warm through the winter months" ,"Price":129.99,"UrlImage":"https://cdn.pixabay.com/photo/2016/02/11/20/21/mens-leather-gloves-1194450_960_720.jpg"},
{"ItemName":"Men's Hat","ItemDescription":"For men with style and who practice discretion, this hat is the toast of the party." ,"Price":179.49,"UrlImage":"https://svgsilh.com/svg/310050.svg"},
{"ItemName":"Black Mens Hat","ItemDescription":"A less formal hat that dignifies the wearer with protection from outside elements" ,"Price":79.99,"UrlImage":"https://svgsilh.com/svg/304059.svg"},
{"ItemName":"Yellow Woman's Dress","ItemDescription":"Beautiful and fashionable, this dress screams summer.  Perfect for formal and less formal events" ,"Price":499.99,"UrlImage":"https://c.pxhere.com/photos/cc/1a/beautiful_cute_dress_fashion_fashion_model_fashionable_girl_model-1532849.jpg!d"},
{"ItemName":"Green Woman's Hijab","ItemDescription":"Made of silk, a strong yet delicate material, this piece will keep the wearer cool in the summer while getting all of the attention" ,"Price":99.99,"UrlImage":"https://c.pxhere.com/photos/d5/67/adorable_adult_bag_beautiful_beautiful_girl_beauty_cute_dress-1515217.jpg!d"},
{"ItemName":"Men's Sunglasses","ItemDescription":"Cool and sophisticated, these sunglasses offer maximum protection for harmful UV rays while offering a level of discretion" ,"Price":459.99,"UrlImage":"https://svgsilh.com/svg/746125.svg"},
{"ItemName":"Women's Scarf","ItemDescription":"Anyone who's survived a hard winter knows it's tough to keep warm.  You won't feel that way with this scarf" ,"Price":299.99,"UrlImage":"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTK_FtA5ot2kx2rFktn0gM_7dGU5sw6IeTs9p_Cjq4VJ3nd512vdw"},
{"ItemName":"Saree","ItemDescription":"This piece is imported from Bangladesh" ,"Price":699.99,"UrlImage":"https://c.pxhere.com/photos/49/f7/saree_indian_ethnic_clothing_fashion_silk_dress_woman-887932.jpg!d"},
{"ItemName":"Boxer Shorts","ItemDescription":"Fashionable and luxurious, your boxer shorts will make her howl at the moon" ,"Price":64.99,"UrlImage":"https://upload.wikimedia.org/wikipedia/commons/thumb/7/76/Webboxershorts_%28_weite_boxershorts_%29_2013-11-26_19-51.jpg/800px-Webboxershorts_%28_weite_boxershorts_%29_2013-11-26_19-51.jpg"},
{"ItemName":"Black Socks","ItemDescription":"12 per pack" ,"Price":34.99,"UrlImage":"https://svgsilh.com/svg/305782.svg"}]}
"""






         data class ClothingList(
             @SerializedName("ItemName")
             val ItemName: String,
             @SerializedName("ItemDescription")
             val ItemDescription: String,
             @SerializedName("Price")
             val Price: Double,
             @SerializedName("UrlImage")
             val UrlImage: String
         )






    fun getList(context: Context): ArrayList<ClothingList> {


        var gson = Gson()

        val groupListType = object : TypeToken<ArrayList<ClothingList>>() {}.type


        val JsonReturn = getJson(context)

        var FinalShoppingList: ArrayList<ClothingList> = gson.fromJson(JsonReturn, groupListType)

        return FinalShoppingList


    }

fun getJson(context: Context): String {

    val text = context.getResources().openRawResource(R.raw.data)
        .bufferedReader().use { it.readText() }

    return text
}

