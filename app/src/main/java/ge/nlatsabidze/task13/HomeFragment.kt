package ge.nlatsabidze.task13

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import ge.nlatsabidze.task13.databinding.FragmentHomeBinding

class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    private lateinit var itemAdapter: ItemAdapter
    private val viewModel: HomeViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setUpRecyclerView()
        setResult()
    }

    private fun setUpRecyclerView() = binding.rvTodos.apply {
        itemAdapter = ItemAdapter()
        adapter = itemAdapter
        layoutManager = LinearLayoutManager(requireContext())
    }

    private fun setResult() {
        viewModel.setResult()

        viewModel.info.observe(viewLifecycleOwner, {
            itemAdapter.info = it
        })
    }
}