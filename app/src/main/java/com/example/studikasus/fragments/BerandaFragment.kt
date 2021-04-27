package com.example.studikasus.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.studikasus.*
import com.example.studikasus.R
import com.getbase.floatingactionbutton.FloatingActionButton
import com.google.firebase.database.*

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
        val btnOpPemasukan = view.findViewById(R.id.option_pemasukan) as ImageButton
        val btnOpPengeluaran = view.findViewById(R.id.option_pengeluaran) as ImageButton
        val jmlPemasukan = view.findViewById(R.id.jml_pemasukan) as TextView
        val jmlPengeluaran = view.findViewById(R.id.jml_pengeluaran) as TextView
        val jmlSimpanan = view.findViewById(R.id.jml_simpanan) as TextView
        var DBPemasukan : DatabaseReference
        var DBPengeluaran : DatabaseReference

        DBPemasukan = FirebaseDatabase.getInstance().reference.child("Pemasukan")

        DBPemasukan.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                var sum = 0
                for (ds in dataSnapshot.children) {
                    val map: Map<String, Any>? =
                        ds.value as Map<String, Any>?
                    val nominal = map!!["nominal"]
                    val pValue: Int = java.lang.String.valueOf(nominal).toInt()
                    sum += pValue
                    jmlPemasukan.setText(sum.toString())
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {}
        })

        DBPengeluaran = FirebaseDatabase.getInstance().reference.child("Pengeluaran")

        DBPengeluaran.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                var sum = 0
                for (ds in dataSnapshot.children) {
                    val map: Map<String, Any>? =
                        ds.value as Map<String, Any>?
                    val nominal = map!!["nominal"]
                    val pValue: Int = java.lang.String.valueOf(nominal).toInt()
                    sum += pValue
                    jmlPengeluaran.setText(sum.toString())
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {}
        })

        btnOpPemasukan.setOnClickListener{
            val i = Intent(activity, DaftarPemasukanActivity::class.java)
            startActivity(i)
        }
        btnOpPengeluaran.setOnClickListener{
            val i = Intent(activity, DaftarPengeluaranActivity::class.java)
            startActivity(i)
        }

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

}