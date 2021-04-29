package com.example.studikasus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.studikasus.fragments.adapters.AdapterPemasukan
import com.example.studikasus.fragments.adapters.AdapterPengeluaran
import com.google.firebase.database.*

class DaftarPengeluaranActivity : AppCompatActivity() {

    private lateinit var dbref : DatabaseReference
    private lateinit var pengeluaranRecyclerview : RecyclerView
    private lateinit var pengeluaranArraylist : ArrayList<Item_Pengeluaran>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daftar_pengeluaran)

        pengeluaranRecyclerview = findViewById(R.id.pengeluaran_list)
        pengeluaranRecyclerview.layoutManager = LinearLayoutManager(this)
        pengeluaranRecyclerview.setHasFixedSize(true)

        pengeluaranArraylist = arrayListOf()
        getUserData()
    }

    private fun getUserData() {
        dbref = FirebaseDatabase.getInstance().getReference("Pengeluaran")

        dbref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()){

                    for (pengeluaranSnapshot in snapshot.children){

                        val keluaran = pengeluaranSnapshot.getValue(Item_Pengeluaran::class.java)
                        pengeluaranArraylist.add(keluaran!!)
                    }
                    pengeluaranRecyclerview.adapter =
                            AdapterPengeluaran(
                                    pengeluaranArraylist
                            )
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
    }

}