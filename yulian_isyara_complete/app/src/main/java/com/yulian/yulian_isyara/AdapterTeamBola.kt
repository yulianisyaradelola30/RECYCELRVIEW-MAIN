package com.yulian.yulian_isyara

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yulian.yulian_isyara.databinding.ListItemPemainBinding


class AdapterTeamBola (private val context : Context,
                        private var data : List<pemain>?,
                        private val itemClick : OnClickListener)
    : RecyclerView.Adapter<AdapterTeamBola.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterTeamBola.ViewHolder {
        val binding = ListItemPemainBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data?.get(position)
        holder.foto.setImageResource(item?.foto ?:0)
        holder.nama.text = item?.nama
        holder.itemView.setOnClickListener {
            itemClick.detailData(item)
    }
    }
    override fun getItemCount(): Int = data?.size ?: 0

    inner class ViewHolder(val binding : ListItemPemainBinding) : RecyclerView.ViewHolder(binding.root)    {
        var foto = binding.image
        var nama = binding.txtnama
    }

    interface OnClickListener {
        fun detailData(item : pemain?)
    }
}
