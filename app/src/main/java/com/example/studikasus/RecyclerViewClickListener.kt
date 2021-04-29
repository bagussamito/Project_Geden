package com.example.studikasus

import android.view.View

interface RecyclerViewClickListener {
    fun onRecyclerViewItemClicked(view: View, pemasukan: Pemasukan)
}