package com.tbadhit.crudmakananmvp.ui.login

interface LoginContact {
    interface View {
        fun showError(message: String?)
        fun showMessageLogin(name: String?)
    }

    interface Presenter {
        fun login(email: String, password: String)
    }
}