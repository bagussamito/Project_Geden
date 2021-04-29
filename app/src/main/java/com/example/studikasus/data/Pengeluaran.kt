package com.example.studikasus.data

data class Pengeluaran(
        val noId : String?,
        val nominal : String,
        val deskripsi : String,
        val kategori : String
){
    constructor(): this("","","",""){
    }
}