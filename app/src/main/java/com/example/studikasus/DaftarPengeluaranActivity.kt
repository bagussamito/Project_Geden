package com.example.studikasus

import android.os.Bundle
import android.view.View
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.studikasus.data.Pengeluaran
import com.example.studikasus.fragments.adapters.AdapterPengeluaran
import com.google.firebase.database.*

class DaftarPengeluaranActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var ref : DatabaseReference
    private lateinit var listPengeluaran: ListView
    private lateinit var pengeluaranList: MutableList<Pengeluaran>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daftar_pengeluaran)

        listPengeluaran = findViewById(R.id.pengeluaran_list)

        ref = FirebaseDatabase.getInstance().getReference("Pengeluaran")

        pengeluaranList = mutableListOf()
        ref.addValueEventListener(object : ValueEventListener{
            override fun onCancelled(p0: DatabaseError) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onDataChange(p0: DataSnapshot) {
                if(p0.exists()){
                    pengeluaranList.clear()
                    for(h in p0.children){
                        val pengeluaran = h.getValue(Pengeluaran::class.java)
                        if (pengeluaran != null) {
                            pengeluaranList.add(pengeluaran)
                        }
                    }

                    val adapter = AdapterPengeluaran(this@DaftarPengeluaranActivity, R.layout.pemasukan_item, pengeluaranList)
                    listPengeluaran.adapter = adapter
                }
            }

        })
    }

    override fun onClick(v: View?) {
        TODO("Not yet implemented")
    }

}