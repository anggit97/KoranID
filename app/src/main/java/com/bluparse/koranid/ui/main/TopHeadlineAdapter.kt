package com.bluparse.koranid.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bluparse.core.utils.showImage
import com.bluparse.core.utils.showImageRounded
import com.bluparse.koranid.R
import com.bluparse.koranid.data.entity.ArticleHeadline
import com.bluparse.koranid.ui.detail.DetailNewsActivity
import kotlinx.android.synthetic.main.row_item_headline.view.*
import org.jetbrains.anko.startActivity

/**
 * Created by Anggit Prayogo on 2019-08-01.
 */
class TopHeadlineAdapter : RecyclerView.Adapter<TopHeadlineAdapter.ViewHolder>() {

    private var topHeadlineList: MutableList<ArticleHeadline> = mutableListOf()

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bindView(articleHeadline: ArticleHeadline) {
            with(itemView) {
                tv_news_title.text = articleHeadline.title
                tv_news_create_by.text = articleHeadline.source?.name
                iv_news_thumbnail.showImageRounded(itemView.context, articleHeadline.urlToImage)
            }

            itemView.setOnClickListener {
                it.context.startActivity<DetailNewsActivity>()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.row_item_headline, parent, false))
    }

    override fun getItemCount(): Int = topHeadlineList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(topHeadlineList[position])
    }

    fun setItems(topHeadlineList: MutableList<ArticleHeadline>) {
        this.topHeadlineList = topHeadlineList
        notifyDataSetChanged()
    }
}