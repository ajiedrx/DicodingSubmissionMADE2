package com.example.dicodingsubmission2made.presentation.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.dicodingsubmission2made.core.injection.data.entities.FilmEntity
import com.example.dicodingsubmission2made.databinding.RvItemRowBinding
import kotlinx.android.synthetic.main.rv_item_row.view.*

class GeneralPagedListAdapter : PagingDataAdapter<FilmEntity, GeneralPagedListAdapter.ListViewHolder>(REPO_COMPARATOR) {

    private lateinit var onItemClickCallback: OnItemClickCallback

    companion object {
        private val REPO_COMPARATOR = object : DiffUtil.ItemCallback<FilmEntity>() {
            override fun areItemsTheSame(oldItem: FilmEntity, newItem: FilmEntity): Boolean =
                oldItem.film_id == newItem.film_id

            @SuppressLint("DiffUtilEquals")
            override fun areContentsTheSame(oldItem: FilmEntity, newItem: FilmEntity): Boolean =
                oldItem == newItem
        }

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

    override fun getItemCount(): Int {
        return super.getItemCount()
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val anItem = getItem(position)

        holder.tvItemTitle.text = anItem?.name
        holder.tvItemGenre.text = anItem?.rating.toString()

        Glide.with(holder.itemView.context)
            .load(IMAGE_BASE_URL + anItem?.poster)
            .into(holder.poster)

        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(getItem(holder.adapterPosition)!!) }
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: FilmEntity)
    }
}