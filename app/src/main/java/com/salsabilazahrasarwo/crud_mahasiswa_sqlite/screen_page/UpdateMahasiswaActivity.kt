package com.salsabilazahrasarwo.crud_mahasiswa_sqlite.screen_page

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.salsabilazahrasarwo.crud_mahasiswa_sqlite.R
import com.salsabilazahrasarwo.crud_mahasiswa_sqlite.databinding.ActivityUpdateMhsBinding
import com.salsabilazahrasarwo.crud_mahasiswa_sqlite.helper.DbHelper
import com.salsabilazahrasarwo.crud_mahasiswa_sqlite.model.ModelMahasiswa

class UpdateMahasiswaActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUpdateMhsBinding
    private lateinit var db: DbHelper
    private var mhsId: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateMhsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = DbHelper(this)

        mhsId = intent.getIntExtra("id_mhs", -1)
        if (mhsId == -1) {
            finish()
            return
        }

        val mhs = db.getMhsById(mhsId)
        binding.etEditNama.setText(mhs.nama)
        binding.etEditNIM.setText(mhs.nim.toString())
        binding.etEditJurusan.setText(mhs.jurusan)


        binding.btnEditMhs.setOnClickListener() {
            val newNama = binding.etEditNama.text.toString()
            val newNIM = binding.etEditNIM.text.toString()
            val newJurusan = binding.etEditJurusan.text.toString()

            val updateMhs = ModelMahasiswa(mhsId, newNama, newNIM.toInt(), newJurusan)
            db.updateMahasiswa(updateMhs)
            finish()
            Toast.makeText(this, "Update Succes", Toast.LENGTH_LONG).show()
        }
    }
}