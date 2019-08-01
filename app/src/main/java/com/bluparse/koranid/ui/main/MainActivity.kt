package com.bluparse.koranid.ui.main

import android.os.Bundle
import android.util.Log.e
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bluparse.core.base.BaseActivity
import com.bluparse.koranid.R
import com.bluparse.koranid.data.entity.ArticleHeadline
import com.bluparse.koranid.data.entity.MenuCategory
import com.bluparse.koranid.data.entity.TopHeadline
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.base_app_bar.*
import kotlinx.android.synthetic.main.cell_category.*
import kotlinx.android.synthetic.main.cell_top_headline.*
import javax.inject.Inject

private const val CLASS_SPORT = "com.bluparse.features_sport.ui.list.SportActivity"

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

//        button.setOnClickListener {
//            Intent().setClassName(packageName, CLASS_SPORT)
//                .also {
//                    startActivity(it)
//                }
//        }

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
            add(MenuCategory(R.drawable.ic_launcher_foreground, getString(R.string.category_sport)))
            add(MenuCategory(R.drawable.ic_launcher_foreground, getString(R.string.category_business)))
            add(MenuCategory(R.drawable.ic_launcher_foreground, getString(R.string.category_entertainment)))
            add(MenuCategory(R.drawable.ic_launcher_foreground, getString(R.string.category_tech)))
            add(MenuCategory(R.drawable.ic_launcher_foreground, getString(R.string.category_food)))
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

    override fun showResponseSuccess(response: TopHeadline?) {
        topHeadlineList.clear()
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
