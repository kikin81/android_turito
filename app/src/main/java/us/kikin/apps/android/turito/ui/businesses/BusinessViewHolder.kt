package us.kikin.apps.android.turito.ui.businesses

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import us.kikin.apps.android.turito.databinding.ItemBusinessBinding
import us.kikin.apps.android.turito.models.Business

class BusinessViewHolder(
    private val binding: ItemBusinessBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(business: Business) {
        binding.name.text = business.name
        binding.price.text = business.price
        binding.address.text = business.location.displayAddress.joinToString()
        // TODO: extract to resource string
        binding.distance.text = "${String.format("%.2f", business.distanceInMiles)} mi"
    }

    /**
     * Convenience method to inflate view holder
     */
    companion object {
        fun from(parent: ViewGroup): BusinessViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val binding = ItemBusinessBinding.inflate(inflater, parent, false)
            return BusinessViewHolder(binding)
        }
    }
}
