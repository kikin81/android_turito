package us.kikin.apps.android.turito.ui.businesses

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import dagger.hilt.android.AndroidEntryPoint
import us.kikin.apps.android.turito.databinding.BusinessListFragmentBinding

@AndroidEntryPoint
class BusinessList : Fragment() {

    private var _binding: BusinessListFragmentBinding? = null
    private val binding get() = requireNotNull(_binding)
    private lateinit var viewModel: BusinessListViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = BusinessListFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(BusinessListViewModel::class.java)
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}
