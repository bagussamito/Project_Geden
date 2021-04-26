package com.example.studikasus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class DialogPengeluaranActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    lateinit var optionPengeluaran : Spinner
    lateinit var tvkategoriPengeluaran : TextView
    lateinit var btnBatal : Button
    lateinit var btnKirim : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialog_pengeluaran)

        optionPengeluaran = findViewById(R.id.kategori_pengeluaran)
        tvkategoriPengeluaran = findViewById(R.id.tv_kategori_pengeluaran)
        btnBatal = findViewById(R.id.btn_Cancel_pengeluaran)
        btnKirim = findViewById(R.id.btn_Kirim_pengeluaran)

        val adapter: ArrayAdapter<*> = ArrayAdapter.createFromResource(
            this,
            R.array.kategori_pengeluaran,
            R.layout.color_spinner_layout
        )
        adapter.setDropDownViewResource(R.layout.spinner_dropdown_layout)
        optionPengeluaran.adapter = adapter
        optionPengeluaran.onItemSelectedListener = this

        //ketika button Batal diklik maka akan mengakhiri dialog
        btnBatal.setOnClickListener {
            finish()
        }
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        Toast.makeText(this, "Kategori Harus Dipilih", Toast.LENGTH_SHORT).show()
    }

    override fun onItemSelected(adapterView: AdapterView<*>, view: View?, position: Int, id: Long) {
        Toast.makeText(this, adapterView.selectedItem.toString(), Toast.LENGTH_SHORT).show()
    }
}