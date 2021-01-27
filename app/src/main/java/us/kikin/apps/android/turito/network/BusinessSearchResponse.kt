package us.kikin.apps.android.turito.network

import com.google.gson.annotations.SerializedName

class BusinessSearchResponse(
    @SerializedName("businesses") val items: List<BusinessDto>,
    @SerializedName("total") val total: Int
)
