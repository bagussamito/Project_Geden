package com.example.studikasus.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import com.example.studikasus.DialogPemasukanActivity
import com.example.studikasus.DialogPengeluaranActivity
import com.example.studikasus.R
import com.getbase.floatingactionbutton.FloatingActionButton

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
        val fabPengeluaran = view.findViewById(R.id.fab_pengeluaran) as FloatingActionButton
        val fabPemasukan = view.findViewById(R.id.fab_pemasukan) as FloatingActionButton
        fabPemasukan.setOnClickListener {
            val i = Intent(activity, DialogPemasukanActivity::class.java)
            startActivity(i)
        }
        fabPengeluaran.setOnClickListener {
            val i = Intent(activity, DialogPengeluaranActivity::class.java)
            startActivity(i)
        }
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


    }


}