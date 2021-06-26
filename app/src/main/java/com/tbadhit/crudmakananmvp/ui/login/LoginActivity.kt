package com.tbadhit.crudmakananmvp.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.tbadhit.crudmakananmvp.MainActivity
import com.tbadhit.crudmakananmvp.databinding.ActivityLoginBinding
import com.tbadhit.crudmakananmvp.ui.register.RegisterActivity

class LoginActivity : AppCompatActivity(), LoginContact.View {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var loginPresenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loginPresenter = LoginPresenter(this)

        binding.btnLogin.setOnClickListener {

            val email = binding.edtEmail.text.toString()
            val password = binding.edtPassword.text.toString()

            loginPresenter.login(email, password)
        }

        binding.btnRegister.setOnClickListener {
            startActivity(Intent(this@LoginActivity, RegisterActivity::class.java))
        }

    }

    override fun showError(message: String?) {
        Toast.makeText(this@LoginActivity, message, Toast.LENGTH_SHORT).show()
    }

    override fun showMessageLogin(name: String?) {
        Toast.makeText(this@LoginActivity, "Selamat datang $name", Toast.LENGTH_SHORT).show()
        val intent = Intent(this@LoginActivity, MainActivity::class.java)
        startActivity(intent)

    }
}