package com.bluparse.koranid.ui.main

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bluparse.core.utils.showImage
import com.bluparse.koranid.R
import com.bluparse.koranid.data.entity.MenuCategory
import kotlinx.android.synthetic.main.row_item_category.view.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

/**
 * Created by Anggit Prayogo on 2019-08-01.
 */
class CategoryAdapter : RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    private var categoryMenuList: MutableList<MenuCategory> = mutableListOf()

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bindItem(menuCategory: MenuCategory) {
            with(itemView) {
                tv_category_title.text = menuCategory.title
                iv_category.showImage(itemView.context, menuCategory.image)
            }

            itemView.setOnClickListener { it ->
                try {
                    Intent().setClassName(it.context.packageName, menuCategory.classUrl)
                        .also {
                            itemView.context.startActivity(it)
                        }
                } catch (e: Exception) {
                    itemView.context.toast(itemView.context.getString(R.string.error_page_not_found))
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.row_item_category,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = categoryMenuList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(categoryMenuList[position])
    }

    fun setItems(menuCategories: MutableList<MenuCategory>) {
        categoryMenuList.clear()
        categoryMenuList = menuCategories
        notifyDataSetChanged()
    }
}