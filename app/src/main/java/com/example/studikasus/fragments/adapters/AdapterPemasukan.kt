package com.example.studikasus.fragments.adapters

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.studikasus.R
import com.example.studikasus.data.Pemasukan
import com.google.firebase.database.FirebaseDatabase


class AdapterPemasukan(val mCtx : Context, val layoutResId : Int, val pemasukanList: List<Pemasukan>):
    ArrayAdapter<Pemasukan>(mCtx, layoutResId, pemasukanList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflater : LayoutInflater = LayoutInflater.from(mCtx)

        val view : View = layoutInflater.inflate(layoutResId, null)

        val kategori : TextView = view.findViewById(R.id.kategoritext)
        val nominal : TextView = view.findViewById(R.id.totalnumber)
        val deskripsi : TextView = view.findViewById(R.id.deskripsitext)
        val btnupdate : ImageButton = view.findViewById(R.id.update)
        val btnhapus : ImageButton = view.findViewById(R.id.delete)

        val pemasukan = pemasukanList[position]

        btnupdate.setOnClickListener{
            showUpdateDialog(pemasukan)
        }
        btnhapus.setOnClickListener {
            val dbPemasukan =  FirebaseDatabase.getInstance().getReference("Pemasukan").child(pemasukan.noId!!)
            dbPemasukan.removeValue()
            Toast.makeText(mCtx, "Data berhasil dihapus", Toast.LENGTH_SHORT).show()
        }

        kategori.text = pemasukan.kategori
        nominal.text = pemasukan.nominal
        deskripsi.text = pemasukan.deskripsi

        return view
    }

    private fun showUpdateDialog(pemasukan: Pemasukan) {
        val builder = AlertDialog.Builder(mCtx)
        builder.setTitle("Edit Data")

        val inflater = LayoutInflater.from(mCtx)
        val view = inflater.inflate(R.layout.update_dialog_pemasukan, null)

        val etNominal = view.findViewById<EditText>(R.id.et_nominal_pemasukan)
        val etDeskripsi = view.findViewById<EditText>(R.id.et_deskripsi_pemasukan)
        val spKategori = view.findViewById<Spinner>(R.id.kategori_pemasukan)

        etNominal.setText(pemasukan.nominal)
        etDeskripsi.setText(pemasukan.deskripsi)

        builder.setView(view)

        builder.setPositiveButton("Update"){p0,p1 ->
            val dbPemasukan = FirebaseDatabase.getInstance().getReference("Pemasukan")

            val nominal = etNominal.text.toString().trim()
            val deskripsi = etDeskripsi.text.toString().trim()
            val kategori = spKategori.selectedItem.toString().trim()

            if (nominal.isEmpty()){
                etNominal.error = "Mohon nama di iisi"
                etNominal.requestFocus()
                return@setPositiveButton
            }

            if (deskripsi.isEmpty()){
                etDeskripsi.error = "Mohon alamat diisi"
                etDeskripsi.requestFocus()
                return@setPositiveButton
            }

            val pemasukan = Pemasukan(pemasukan.noId, nominal, deskripsi, kategori)

            dbPemasukan.child(pemasukan.noId!!).setValue(pemasukan)

            Toast.makeText(mCtx, "Data berhasil di update", Toast.LENGTH_SHORT).show()
        }
        builder.setNegativeButton("Batal"){p0,p1 ->

        }
        val alert = builder.create()
        alert.show()
    }
}
