package com.salsabilazahrasarwo.crud_mahasiswa_sqlite.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.salsabilazahrasarwo.crud_mahasiswa_sqlite.DetailMahasiswa
import com.salsabilazahrasarwo.crud_mahasiswa_sqlite.R
import com.salsabilazahrasarwo.crud_mahasiswa_sqlite.helper.DbHelper
import com.salsabilazahrasarwo.crud_mahasiswa_sqlite.model.ModelMahasiswa
import com.salsabilazahrasarwo.crud_mahasiswa_sqlite.screen_page.UpdateMahasiswaActivity

class MahasiswaAdapter (
    private var listMahasiswa: List<ModelMahasiswa>,
    val Context: Context

    ):RecyclerView.Adapter<MahasiswaAdapter.MahasiswaViewHolder>() {

        private val db : DbHelper = DbHelper(Context)

    class MahasiswaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val txtNama: TextView = itemView.findViewById(R.id.txtItemNama)
        val txtJurusan: TextView = itemView.findViewById(R.id.txtItemJurusan)
        val txtNim: TextView = itemView.findViewById(R.id.txtItemNim)

        val btnEdit : ImageView = itemView.findViewById(R.id.btnEditItem)
        val btnDelete : ImageView = itemView.findViewById(R.id.btnDeleteItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MahasiswaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.item_data_mahasiswa,
            parent, false
        )
        return MahasiswaViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listMahasiswa.size
    }

    override fun onBindViewHolder(holder: MahasiswaViewHolder, position: Int) {
        val nMahasiswa = listMahasiswa[position]
        holder.txtNim.text = nMahasiswa.nim.toString()
        holder.txtNama.text = nMahasiswa.nama
        holder.txtJurusan.text = nMahasiswa.jurusan

        holder.btnDelete.setOnClickListener() {
            db.deleteMahasiswa(nMahasiswa.id)
            refreshData(db.getAllDataMahasiswa())
            Toast.makeText(
                holder.itemView.context,
                "Berhasil delete data ${nMahasiswa.nama}", Toast.LENGTH_LONG
            ).show()
        }
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, DetailMahasiswa::class.java)
            intent.putExtra("nama", nMahasiswa.nama)
            intent.putExtra("jurusan", nMahasiswa.jurusan)
            intent.putExtra("nim", nMahasiswa.nim.toString())
            holder.itemView.context.startActivity(intent)
        }


        holder.btnEdit.setOnClickListener() {
            val intent = Intent(holder.itemView.context, UpdateMahasiswaActivity::class.java).apply{
                putExtra("id_mhs", nMahasiswa.id)
            }
            holder.itemView.context.startActivity(intent)
        }
    }


    //
    fun refreshData(newMahasiswa: List<ModelMahasiswa>) {
        listMahasiswa = newMahasiswa
        notifyDataSetChanged()


    }
}
