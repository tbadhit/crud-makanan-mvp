package com.tbadhit.crudmakananmvp.ui.register

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.tbadhit.crudmakananmvp.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity(), RegisterContact.View {

    private lateinit var binding: ActivityRegisterBinding
    private lateinit var registerPresenter: RegisterPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        registerPresenter = RegisterPresenter(this)

        binding.btnRegister.setOnClickListener {

            val name = binding.edtNama.text.toString()
            val email = binding.edtEmail.text.toString()
            val password = binding.edtPassword.text.toString()
            val hp = binding.edtPhone.text.toString()

            registerPresenter.register(name, email, password, hp)
        }
    }

    override fun showError(message: String?) {
        Toast.makeText(this@RegisterActivity, message, Toast.LENGTH_SHORT).show()
    }

    override fun showMessage(message: String?) {
        Toast.makeText(this@RegisterActivity, message, Toast.LENGTH_SHORT).show()
        finish()
    }
}