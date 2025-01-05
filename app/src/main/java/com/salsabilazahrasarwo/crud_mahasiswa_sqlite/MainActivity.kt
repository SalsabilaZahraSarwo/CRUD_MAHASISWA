package com.salsabilazahrasarwo.crud_mahasiswa_sqlite

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.salsabilazahrasarwo.crud_mahasiswa_sqlite.adapter.MahasiswaAdapter
import com.salsabilazahrasarwo.crud_mahasiswa_sqlite.databinding.ActivityMainBinding
import com.salsabilazahrasarwo.crud_mahasiswa_sqlite.helper.DbHelper
import com.salsabilazahrasarwo.crud_mahasiswa_sqlite.screen_page.TambahDataMahasiswa

class MainActivity : AppCompatActivity() {
    private lateinit var  binding: ActivityMainBinding
    private lateinit var db: DbHelper
    private lateinit var  mahasiswaAdapter: MahasiswaAdapter




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = DbHelper(this)
        mahasiswaAdapter= MahasiswaAdapter(db.getAllDataMahasiswa(),this)

        binding.rvDataMahasiswa.layoutManager = LinearLayoutManager(this)
        binding.rvDataMahasiswa.adapter=mahasiswaAdapter


        //silahkan buat detail page
        //ketika di klik itemnya pindah ke item lain




        binding.btnTambah.setOnClickListener{
            val intent = Intent(this, TambahDataMahasiswa::class.java)
            startActivity(intent)

        }

        
    }
    override fun onResume(){
        super.onResume()
        val newMahasiswa = db.getAllDataMahasiswa()
        mahasiswaAdapter.refreshData(newMahasiswa)
    }
}