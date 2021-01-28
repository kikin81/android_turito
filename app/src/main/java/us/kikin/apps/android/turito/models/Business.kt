package us.kikin.apps.android.turito.models

import us.kikin.apps.android.turito.network.BusinessDto

data class Business(
    val id: String,
    val name: String,
    val distance: Double,
    val price: String,
    val location: Location
) {
    constructor(dto: BusinessDto) :
        this(
            dto.id,
            dto.name,
            dto.distance,
            dto.price,
            Location(dto.location)
        )

    val distanceInMiles: Double by lazy {
        distance * 0.000621371
    }

}
