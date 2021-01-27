package us.kikin.apps.android.turito.network

import com.google.gson.annotations.SerializedName

data class CategoryDto(
    @SerializedName("alias") val alias: String,
    @SerializedName("title") val title: String
)
