package com.example.studikasus

import android.os.Bundle
import android.view.View
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.studikasus.data.Pemasukan
import com.example.studikasus.fragments.adapters.AdapterPemasukan
import com.google.firebase.database.*

class DaftarPemasukanActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var ref : DatabaseReference
    private lateinit var listPemasukan: ListView
    private lateinit var pemasukanList: MutableList<Pemasukan>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daftar_pemasukan)

        listPemasukan = findViewById(R.id.pemasukan_list)

        ref = FirebaseDatabase.getInstance().getReference("Pemasukan")

        pemasukanList = mutableListOf()

        ref.addValueEventListener(object : ValueEventListener{
            override fun onCancelled(p0: DatabaseError) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onDataChange(p0: DataSnapshot) {
                if(p0.exists()){
                    pemasukanList.clear()
                    for(h in p0.children){
                        val pemasukan = h.getValue(Pemasukan::class.java)
                        if (pemasukan != null) {
                            pemasukanList.add(pemasukan)
                        }
                    }

                    val adapter = AdapterPemasukan(this@DaftarPemasukanActivity, R.layout.pemasukan_item, pemasukanList)
                    listPemasukan.adapter = adapter
                }
            }

        })
        }

    override fun onClick(v: View?) {
        TODO("Not yet implemented")
    }

}