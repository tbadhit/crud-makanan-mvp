package com.tbadhit.crudmakananmvp.ui.update

import com.tbadhit.crudmakananmvp.model.detail.Data

interface UpdateDeleteContract {
    interface View {
        fun showMessageUpdate(message: String?)
        fun showMessegeDelete(message: String?)
        fun showError(localizedMessage: String?)
        fun showDetailMakanan(data: Data)
    }

    interface Presenter {
        fun updateMakanan(menuId: String, name: String, price: String, gambar: String)
        fun deleteMakanan(menuId: String)
        fun getDetailMakanan(id: String)
    }
}