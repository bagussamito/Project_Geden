package com.example.studikasus

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class DialogPemasukanActivity: AppCompatActivity(), AdapterView.OnItemSelectedListener {

    lateinit var optionPemasukan : Spinner
    lateinit var tvkategoriPemasukan : TextView
    lateinit var btnBatal : Button
    lateinit var btnKirim : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialog_pemasukan)

        optionPemasukan = findViewById(R.id.kategori_pengeluaran)
        tvkategoriPemasukan = findViewById(R.id.tv_kategori_pengeluaran)
        btnBatal = findViewById(R.id.btn_Cancel_pengeluaran)
        btnKirim = findViewById(R.id.btn_Kirim_pengeluaran)

        val adapter: ArrayAdapter<*> = ArrayAdapter.createFromResource(
            this,
            R.array.kategori_pemasukan,
            R.layout.color_spinner_layout
        )
        adapter.setDropDownViewResource(R.layout.spinner_dropdown_layout)
        optionPemasukan.adapter = adapter
        optionPemasukan.onItemSelectedListener = this

        //ketika button Batal diklik maka akan mengakhiri dialog
        btnBatal.setOnClickListener {
            finish()
        }
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        Toast.makeText(this, "Kategori Harus Dipilih", Toast.LENGTH_SHORT).show()
    }

    override fun onItemSelected(adapterView: AdapterView<*>, view: View, position: Int, id: Long) {
        Toast.makeText(this, adapterView.selectedItem.toString(), Toast.LENGTH_SHORT).show()
    }
}