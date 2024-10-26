package com.bybitmedia.wallhub.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bybitmedia.wallhub.R
import com.bumptech.glide.Glide
import com.bybitmedia.wallhub.Model.catModel
import java.util.ArrayList

class CatAdapter(val requireContext: Context, val listOfcat: ArrayList<catModel>) : RecyclerView.Adapter<CatAdapter.bomViewHolder>(){
    inner class bomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView = itemView.findViewById<ImageView>(R.id.cat_image)
        val name = itemView.findViewById<TextView>(R.id.cat_name)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): bomViewHolder {
        return bomViewHolder(

            LayoutInflater.from(requireContext).inflate(R.layout.item_cat, parent, false)
        )
    }

    override fun onBindViewHolder(
        holder: bomViewHolder,
        position: Int
    ) {
        holder.name.text = listOfcat[position].name
        Glide.with(requireContext).load(listOfcat[position].link).into(holder.imageView)

    }
 
    override fun getItemCount() = listOfcat.size


}