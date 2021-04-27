package com.example.studikasus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*

class DaftarPemasukanActivity : AppCompatActivity() {

    private lateinit var dbref : DatabaseReference
    private lateinit var pemasukanRecyclerview : RecyclerView
    private lateinit var pemasukanArraylist : ArrayList<Item_Pemasukan>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daftar_pemasukan)

        pemasukanRecyclerview = findViewById(R.id.pemasukan_list)
        pemasukanRecyclerview.layoutManager = LinearLayoutManager(this)
        pemasukanRecyclerview.setHasFixedSize(true)

        pemasukanArraylist = arrayListOf()
        getUserData()
    }

    private fun getUserData() {
        dbref = FirebaseDatabase.getInstance().getReference("Pemasukan")

        dbref.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()){

                    for (pemasukanSnapshot in snapshot.children){

                        val masukan = pemasukanSnapshot.getValue(Item_Pemasukan::class.java)
                        pemasukanArraylist.add(masukan!!)
                    }
                    pemasukanRecyclerview.adapter = MyAdapter(pemasukanArraylist)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
    }
}