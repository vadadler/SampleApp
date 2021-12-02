package vad.adler.sampleapp.newsapi.view.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import vad.adler.sampleapp.databinding.NewsListItemBinding
import vad.adler.sampleapp.newsapi.model.NewsServiceResponse
import vad.adler.sampleapp.newsapi.view.ui.NewsListViewModel
import vad.adler.sampleapp.newsapi.view.ui.adapter.viewholders.NewsListViewHolder

class NewsListAdapter(private val newsListViewModel: NewsListViewModel) : RecyclerView.Adapter<NewsListViewHolder>() {
    var newsList: List<NewsServiceResponse.Article> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val dataBinding = NewsListItemBinding.inflate(inflater, parent, false)
        return NewsListViewHolder(dataBinding, newsListViewModel)
    }

    override fun getItemCount() = newsList.size

    override fun onBindViewHolder(holder: NewsListViewHolder, position: Int) {
        holder.setup(newsList[position])
    }

    fun updateRepoList(repoList: List<Item>) {
        this.repoList = repoList
        notifyDataSetChanged()
    }
}