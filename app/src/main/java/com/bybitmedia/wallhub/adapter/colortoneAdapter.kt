package com.bybitmedia.wallhub.adapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bybitmedia.wallhub.R
import com.bumptech.glide.Glide
import com.bybitmedia.wallhub.Model.colortoneModel
import java.util.ArrayList

class colortoneAdapter(val requireContext: Context, val listThecolortone: ArrayList<colortoneModel>) : RecyclerView.Adapter<colortoneAdapter.bomViewHolder>(){
    inner class bomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cardBack = itemView.findViewById<CardView>(R.id.item_card)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): bomViewHolder {
        return bomViewHolder(

            LayoutInflater.from(requireContext).inflate(R.layout.item_colortone, parent, false)
        )
    }

    override fun onBindViewHolder(
        holder: bomViewHolder,
        position: Int
    ) {

        val color = listThecolortone[position].color
        holder.cardBack.setCardBackgroundColor(Color.parseColor(color!!))

    }
 
    override fun getItemCount() = listThecolortone .size


}