package com.bybitmedia.wallhub.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bybitmedia.wallhub.Model.bomModel
import com.bybitmedia.wallhub.R
import com.bumptech.glide.Glide

class BomAdapter(val requireContext: Context, val listBestofThemonth: ArrayList<bomModel>) : RecyclerView.Adapter<BomAdapter.bomViewHolder>(){
    inner class bomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView = itemView.findViewById<ImageView>(R.id.bom_image)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): bomViewHolder {
        return bomViewHolder(

            LayoutInflater.from(requireContext).inflate(R.layout.item_bom, parent, false)
        )
    }

    override fun onBindViewHolder(
        holder: bomViewHolder,
        position: Int
    ) {
        Glide.with(requireContext).load(listBestofThemonth[position].link).into(holder.imageView)

    }
 
    override fun getItemCount() = listBestofThemonth.size


}