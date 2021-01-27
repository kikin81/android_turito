package us.kikin.apps.android.turito.repository

import us.kikin.apps.android.turito.network.BusinessService
import javax.inject.Inject

class BusinessRepository @Inject constructor(
    private val businessService: BusinessService
) {

    suspend fun getBusinessSearchForLocation(
        searchTerm: String,
        location: String
    ) {
        businessService.businessSearchForLocation(searchTerm, location)
    }
}
