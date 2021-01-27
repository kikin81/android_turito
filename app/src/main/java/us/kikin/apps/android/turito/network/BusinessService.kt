package us.kikin.apps.android.turito.network

import retrofit2.http.GET
import retrofit2.http.Query

interface BusinessService {

    @GET("businesses/search")
    suspend fun businessSearchForLocation(
        @Query("term") searchTerm: String,
        @Query("location") address: String
    )
}
