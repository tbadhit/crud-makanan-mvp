package com.tbadhit.crudmakananmvp.ui.update

import com.tbadhit.crudmakananmvp.api.ApiConfig
import com.tbadhit.crudmakananmvp.model.action.ResponseAction
import com.tbadhit.crudmakananmvp.model.detail.ResponseDetailMakanan
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// 1.
class UpdateDeletePresenter(val view : UpdateDeleteContract.View) : UpdateDeleteContract.Presenter{

    // 1.
    override fun updateMakanan(menuId: String, name: String, price: String, gambar: String) {
        if (name.isBlank() || price.isBlank() || gambar.isBlank()) {
            // alt + enter aja kalo merah
            view.showError("Tidak boleh ada yang kosong")
            return
        }

        ApiConfig.service().updateMakanan(menuId, name, price, gambar).enqueue(object  : Callback<ResponseAction> {
            override fun onResponse(
                call: Call<ResponseAction>,
                response: Response<ResponseAction>
            ) {
                if (response.isSuccessful) {
                    val responseUpdate = response.body()
                    val isSukses = responseUpdate?.sukses

                    if (isSukses != false) {
                        val message = responseUpdate?.pesan
                        view.showMessageUpdate(message)
                    } else {
                        val message = responseUpdate.pesan
                        view.showError(message)
                    }
                }
            }

            override fun onFailure(call: Call<ResponseAction>, t: Throwable) {
                view.showError(t.localizedMessage)
            }

        })
    }

    // 1.
    override fun deleteMakanan(menuId: String) {
        // 3.
        ApiConfig.service().deleteMakanan(menuId).enqueue(object : Callback<ResponseAction> {
            override fun onResponse(
                call: Call<ResponseAction>,
                response: Response<ResponseAction>
            ) {
                if (response.isSuccessful) {
                    val responseDelete = response.body()
                    val isSukses = responseDelete?.sukses

                    if (isSukses != false) {
                        val message = responseDelete?.pesan
                        view.showMessegeDelete(message)
                    } else {
                        val message = responseDelete.pesan
                        view.showError(message)
                    }
                }
            }

            override fun onFailure(call: Call<ResponseAction>, t: Throwable) {
                view.showError(t.localizedMessage)
            }

        })
    }

    // 1.
    override fun getDetailMakanan(id: String) {
        // id: String? ubah jadi id: String
        // 2.
        ApiConfig.service().getDetailMakanan(id).enqueue(object : Callback<ResponseDetailMakanan> {
            override fun onResponse(
                call: Call<ResponseDetailMakanan>,
                response: Response<ResponseDetailMakanan>
            ) {
                if (response.isSuccessful) {
                    val responseDetail = response.body()
                    val data = responseDetail?.data

                    if (data != null) {
                        // parameternya ALT + ENTER AJA pilih add parameter to function 'showDetailMakanan'
                        view.showDetailMakanan(data)
                    } else {
                        val message = responseDetail?.pesan
                        view.showError(message)
                    }
                }
            }

            override fun onFailure(call: Call<ResponseDetailMakanan>, t: Throwable) {
                // ALT + ENTER kalo ada yang merah lalu pilih add parameter to function showError
                view.showError(t.localizedMessage)
            }

        })
    }
}