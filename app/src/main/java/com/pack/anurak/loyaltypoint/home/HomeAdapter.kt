package com.pack.anurak.loyaltypoint.home

import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import com.pack.anurak.loyaltypoint.R

class HomeAdapter: BaseAdapter() {
    private val list = colors()
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val inflater = parent?.context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.item_list_view,null)
        val tv = view.findViewById<TextView>(R.id.tv_name)
        val card = view.findViewById<CardView>(R.id.item_list)

        tv.text = list[position].first
        card.setBackgroundColor(list[position].second)
        card.setOnClickListener {
            Toast.makeText(parent.context,
            "Clicked : ${list[position].first}", Toast.LENGTH_SHORT).show()
            val activity = parent.context as Activity
            val viewGroup = activity.findViewById<ViewGroup>(android.R.id.content)
                .getChildAt(0)
            viewGroup.setBackgroundColor(list[position].second)
        }

        Log.i("HomeAdapter","---P list size: "+list.size)
        Log.i("HomeAdapter","---P MOD: "+list.size%10)
        return  view
    }

    override fun getItem(position: Int): Any {
        return list[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return list.size % 10
    }
    // Custom method to generate list of color name value pair
    private fun colors():List<Pair<String,Int>>{
        return listOf(
            Pair("INDIANRED",Color.parseColor("#CD5C5C")),
            Pair("LIGHTCORAL",Color.parseColor("#F08080")),
            Pair("SALMON",Color.parseColor("#FA8072")),

            Pair("DARKSALMON",Color.parseColor("#E9967A")),
            Pair("LIGHTSALMON",Color.parseColor("#FFA07A")),
            Pair("CRIMSON",Color.parseColor("#DC143C")),

            Pair("RED",Color.parseColor("#FF0000")),
            Pair("FIREBRICK",Color.parseColor("#B22222")),
            Pair("DARKRED", Color.parseColor("#8B0000")),

            Pair("PINK",Color.parseColor("#FFC0CB")),
            Pair("LIGHTPINK",Color.parseColor("#FFB6C1")),
            Pair("HOTPINK",Color.parseColor("#FF69B4")),

            Pair("DEEPPINK",Color.parseColor("#FF1493")),
            Pair("MEDIUMVIOLETRED",Color.parseColor("#C71585")),
            Pair("PALEVIOLETRED",Color.parseColor("#DB7093")),

            Pair("Forest Green",Color.parseColor("#228b22")),
            Pair("Yellow Green",Color.parseColor("#9acd32")),
            Pair("Lime Green",Color.parseColor("#32cd32")),

            Pair("Green Yellow",Color.parseColor("#adff2f")),
            Pair("Light Sea Green",Color.parseColor("#20b2aa")),
            Pair("Medium Sea Green",Color.parseColor("#3cb371")),

            Pair("Sea Green",Color.parseColor("#2e8b57")),
            Pair("Aquamarine",Color.parseColor("#7fffd4")),
            Pair("Medium Aquamarine",Color.parseColor("#66cdaa")),

            Pair("Cyan",Color.parseColor("#00ffff")),
            Pair("Turquoise",Color.parseColor("#40e0d0")),
            Pair("Light Sky Blue",Color.parseColor("#87cefa")),

            Pair("Deep Sky Blue",Color.parseColor("#00bfff")),
//            Pair("Dodger Blue",Color.parseColor("#1e90ff")),
            Pair("Blue",Color.parseColor("#0000ff"))
        )
    }
}