package com.salsabilazahrasarwo.crud_mahasiswa_sqlite

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.salsabilazahrasarwo.crud_mahasiswa_sqlite.model.ModelMahasiswa

class DetailMahasiswa : AppCompatActivity() {

    private lateinit var txtdetailnama : TextView
    private lateinit var txtdetailnim : TextView
    private lateinit var txtdetailjurusan : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail_mahasiswa)

        txtdetailnama = findViewById(R.id.txtdetailnama)
        txtdetailnim = findViewById(R.id.txtdetailnim)
        txtdetailjurusan = findViewById(R.id.txtdetailjurus)

        val DetailNama = intent.getStringExtra("nama")
        val DetailNim = intent.getStringExtra("nim")
        val DetailJurusan = intent.getStringExtra("jurusan")

        txtdetailnama.text = DetailNama ?: "Nama tidak tersedia"
        txtdetailnim.text = DetailNim ?: "NIM tidak tersedia"
        txtdetailjurusan.text = DetailJurusan ?: "Jurusan tidak tersedia"


    }
}