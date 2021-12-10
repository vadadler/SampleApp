package vad.adler.sampleapp.newsapi.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import vad.adler.sampleapp.databinding.FragmentNewsListBinding
import vad.adler.sampleapp.databinding.FragmentNewsTopicBinding
import vad.adler.sampleapp.newsapi.view.ui.adapter.NewsListAdapter

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [NewsTopicFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class NewsTopicFragment : Fragment() {
    private lateinit var binding: FragmentNewsTopicBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_news_topic, container, false)
        binding = FragmentNewsTopicBinding.inflate(inflater, container, false)
        return binding.root
    }

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        with(binding) {
//            recyclerView = newsRecyclerView
//            viewmodel?.getLatestNews("tesla")
//            adapter = NewsListAdapter()
//            newsRecyclerView.adapter = adapter
//        }
//    }

}