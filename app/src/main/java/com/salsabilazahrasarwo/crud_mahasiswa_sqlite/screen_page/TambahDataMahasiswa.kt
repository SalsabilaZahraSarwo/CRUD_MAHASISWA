package com.salsabilazahrasarwo.crud_mahasiswa_sqlite.screen_page

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.salsabilazahrasarwo.crud_mahasiswa_sqlite.databinding.ActivityTambahDataMahasiswaBinding
import com.salsabilazahrasarwo.crud_mahasiswa_sqlite.helper.DbHelper
import com.salsabilazahrasarwo.crud_mahasiswa_sqlite.model.ModelMahasiswa

class TambahDataMahasiswa : AppCompatActivity() {

    //binding : cara cepat gradel deklarasi
    private lateinit var binding: ActivityTambahDataMahasiswaBinding
    private lateinit var db: DbHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTambahDataMahasiswaBinding.inflate(layoutInflater)
        setContentView(binding.root)


        db = DbHelper(this)
        binding.btnTambahData.setOnClickListener {
            val nama = binding.txtInputNama.text.toString()
            val nim = binding.txtInputNim.text.toString()

            //karena nim --> int jadi kita perlu convert dari string ke int
            //toInt()
            val dataMahasiswa = ModelMahasiswa(0, nama, nim.toInt(), "Teknik Komputer")
            db.insertDataMahasiswa(dataMahasiswa)
            finish();
            Toast.makeText(
                this, "Berhasil Tambah Data",
                Toast.LENGTH_LONG).show()
        }
    }
}