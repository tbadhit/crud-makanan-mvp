package com.tbadhit.crudmakananmvp.ui.insert

interface InsertContract {

    // 1.
    interface View {
        fun showMessage(message: String?)
        fun showError(s: String)
    }

    // 1.
    interface Presenter {
        fun insertDataMakanan(name: String, price: String, gambar: String)
    }

}