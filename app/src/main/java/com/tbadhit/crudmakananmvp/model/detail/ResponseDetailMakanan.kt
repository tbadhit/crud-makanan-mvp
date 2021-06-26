package com.tbadhit.crudmakananmvp.model.detail

import com.google.gson.annotations.SerializedName

data class ResponseDetailMakanan(

	@field:SerializedName("pesan")
	val pesan: String? = null,

	@field:SerializedName("data")
	val data: Data? = null,

	@field:SerializedName("sukses")
	val sukses: Boolean? = null
)