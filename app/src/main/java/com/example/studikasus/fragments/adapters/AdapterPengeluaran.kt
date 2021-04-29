package com.example.studikasus.fragments.adapters

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.studikasus.R
import com.example.studikasus.data.Pengeluaran
import com.google.firebase.database.FirebaseDatabase


class AdapterPengeluaran(val mCtx : Context, val layoutResId : Int, val pengeluaranList: List<Pengeluaran>):
    ArrayAdapter<Pengeluaran>(mCtx, layoutResId, pengeluaranList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflater : LayoutInflater = LayoutInflater.from(mCtx)

        val view : View = layoutInflater.inflate(layoutResId, null)

        val kategori : TextView = view.findViewById(R.id.kategoritext)
        val nominal : TextView = view.findViewById(R.id.totalnumber)
        val deskripsi : TextView = view.findViewById(R.id.deskripsitext)
        val btnupdate : ImageButton = view.findViewById(R.id.update)
        val btnhapus : ImageButton = view.findViewById(R.id.delete)

        val pengeluaran = pengeluaranList[position]

        btnupdate.setOnClickListener{
            showUpdateDialog(pengeluaran)
        }
        btnhapus.setOnClickListener {
            val dbPengeluaran =  FirebaseDatabase.getInstance().getReference("Pengeluaran").child(pengeluaran.noId!!)
            dbPengeluaran.removeValue()
            Toast.makeText(mCtx, "Data berhasil dihapus", Toast.LENGTH_SHORT).show()
        }

        kategori.text = pengeluaran.kategori
        nominal.text = pengeluaran.nominal
        deskripsi.text = pengeluaran.deskripsi

        return view
    }

    private fun showUpdateDialog(pengeluaran: Pengeluaran) {
        val builder = AlertDialog.Builder(mCtx)
        builder.setTitle("Edit Data")

        val inflater = LayoutInflater.from(mCtx)
        val view = inflater.inflate(R.layout.update_dialog_pengeluaran, null)

        val etNominal = view.findViewById<EditText>(R.id.et_nominal_pengeluaran)
        val etDeskripsi = view.findViewById<EditText>(R.id.et_deskripsi_pengeluaran)
        val spKategori = view.findViewById<Spinner>(R.id.kategori_pengeluaran)

        etNominal.setText(pengeluaran.nominal)
        etDeskripsi.setText(pengeluaran.deskripsi)

        builder.setView(view)

        builder.setPositiveButton("Update"){p0,p1 ->
            val dbPengeluaran = FirebaseDatabase.getInstance().getReference("Pengeluaran")

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

            val pengeluaran = Pengeluaran(pengeluaran.noId, nominal, deskripsi, kategori)

            dbPengeluaran.child(pengeluaran.noId!!).setValue(pengeluaran)

            Toast.makeText(mCtx, "Data berhasil di update", Toast.LENGTH_SHORT).show()
        }
        builder.setNegativeButton("Batal"){p0,p1 ->

        }
        val alert = builder.create()
        alert.show()
    }
}
