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
    lateinit var etNominal : EditText
    lateinit var etDeskripsi : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialog_pemasukan)

        optionPemasukan = findViewById(R.id.kategori_pemasukan)
        tvkategoriPemasukan = findViewById(R.id.tv_kategori_pemasukan)
        etNominal = findViewById(R.id.et_nominal_pemasukan)
        etDeskripsi = findViewById(R.id.et_deskripsi_pemasukan)
        btnBatal = findViewById(R.id.btn_Cancel_pemasukan)
        btnKirim = findViewById(R.id.btn_Kirim_pemasukan)

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
        btnKirim.setOnClickListener {
            saveData()
        }
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        Toast.makeText(this, "Kategori Harus Dipilih", Toast.LENGTH_SHORT).show()
    }

    override fun onItemSelected(adapterView: AdapterView<*>, view: View, position: Int, id: Long) {
        Toast.makeText(this, adapterView.selectedItem.toString(), Toast.LENGTH_SHORT).show()
    }

    private fun saveData(){
        val nominal = etNominal.text.toString().trim()
        val deskripsi = etDeskripsi.text.toString().trim()
        val kategori = optionPemasukan.selectedItem.toString().trim()

        if (nominal.isEmpty()){
            etNominal.error = "Isi Nominal!"
            return
        }
        if (deskripsi.isEmpty()){
            etDeskripsi.error = "Isi Deskripsi!"
        }

        //val ref = FirebaseDatabase.getInstance().getReference("Pemasukan")
    }
}