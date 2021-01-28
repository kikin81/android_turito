package us.kikin.apps.android.turito.models

import us.kikin.apps.android.turito.network.LocationDto

data class Location(
    val address1: String,
    val address2: String?,
    val address3: String?,
    val city: String,
    val displayAddress: List<String>
) {
    constructor(dto: LocationDto) :
        this(
            dto.address1,
            dto.address2,
            dto.address3,
            dto.city,
            dto.displayAddress
        )
}
