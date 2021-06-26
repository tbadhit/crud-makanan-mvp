package com.tbadhit.crudmakananmvp.ui.update

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.tbadhit.crudmakananmvp.R
import com.tbadhit.crudmakananmvp.databinding.ActivityUpdateDeleteBinding
import com.tbadhit.crudmakananmvp.model.detail.Data

// Bikin layout (Copas aja)
class UpdateDeleteActivity : AppCompatActivity(), UpdateDeleteContract.View {

    // 1
    private lateinit var updateDeletePresenter: UpdateDeletePresenter
    private lateinit var binding: ActivityUpdateDeleteBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 1.
        binding = ActivityUpdateDeleteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 1. Di ALT + ENTER 'this'nya lalu pilih 'Let UpdateDeleteActivity implement Interface'
        updateDeletePresenter = UpdateDeletePresenter(this)

        // 1.
        var id = intent.getStringExtra("ID")

        // 1. kalo idnya merah ALT + ENTER aja
        updateDeletePresenter.getDetailMakanan(id ?: "1")
    }

    // 1.
    override fun showMessageUpdate(message: String?) {
        Toast.makeText(this@UpdateDeleteActivity, message, Toast.LENGTH_SHORT).show()
        // di finish biar ketika btn di klik dia balik ke MainActivity lagi
        finish()
    }

    // 1.
    override fun showMessegeDelete(message: String?) {
        // 3.
        Toast.makeText(this@UpdateDeleteActivity, message, Toast.LENGTH_SHORT).show()
        // di finish biar ketika btn di klik dia balik ke MainActivity lagi
        finish()
    }

    // 1.
    override fun showError(localizedMessage: String?) {
        // 3.
        Toast.makeText(this@UpdateDeleteActivity, localizedMessage, Toast.LENGTH_SHORT).show()
    }

    // 1.
    override fun showDetailMakanan(data: Data) {
        // 2.
        binding.edtUpdateNama.setText(data.menuNama)
        binding.edtUpdateHarga.setText(data.menuHarga)
        binding.edtUpdateUrl.setText(data.menuGambar)
        Glide.with(this)
            .load(data.menuGambar)
            .error(R.mipmap.ic_launcher_round)
            .into(binding.imgUpdate)

        // 3.
        binding.btnDelete.setOnClickListener {
            // ALT + ENTER aja kalo merah lalu pilih add to parameter ''
            updateDeletePresenter.deleteMakanan(data.menuId.toString())
        }

        binding.btnUpdate.setOnClickListener {

            val name = binding.edtUpdateNama.text.toString()
            val price = binding.edtUpdateHarga.text.toString()
            val gambar = binding.edtUpdateUrl.text.toString()

            updateDeletePresenter.updateMakanan(data.menuId.toString(), name, price, gambar)
        }
    }
}