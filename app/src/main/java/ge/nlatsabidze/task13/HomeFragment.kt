package ge.nlatsabidze.task13

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import ge.nlatsabidze.task13.databinding.FragmentHomeBinding

class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    private lateinit var userAdapter: UserAdapter
    private val viewModel: HomeViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setUpRecyclerView()
        setResult()
    }

    private fun setUpRecyclerView() {
        binding.rvTodos.layoutManager = LinearLayoutManager(requireContext())
        userAdapter = UserAdapter()
        binding.rvTodos.adapter = userAdapter.withLoadStateHeaderAndFooter(
            header = ProgressBarAdapter {userAdapter.retry()},
            footer = ProgressBarAdapter {userAdapter.retry()}
        )
    }

    private fun setResult() {
        lifecycleScope.launchWhenCreated {
            viewModel.getData().observe(viewLifecycleOwner, {
                userAdapter.submitData(lifecycle, it)
            })
        }
    }
}