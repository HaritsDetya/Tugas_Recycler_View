package com.example.tugas_recycler_view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tugas_recycler_view.databinding.ListPahlawanBinding

typealias OnClickPahlawan = (Pahlawan) -> Unit
class MyAdapter(private val listPahlawan: List<Pahlawan>, private val onClickDisaster: OnClickPahlawan)  :

    RecyclerView.Adapter<MyAdapter.ItemPahlawanViewHolder>() {
    inner class ItemPahlawanViewHolder(private val binding: ListPahlawanBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Pahlawan) {
            with(binding) {
                name.text = data.namaPahlawan
                image.setImageResource(data.gambarPahlawan)
                deskripsi.text = data.deskripsiPahlawan
                itemView.setOnClickListener {
                    onClickDisaster(data)
                }
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ItemPahlawanViewHolder {
        val binding = ListPahlawanBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemPahlawanViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemPahlawanViewHolder, position: Int) {
        holder.bind(listPahlawan[position])
    }

    override fun getItemCount(): Int = listPahlawan.size
}