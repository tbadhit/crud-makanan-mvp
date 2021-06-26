package com.tbadhit.crudmakananmvp.ui.register

import com.tbadhit.crudmakananmvp.api.ApiConfig
import com.tbadhit.crudmakananmvp.model.auth.ResponseAuth
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterPresenter(val view : RegisterContact.View) : RegisterContact.Presenter {
    override fun register(name: String, email: String, password: String, hp: String) {
        if (name.isBlank() || email.isBlank() || password.isBlank() || hp.isBlank()) {
            // alt + enter aja kalo merah
            view.showError("Tidak boleh ada yang kosong")
            return
        }
        ApiConfig.service().register(name, email, password, hp).enqueue(object : Callback<ResponseAuth> {
            override fun onResponse(call: Call<ResponseAuth>, response: Response<ResponseAuth>) {
                if (response.isSuccessful) {
                    val responseRegist = response.body()
                    val isSukses = responseRegist?.sukses

                    if (isSukses != false) {
                        val message = responseRegist?.pesan
                        view.showMessage(message)
                    } else {
                        val message = responseRegist.pesan
                        view.showError(message)
                    }
                }
            }

            override fun onFailure(call: Call<ResponseAuth>, t: Throwable) {
                view.showError(t.localizedMessage)
            }

        })
    }
}