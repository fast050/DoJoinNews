package com.example.dojoinnews.presentation.ui.news_details

import android.content.Intent
import android.net.Uri
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.dojoinnews.R
import com.example.dojoinnews.databinding.FragmentNewsDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsDetailFragment : Fragment() {


    private val viewModel by viewModels<NewsDetailViewModel>()
    private var _binding: FragmentNewsDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNewsDetailBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.viewModel =  viewModel

        setSeeMoreButton()
    }

    private fun setSeeMoreButton() {
        binding.courseDetailButtonSeeMore.setOnClickListener {
            val uri = Uri.parse(viewModel.newsDetail?.url) // missing 'http://' will cause crashed
            uri?.let {
                val intent = Intent(Intent.ACTION_VIEW, uri)
                startActivity(intent);
            }
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}