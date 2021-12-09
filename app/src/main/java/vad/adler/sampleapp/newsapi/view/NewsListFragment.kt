package vad.adler.sampleapp.newsapi.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import vad.adler.sampleapp.databinding.FragmentNewsListBinding
import vad.adler.sampleapp.newsapi.view.ui.adapter.NewsListAdapter

class NewsListFragment : Fragment() {
    private lateinit var binding: FragmentNewsListBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: NewsListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewsListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        with(binding) {
            recyclerView = newsRecyclerView
//            viewmodel?.getLatestNews("tesla")
            adapter = NewsListAdapter()
            newsRecyclerView.adapter = adapter
        }
    }
}