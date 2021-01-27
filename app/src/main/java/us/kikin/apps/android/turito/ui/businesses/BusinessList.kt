package us.kikin.apps.android.turito.ui.businesses

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import us.kikin.apps.android.turito.databinding.BusinessListFragmentBinding

@AndroidEntryPoint
class BusinessList : Fragment() {

    private var _binding: BusinessListFragmentBinding? = null
    private val binding get() = requireNotNull(_binding)
    private val viewModel: BusinessListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = BusinessListFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.data.observe(
            viewLifecycleOwner,
            { businesses ->
                for (business in businesses) {
                    Log.d("FCO", "b: ${business.name}")
                }
            }
        )
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}
