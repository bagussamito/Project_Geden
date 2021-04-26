package com.example.studikasus

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_dialog_pemasukan.*

class DialogActivity: AppCompatActivity(), View.OnClickListener {

    val kategori = arrayOf("Gaji","Bonus","Lainnya")
    private lateinit var etNominal : EditText
    private lateinit var etDeskripsi : EditText
    private lateinit var spKategori : Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialog_pemasukan)

        val arrayAdapter = ArrayAdapter(this@DialogActivity,android.R.layout.simple_spinner_dropdown_item,kategori)
        kategori_pemasukan.adapter = arrayAdapter
        kategori_pemasukan.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                Toast.makeText(this@DialogActivity,"Anda Memilih Kategori"+kategori[position],Toast.LENGTH_LONG)
            }
        }

        etNominal = findViewById(R.id.et_nominal_pemasukan)
        etDeskripsi = findViewById(R.id.et_deskripsi_pemasukan)
        spKategori = findViewById(R.id.kategori_pemasukan)
    }

    override fun onClick(v: View?) {
        saveData()
    }

    private fun saveData(){
        val nominal = etNominal.text.toString().trim()
        val deskripsi = etDeskripsi.text.toString().trim()
        val kategori = spKategori.selectedItem.toString().trim()

        if (nominal.isEmpty()){
            etNominal.error = "Isi Nominal!"
            return
        } if (deskripsi.isEmpty()){
            etDeskripsi.error = "Isi Deskripsi!"
        }

        val ref = FirebaseDatabase.getInstance().getReference("Pemasukan")
    }

}