package com.example.utspraktikumpember

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class ListMahasiswa(private val list: ArrayList<Mahasiswa>) : RecyclerView.Adapter<ListMahasiswa.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nama: TextView = itemView.findViewById(R.id.tvNama)
        val nim: TextView = itemView.findViewById(R.id.tvNim)
        val umur: TextView = itemView.findViewById(R.id.tvUmur)
        val foto: ImageView = itemView.findViewById(R.id.ivFoto)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.activity_card_view, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.nama.text = list[position].nama
        holder.nim.text = list[position].nim
        holder.umur.text = list[position].umur
        holder.foto.setImageResource(list[position].foto)
        holder.itemView.setOnClickListener {
            Toast.makeText(holder.itemView.context, list[position].nama, Toast.LENGTH_SHORT).show()
        }
    }

//    override fun onDetachedFromRecyclerView(recyclerView: RecyclerView) {
//        super.onDetachedFromRecyclerView(recyclerView)
//        foto.recycle()
//    }
}

