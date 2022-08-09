package com.example.dojoinnews.presentation.ui.new_list

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Adapter
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import com.example.dojoinnews.R
import com.example.dojoinnews.commen.util.Resources
import com.example.dojoinnews.databinding.FragmentNewsListBinding
import com.example.dojoinnews.domain.util.NewsPeriod
import com.example.dojoinnews.presentation.ui.new_list.adapter.NewsListAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsListFragment : Fragment() {

    private val viewModel by viewModels<NewsListViewModel>()
    private var _binding :FragmentNewsListBinding?= null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        setHasOptionsMenu(true)

        _binding = FragmentNewsListBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setNewsListRecyclerView()
    }

    private fun setNewsListRecyclerView() {
        val adapter = NewsListAdapter()
        binding.newsListRecyclerView.adapter = adapter

        viewModel.getNewsListUseCase(NewsPeriod.SEVEN_DAYS)

        viewModel.newsList.observe(viewLifecycleOwner) {
            binding.newsListRecyclerView.isVisible =
                it is Resources.Success || !it.data.isNullOrEmpty()
            adapter.submitList(it.data)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.news_menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when(item.itemId) {
            R.id.One_type -> {
                viewModel.getNewsListUseCase(NewsPeriod.ONE_DAY)
                true
            }
            R.id.Seven_type -> {
                viewModel.getNewsListUseCase(NewsPeriod.SEVEN_DAYS)
                true
            }
            R.id.Thirty_type ->{
                viewModel.getNewsListUseCase(NewsPeriod.THIRTY_DAYS)
                true
            }

            else -> super.onOptionsItemSelected(item)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}