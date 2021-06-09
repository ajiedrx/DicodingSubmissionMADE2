package com.example.dicodingsubmission2made.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.dicodingsubmission2made.core.injection.domain.model.Film
import com.example.dicodingsubmission2made.databinding.RvItemRowBinding
import kotlinx.android.synthetic.main.rv_item_row.view.*

class ItemListAdapter : RecyclerView.Adapter<ItemListAdapter.ListViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback
    private val itemList: ArrayList<Film> = ArrayList()

    companion object{
        private const val IMAGE_BASE_URL = "https://www.themoviedb.org/t/p/w600_and_h900_bestv2"
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvItemTitle: TextView = itemView.tv_item_name
        var tvItemGenre: TextView = itemView.tv_item_genre
        var poster: ImageView = itemView.img_item_photo
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListViewHolder {
        val view: View =
            RvItemRowBinding.inflate(LayoutInflater.from(parent.context), parent, false).root
        return ListViewHolder(view)
    }

    fun setData(items: ArrayList<Film>) {
        itemList.clear()
        itemList.addAll(items)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val anItem = itemList[position]

        holder.tvItemTitle.text = anItem.name
        holder.tvItemGenre.text = anItem.rating

        Glide.with(holder.itemView.context)
            .load(IMAGE_BASE_URL + anItem.poster)
            .into(holder.poster)

        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(itemList[holder.adapterPosition]) }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Film)
    }
}