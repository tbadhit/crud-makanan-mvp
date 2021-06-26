package com.tbadhit.crudmakananmvp.ui.main

import com.tbadhit.crudmakananmvp.api.ApiConfig
import com.tbadhit.crudmakananmvp.model.getMakanan.ResponseGetMakanan
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainPresenter(val view: MainContract.View) : MainContract.Presenter {

    // 1.
    override fun getDataMakanan() {
        // CallBack pilih yang <Retrofit>
        ApiConfig.service().getAllMakanan().enqueue(object : Callback<ResponseGetMakanan> {
            override fun onResponse(
                call: Call<ResponseGetMakanan>,
                response: Response<ResponseGetMakanan>
            ) {
                val responseMakanan = response.body()
                val isSukses = responseMakanan?.sukses

                if (isSukses != false) {
                    val dataMakanan = responseMakanan?.data
                    view.showDataMakanan(dataMakanan)
                } else {
                    view.showMessage(responseMakanan.pesan)
                }
            }

            override fun onFailure(call: Call<ResponseGetMakanan>, t: Throwable) {
                view.showError(t.localizedMessage)
            }

        })
    }
    //----------

}