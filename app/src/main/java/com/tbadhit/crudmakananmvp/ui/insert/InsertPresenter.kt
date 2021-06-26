package com.tbadhit.crudmakananmvp.ui.insert

import com.tbadhit.crudmakananmvp.api.ApiConfig
import com.tbadhit.crudmakananmvp.model.action.ResponseAction
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// 1.
class InsertPresenter(val view: InsertContract.View) : InsertContract.Presenter {
    // 1.
    override fun insertDataMakanan(name: String, price: String, gambar: String) {
        // 2.
        if (name.isBlank() || price.isBlank() || gambar.isBlank()) {
            // alt + enter aja kalo merah
            view.showError("Tidak boleh ada yang kosong")
            return
        }

        // 2.
        ApiConfig.service().insertMakanan(name, price, gambar)
            .enqueue(object : Callback<ResponseAction> {
                override fun onResponse(
                    call: Call<ResponseAction>,
                    response: Response<ResponseAction>
                ) {
                    if (response.isSuccessful) {
                        val responseAction = response.body()
                        val isSukses = responseAction?.sukses

                        if (isSukses != false) {
                            val message = responseAction?.pesan
                            // Kalo merah alt + enter aja
                            view.showMessage(message)
                        } else {
                            val message = responseAction.pesan
                            message?.let { view.showError(it) }
                        }
                    }
                }

                override fun onFailure(call: Call<ResponseAction>, t: Throwable) {
                    view.showError(t.localizedMessage ?: "error")
                }

            })
    }
}