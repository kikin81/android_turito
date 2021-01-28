package us.kikin.apps.android.turito.ui.businesses

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import us.kikin.apps.android.turito.models.Business
import us.kikin.apps.android.turito.repository.BusinessRepository
import javax.inject.Inject

@HiltViewModel
class BusinessListViewModel @Inject constructor(
    private val repository: BusinessRepository
) : ViewModel() {

    private val _data = MutableLiveData<List<Business>>()
    val data: LiveData<List<Business>> get() = _data

    init {
        getRestaurantsNearMe()
    }

    private fun getRestaurantsNearMe() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val location = "111 Sutter St, San Francisco, CA 94104"
                val pizza = async {
                    repository.getBusinessesNearLocationWithSearchTerm("pizza", location)
                }
                val beer = async {
                    repository.getBusinessesNearLocationWithSearchTerm("beer", location)
                }
                val result = pizza.await() + beer.await()
                _data.postValue(result)
            } catch (e: Exception) {
                // TODO: show error ui
            }
        }
    }
}
