package com.example.studikasus.fragments.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.studikasus.Item_Pemasukan
import com.example.studikasus.R

class AdapterPemasukan (private val listPemasukan : ArrayList<Item_Pemasukan>): RecyclerView.Adapter<AdapterPemasukan.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val pemasukanView = LayoutInflater.from(parent.context).inflate(
            R.layout.pemasukan_item,
        parent, false)
        return MyViewHolder(
            pemasukanView
        )
    }

    override fun getItemCount(): Int {
        return listPemasukan.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentitem = listPemasukan[position]

        holder.kategori.text = currentitem.kategori
        holder.nominal.text = currentitem.nominal
        holder.deskripsi.text = currentitem.deskripsi

    }

    class  MyViewHolder(pemasukanView : View) : RecyclerView.ViewHolder(pemasukanView){

        val kategori : TextView = pemasukanView.findViewById(R.id.kategoritext)
        val nominal : TextView = pemasukanView.findViewById(R.id.totalnumber)
        val deskripsi : TextView = pemasukanView.findViewById(R.id.deskripsitext)
    }
}