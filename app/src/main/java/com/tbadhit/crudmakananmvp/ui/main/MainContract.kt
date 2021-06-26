package com.tbadhit.crudmakananmvp.ui.main

import com.tbadhit.crudmakananmvp.model.getMakanan.DataItem

interface MainContract {
    // 1.
    interface View {

        // Sesudah bikin class MainPresenter
        fun showDataMakanan(dataMakanan: List<DataItem?>?)
        fun showError(localizedMessage: String?)
        fun showMessage(pesan: String?)

        // Sebelum bikin class MainPresenter
        // fun showDataMakanan()
        // fun showError()
        // fun showMessage()
    }

    // 1.
    interface Presenter{
        fun getDataMakanan()
    }
}