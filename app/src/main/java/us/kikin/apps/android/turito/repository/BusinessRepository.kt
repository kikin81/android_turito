package us.kikin.apps.android.turito.repository

import us.kikin.apps.android.turito.models.Business
import us.kikin.apps.android.turito.network.BusinessService
import javax.inject.Inject

class BusinessRepository @Inject constructor(
    private val businessService: BusinessService
) {

    suspend fun getBusinessesNearLocationWithSearchTerm(
        searchTerm: String,
        location: String
    ): List<Business> {
        val response = businessService.businessSearchForLocation(searchTerm, location)
        return response.items.map { Business(it) }
    }
}
