package com.tbadhit.crudmakananmvp.ui.login

import com.tbadhit.crudmakananmvp.api.ApiConfig
import com.tbadhit.crudmakananmvp.model.auth.ResponseAuth
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginPresenter(val view : LoginContact.View) : LoginContact.Presenter {
    override fun login(email: String, password: String) {

        if (email.isBlank() || password.isBlank() ) {
            // alt + enter aja kalo merah
            view.showError("Tidak boleh ada yang kosong")
            return
        }

        ApiConfig.service().login(email, password).enqueue(object : Callback<ResponseAuth> {
            override fun onResponse(call: Call<ResponseAuth>, response: Response<ResponseAuth>) {
                if (response.isSuccessful) {
                    val responseLogin = response.body()
                    val data = responseLogin?.data

                    if (data != null) {
                        val name = data.userNama
                        view.showMessageLogin(name)
                    } else {
                        val message = responseLogin?.pesan
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