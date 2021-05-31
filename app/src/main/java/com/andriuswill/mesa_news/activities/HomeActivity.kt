package com.andriuswill.mesa_news.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.andriuswill.mesa_news.BR
import com.andriuswill.mesa_news.R
import com.andriuswill.mesa_news.adapters.RecyclerBindingAdapter
import com.andriuswill.mesa_news.data.News
import com.andriuswill.mesa_news.databinding.ActivityHomeBinding
import com.andriuswill.mesa_news.extensions.observe
import com.andriuswill.mesa_news.viewmodels.HomeViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeActivity : AppCompatActivity() {

    private val viewmodel: HomeViewModel by viewModel()

    private lateinit var binding: ActivityHomeBinding

    private val highlightsAdapter by lazy {
        RecyclerBindingAdapter<News>(
            itemLayout = R.layout.item_highlight,
            itemVarId = BR.highlight
        )
    }

    private val newsAdapter by lazy {
        RecyclerBindingAdapter<News>(
            itemLayout = R.layout.item_news,
            itemVarId = BR.news
        )
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView<ActivityHomeBinding>(
            this,
            R.layout.activity_home
        ).apply {
            viewmodel = this@HomeActivity.viewmodel
            lifecycleOwner = this@HomeActivity
        }
        with(viewmodel) {
            observe(highlightsList, ::setupHighlights)
            observe(newsList, ::setupNews)
        }

        binding.vpHighlights.adapter = highlightsAdapter
        binding.rvNews.adapter = newsAdapter

        viewmodel.getHighLights()
        viewmodel.getNews()
    }

    private fun setupHighlights(highlights: ArrayList<News>?) {
        highlights?.let { list ->
            highlightsAdapter.addAll(list)
        }
    }

    private fun setupNews(news: ArrayList<News>?) {
        news?.let { list ->
            newsAdapter.addAll(list)
        }
    }

}