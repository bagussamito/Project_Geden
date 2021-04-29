package com.example.studikasus

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.studikasus.data.Pengeluaran
import com.google.firebase.database.FirebaseDatabase

class AddDialogPengeluaranActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    lateinit var optionPengeluaran : Spinner
    lateinit var tvkategoriPengeluaran : TextView
    lateinit var btnBatal : Button
    lateinit var btnKirim : Button
    lateinit var etNominal : EditText
    lateinit var etDeskripsi : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialog_pengeluaran)

        optionPengeluaran = findViewById(R.id.kategori_pengeluaran)
        etNominal = findViewById(R.id.et_nominal_pengeluaran)
        etDeskripsi = findViewById(R.id.et_deskripsi_pengeluaran)
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
        btnKirim.setOnClickListener{
            saveDataKeluar()
            }
    }


    override fun onNothingSelected(parent: AdapterView<*>?) {
        Toast.makeText(this, "Kategori Harus Dipilih", Toast.LENGTH_SHORT).show()
    }

    override fun onItemSelected(adapterView: AdapterView<*>, view: View?, position: Int, id: Long) {
        Toast.makeText(this, adapterView.selectedItem.toString(), Toast.LENGTH_SHORT).show()
    }

    private fun saveDataKeluar() {
        val nominal = etNominal.text.toString().trim()
        val deskripsi = etDeskripsi.text.toString().trim()
        val kategori = optionPengeluaran.selectedItem.toString().trim()

        if (nominal.isEmpty()){
            etNominal.error = "Isi Nominal!"
            return
        }
        if (deskripsi.isEmpty()){
            etDeskripsi.error = "Isi Deskripsi!"
        }
        if (kategori.isEmpty()){

        }

        val refkeluar = FirebaseDatabase.getInstance().getReference("Pengeluaran")

        val noId = refkeluar.push().key

        val Pengeluaran = Pengeluaran(noId, nominal, deskripsi, kategori)

        if (noId != null) {
            refkeluar.child(noId).setValue(Pengeluaran).addOnCompleteListener(){
                Toast.makeText(applicationContext, "Data berhasil ditambahkan", Toast.LENGTH_SHORT).show()
            }
        }
    }

}