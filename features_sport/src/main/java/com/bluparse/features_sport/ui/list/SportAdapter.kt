package com.bluparse.features_sport.ui.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bluparse.features_sport.R
import com.bluparse.features_sport.data.entity.Article
import kotlinx.android.synthetic.main.row_item_sport.view.*

/**
 * Created by Anggit Prayogo on 2019-07-31.
 */
class SportAdapter : RecyclerView.Adapter<SportAdapter.ViewHolder>() {

    var sportNewsList: MutableList<Article> = mutableListOf()

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bindView(article: Article) {
            with(itemView) {
                tv_title.text = article.title
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.row_item_sport, parent, false))
    }

    override fun getItemCount(): Int = sportNewsList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(sportNewsList[position])
    }

    fun setItems(sportNewsList: MutableList<Article>) {
        this.sportNewsList.clear()
        this.sportNewsList = sportNewsList
        notifyDataSetChanged()
    }
}