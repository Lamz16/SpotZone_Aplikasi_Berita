package com.dicoding.spotzone

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.spotzone.databinding.ItemRowContentBinding

class ListContentAdapter(private val listContent: ArrayList<Content>) : RecyclerView.Adapter<ListContentAdapter.ListViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    class ListViewHolder(var binding: ItemRowContentBinding) : RecyclerView.ViewHolder(binding.root)

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListViewHolder {
        val binding =
            ItemRowContentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description, photo) = listContent[position]
        holder.binding.imgItemPhoto.setImageResource(photo)
        holder.binding.tvItemName.text = name
        holder.binding.tvItemDescription.text = description

        holder.itemView.setOnClickListener {
            val intentDetail = Intent(holder.itemView.context, DetailActivity::class.java)
            intentDetail.putExtra("key_content", listContent[holder.adapterPosition])
            holder.itemView.context.startActivity(intentDetail)

        }
    }

    override fun getItemCount(): Int = listContent.size


    interface OnItemClickCallback {
        fun onItemClicked(data: Content)
    }
}