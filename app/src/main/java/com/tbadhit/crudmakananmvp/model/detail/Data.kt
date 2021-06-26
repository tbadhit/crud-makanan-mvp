package com.tbadhit.crudmakananmvp.model.detail

import com.google.gson.annotations.SerializedName

data class Data(

	@field:SerializedName("menu_harga")
	val menuHarga: String? = null,

	@field:SerializedName("menu_gambar")
	val menuGambar: String? = null,

	@field:SerializedName("menu_nama")
	val menuNama: String? = null,

	@field:SerializedName("menu_id")
	val menuId: String? = null
)