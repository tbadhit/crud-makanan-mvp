package com.tbadhit.crudmakananmvp.ui.insert

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.tbadhit.crudmakananmvp.databinding.ActivityInsertBinding

class InsertActivity : AppCompatActivity(), InsertContract.View {

    // 1.
    private lateinit var binding : ActivityInsertBinding
    private lateinit var insertPresenter: InsertPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 1.
        binding = ActivityInsertBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 1.
        // Di ALT + ENTER 'this'nya lalu pilih 'Let InsertActivity implement Interface'
        insertPresenter = InsertPresenter(this)

        // 1.
        binding.btnInsert.setOnClickListener {

            val name = binding.edtNamaMakanan.text.toString()
            val price = binding.edtHargaMakanan.text.toString()
            val gambar = binding.edtUrlGambar.text.toString()


            // yang name price gambar di ALT + ENTER lalu pilih add parameter
            insertPresenter.insertDataMakanan(name, price, gambar)

        }
    }

    // 1.
    override fun showMessage(message: String?) {
        // 2.
        Toast.makeText(this, message,Toast.LENGTH_SHORT).show()
        finish()
    }

    // 1.
    override fun showError(s: String) {
        // 2.
        Toast.makeText(this, s,Toast.LENGTH_SHORT).show()
    }
}