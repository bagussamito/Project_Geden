package com.example.studikasus

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.FirebaseDatabase

class contekanJavagan : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val option_pemasukan = findViewById<Spinner>(R.id.kategori_pemasukan)
        val adapter: ArrayAdapter<*> = ArrayAdapter.createFromResource(this, R.array.kategori_pemasukan, R.layout.color_spinner_layout)
        adapter.setDropDownViewResource(R.layout.spinner_dropdown_layout)
        option_pemasukan.adapter = adapter
        option_pemasukan.onItemSelectedListener = this
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("Not yet implemented")
    }

    override fun onItemSelected(adapterView: AdapterView<*>, view: View, position: Int, id: Long) {
        Toast.makeText(this, adapterView.selectedItem.toString(), Toast.LENGTH_SHORT).show()
    }



    private fun deleteRecord(id: String) {
        val dbref = FirebaseDatabase.getInstance().getReference("Pemasukan").child(id)
        Toast.makeText(this, "Data Berhasil Dihapus", Toast.LENGTH_SHORT).show()
    }


}