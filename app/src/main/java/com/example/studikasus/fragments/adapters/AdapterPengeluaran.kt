package com.example.studikasus.fragments.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.studikasus.Item_Pengeluaran
import com.example.studikasus.R
import com.example.studikasus.fragments.adapters.AdapterPengeluaran.*

class AdapterPengeluaran(private val listPengeluaran : ArrayList<Item_Pengeluaran>): RecyclerView.Adapter<MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val pengeluaranView = LayoutInflater.from(parent.context).inflate(
                R.layout.pengeluaran_item,
                parent, false)
        return MyViewHolder(
                pengeluaranView
        )
    }

    override fun getItemCount(): Int {
        return listPengeluaran.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentitem = listPengeluaran[position]

        holder.kategori.text = currentitem.kategori
        holder.nominal.text = currentitem.nominal
        holder.deskripsi.text = currentitem.deskripsi
    }

    class  MyViewHolder(pengeluaranView : View) : RecyclerView.ViewHolder(pengeluaranView){


        val kategori : TextView = pengeluaranView.findViewById(R.id.kategoritext)
        val nominal : TextView = pengeluaranView.findViewById(R.id.totalnumber)
        val deskripsi : TextView = pengeluaranView.findViewById(R.id.deskripsitext)
    }
}