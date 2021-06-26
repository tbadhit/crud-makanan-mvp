package com.tbadhit.crudmakananmvp.ui.register

interface RegisterContact {
    interface View {
        fun showError(message: String?)
        fun showMessage(message: String?)
    }

    interface Presenter {
        fun register(name: String, email: String, password: String, hp: String)
    }
}