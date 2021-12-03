package vad.adler.sampleapp.newsapi.view.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import vad.adler.sampleapp.databinding.NewsListItemBinding
import vad.adler.sampleapp.newsapi.model.NewsServiceResponse
import vad.adler.sampleapp.newsapi.view.ui.NewsViewModel

class NewsListAdapter(private val newsListViewModel: NewsViewModel):
    RecyclerView.Adapter<NewsListAdapter.NewsListItemsViewHolder>() {
    var newsList: List<NewsServiceResponse.Article> = emptyList()

    class NewsListItemsViewHolder(private val binding: NewsListItemBinding):
        RecyclerView.ViewHolder(binding.root) {
            fun bind(itemData: NewsServiceResponse.Article) {
                with(binding) {
                    Picasso.get().load(itemData.urlToImage).into(newsItemImage);
                    newsItemHeadline.text = itemData.title.toString()
                }
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsListItemsViewHolder {
        return NewsListItemsViewHolder(NewsListItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun getItemCount() = newsList.size

    override fun onBindViewHolder(holder: NewsListItemsViewHolder, position: Int) {
        holder.bind(newsList[position])
    }
}