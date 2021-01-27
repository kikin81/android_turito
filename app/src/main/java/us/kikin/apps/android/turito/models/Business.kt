package us.kikin.apps.android.turito.models

import us.kikin.apps.android.turito.network.BusinessDto

data class Business(
    val id: String,
    val name: String
) {
    constructor(dto: BusinessDto) :
        this(
            dto.id,
            dto.name
        )
}
