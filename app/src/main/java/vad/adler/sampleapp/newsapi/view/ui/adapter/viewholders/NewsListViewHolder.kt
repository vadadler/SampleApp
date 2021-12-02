package vad.adler.sampleapp.newsapi.view.ui.adapter.viewholders

import androidx.databinding.ViewDataBinding
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.news_list_item.view.*
import vad.adler.sampleapp.newsapi.model.NewsServiceResponse
import vad.adler.sampleapp.newsapi.view.ui.NewsListViewModel

class NewsListViewHolder constructor(private val dataBinding: ViewDataBinding, private val newsListViewModel: NewsListViewModel)
    : RecyclerView.ViewHolder(dataBinding.root) {

    val newsItemImage = itemView.newsItemImage
    fun setup(itemData: NewsServiceResponse.Article) {
//        dataBinding.setVariable(BR.itemData, itemData)
        dataBinding.executePendingBindings()

        Picasso.get().load(itemData.urlToImage).into(newsItemImage);

//        itemView.onClick {
//            val bundle = bundleOf("url" to itemData.url)
//            itemView.findNavController().navigate(R.id.action_repoListFragment_to_repoDetailFragment, bundle)
//        }
    }
}