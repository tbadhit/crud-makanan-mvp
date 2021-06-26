package com.tbadhit.crudmakananmvp.ui.main

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tbadhit.crudmakananmvp.R
import com.tbadhit.crudmakananmvp.databinding.ItemRowMakananBinding
import com.tbadhit.crudmakananmvp.model.getMakanan.DataItem
import com.tbadhit.crudmakananmvp.ui.update.UpdateDeleteActivity

// 1.
class MakananAdapter : RecyclerView.Adapter<MakananAdapter.MyViewHolder>() {

    // 2.
    private var listMakanan = ArrayList<DataItem?>()

    // 2.
    fun setDataMakanan(dataMakanan: List<DataItem?>?) {
        if (dataMakanan == null) return
        this.listMakanan.clear()
        this.listMakanan.addAll(dataMakanan)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemRowMakananBinding = ItemRowMakananBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(itemRowMakananBinding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        // 2.
        val data = listMakanan[position]
        if (data != null) {
            holder.bind(data)
        }
    }

    override fun getItemCount(): Int = listMakanan.size

    class MyViewHolder(private val binding: ItemRowMakananBinding) : RecyclerView.ViewHolder(binding.root) {
        // 2.
        fun bind(dataMakanan: DataItem) {
            with(binding) {
                itemTvHarga.text = dataMakanan.menuHarga
                itemTvNama.text = dataMakanan.menuNama
                Glide.with(itemView.context)
                    .load(dataMakanan.menuGambar)
                    .error(R.mipmap.ic_launcher_round)
                    .into(itemImage)

                // 3. ketika carnya di klik akan di bawa ke halaman detail
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, UpdateDeleteActivity::class.java)
                    intent.putExtra("ID", dataMakanan.menuId)
                    itemView.context.startActivity(intent)
                }
            }
        }
    }
}
//-------