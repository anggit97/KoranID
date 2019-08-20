package com.bluparse.koranid.ui.main

import android.os.Bundle
import android.util.Log.e
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bluparse.core.base.BaseActivity
import com.bluparse.koranid.R
import com.bluparse.core.R as core
import com.bluparse.koranid.data.entity.ArticleHeadline
import com.bluparse.koranid.data.entity.MenuCategory
import com.bluparse.koranid.data.entity.TopHeadline
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.base_app_bar.*
import kotlinx.android.synthetic.main.cell_category.*
import kotlinx.android.synthetic.main.cell_top_headline.*
import javax.inject.Inject

private const val CLASS_SPORT = "com.bluparse.features_sport.ui.list.SportActivity"
private const val CLASS_ENTERTAINMENT = "com.bluparse.features_sport.ui.list.SportActivity"
private const val CLASS_BUSINESS = "com.bluparse.features_sport.ui.list.SportActivity"
private const val CLASS_TECH = "com.bluparse.features_sport.ui.list.SportActivity"
private const val CLASS_FOOD = "com.bluparse.features_sport.ui.list.SportActivity"

class MainActivity : BaseActivity(), MainContact.View {

    @Inject
    lateinit var presenter: MainPresenter

    @Inject
    lateinit var adapterCategory: CategoryAdapter

    @Inject
    lateinit var adapterTopHeadline: TopHeadlineAdapter

    private var menuCategoryList: MutableList<MenuCategory> = mutableListOf()
    private var topHeadlineList: MutableList<ArticleHeadline> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initToolbar()

        initPresenter()

        initRecyclerViewCategory()

        initRecyclerViewTopHeadline()

        generateMenuCategory()

        presenter.getTopHeadline("id", "sports")

        onActionListener()
    }

    private fun initToolbar() {
        tv_app_bar_title.text = getString(R.string.app_name)
    }

    private fun onActionListener() {
        swipe_refresh_layout.setOnRefreshListener {
            presenter.getTopHeadline("id", "sports")
            swipe_refresh_layout.isRefreshing = false
        }
    }

    private fun generateMenuCategory() {
        menuCategoryList.clear()
        menuCategoryList.apply {
            add(MenuCategory(core.drawable.icon_sport, getString(R.string.category_sport), CLASS_SPORT))
            add(MenuCategory(core.drawable.icon_business, getString(R.string.category_business), CLASS_BUSINESS))
            add(MenuCategory(core.drawable.icon_entertainment, getString(R.string.category_entertainment), CLASS_ENTERTAINMENT))
            add(MenuCategory(core.drawable.icon_tech, getString(R.string.category_tech), CLASS_TECH))
            add(MenuCategory(core.drawable.icon_food, getString(R.string.category_food), CLASS_FOOD))
        }
        adapterCategory.setItems(menuCategoryList)
    }

    private fun initPresenter() {
        presenter.attachView(this)
    }

    private fun initRecyclerViewCategory() {
        val layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        rv_category.layoutManager = layoutManager
        rv_category.adapter = adapterCategory
    }

    private fun initRecyclerViewTopHeadline() {
        val layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        rv_headline.layoutManager = layoutManager
        rv_headline.adapter = adapterTopHeadline
        rv_headline.isNestedScrollingEnabled = false
    }

    @Suppress("UNCHECKED_CAST")
    override fun showResponseSuccess(response: TopHeadline?) {
        adapterTopHeadline.setItems(response?.articles as MutableList<ArticleHeadline>)
    }

    override fun showLoading() {
        swipe_refresh_layout.isRefreshing = true
    }

    override fun hideLoading() {
        swipe_refresh_layout.isRefreshing = false
    }

    override fun showError(throwable: Throwable) {
        e("DATA ERROR: ", throwable.message)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()
    }
}
