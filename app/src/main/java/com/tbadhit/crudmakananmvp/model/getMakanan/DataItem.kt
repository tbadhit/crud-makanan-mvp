package com.tbadhit.crudmakananmvp.model.getMakanan

import com.google.gson.annotations.SerializedName

data class DataItem(

	@field:SerializedName("menu_harga")
	val menuHarga: String? = null,

	@field:SerializedName("menu_gambar")
	val menuGambar: String? = null,

	@field:SerializedName("menu_nama")
	val menuNama: String? = null,

	@field:SerializedName("menu_id")
	val menuId: String? = null
)