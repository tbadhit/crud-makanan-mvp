package com.tbadhit.crudmakananmvp.model.action

import com.google.gson.annotations.SerializedName

data class ResponseAction(

	@field:SerializedName("pesan")
	val pesan: String? = null,

	@field:SerializedName("sukses")
	val sukses: Boolean? = null
)
