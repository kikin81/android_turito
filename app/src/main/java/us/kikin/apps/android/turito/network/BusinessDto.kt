package us.kikin.apps.android.turito.network
import com.google.gson.annotations.SerializedName

data class BusinessDto(
    @SerializedName("alias") val alias: String,
    @SerializedName("categories") val categories: List<CategoryDto>,
    @SerializedName("coordinates") val coordinates: CoordinatesDto,
    @SerializedName("display_phone") val displayPhone: String,
    @SerializedName("distance") val distance: Double,
    @SerializedName("id") val id: String,
    @SerializedName("image_url") val imageUrl: String,
    @SerializedName("is_closed") val isClosed: Boolean,
    @SerializedName("location") val location: LocationDto,
    @SerializedName("name") val name: String,
    @SerializedName("phone") val phone: String,
    @SerializedName("price") val price: String,
    @SerializedName("rating") val rating: Double,
    @SerializedName("review_count") val reviewCount: Int,
    @SerializedName("transactions") val transactions: List<String>,
    @SerializedName("url") val url: String
)

data class CoordinatesDto(
    @SerializedName("latitude") val latitude: Double,
    @SerializedName("longitude") val longitude: Double
)
