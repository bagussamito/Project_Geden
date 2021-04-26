package com.example.studikasus.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.studikasus.DialogPemasukanActivity
import com.example.studikasus.DialogPengeluaranActivity
import com.example.studikasus.R

/**
 * A simple [Fragment] subclass.
 */
class BerandaFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_beranda, container, false)
        val pemasukan_btn = view.findViewById(R.id.fab_pemasukan) as com.getbase.floatingactionbutton.FloatingActionButton
        val pengeluaran_btn = view.findViewById(R.id.fab_pengeluaran) as com.getbase.floatingactionbutton.FloatingActionButton
        pemasukan_btn.setOnClickListener {
            val i = Intent(activity, DialogPemasukanActivity::class.java)
            startActivity(i)
        }
        pengeluaran_btn.setOnClickListener {
            val i = Intent(activity, DialogPengeluaranActivity::class.java)
            startActivity(i)
        }
        return view
    }
}