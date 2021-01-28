package us.kikin.apps.android.turito.ui.businesses

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import us.kikin.apps.android.turito.models.Business

class BusinessAdapter : ListAdapter<Business, BusinessViewHolder>(BusinessDiffCallback()) {

    private var items = mutableListOf<Business>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BusinessViewHolder =
        BusinessViewHolder.from(parent)

    override fun onBindViewHolder(holder: BusinessViewHolder, position: Int) {
        val business = items[position]
        holder.bind(business)
    }

    override fun getItemCount(): Int = items.size

    fun updateItems(newItems: List<Business>) {
        items.clear()
        items.addAll(newItems)
        notifyDataSetChanged()
    }
}

class BusinessDiffCallback : DiffUtil.ItemCallback<Business>() {
    override fun areItemsTheSame(oldItem: Business, newItem: Business): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Business, newItem: Business): Boolean {
        return oldItem == newItem
    }
}
