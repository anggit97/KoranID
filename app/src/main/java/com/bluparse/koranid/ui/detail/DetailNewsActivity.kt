package com.bluparse.koranid.ui.detail

import android.os.Build.VERSION.SDK_INT
import android.os.Build.VERSION_CODES.LOLLIPOP
import android.os.Bundle
import com.bluparse.core.base.BaseActivity
import com.bluparse.core.utils.ConstantIntent
import com.bluparse.core.utils.showImageRounded
import com.bluparse.koranid.R
import com.bluparse.koranid.data.entity.ArticleHeadline
import kotlinx.android.synthetic.main.activity_detail_news.*


class DetailNewsActivity : BaseActivity() {

    private var newsItem: ArticleHeadline? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_news)
        initStatusBarPref()
        handleIntent()
        bindView()
        onListener()
    }

    private fun onListener() {
        iv_back.setOnClickListener {
            finish()
        }
    }

    private fun handleIntent() {
        newsItem = intent.getParcelableExtra(ConstantIntent.ITEM_NEWS)
        if (SDK_INT >= LOLLIPOP) {
            val imageTransitionName =
                intent.getStringExtra(resources.getString(R.string.shared_element_transition_1))
            iv_news.transitionName = imageTransitionName
        }
    }

    private fun bindView() {
        tv_news_title.text = newsItem?.title
        tv_author.text = newsItem?.author.plus(" - ").plus(newsItem?.source?.name)
        tv_date.text = newsItem?.publishedAt
        tv_body.text = newsItem?.content
        iv_news.showImageRounded(this, newsItem?.urlToImage)
    }
}
