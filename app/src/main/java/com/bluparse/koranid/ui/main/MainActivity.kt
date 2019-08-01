package com.bluparse.koranid.ui.main

import android.os.Bundle
import android.util.Log.e
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bluparse.core.base.BaseActivity
import com.bluparse.koranid.R
import com.bluparse.koranid.data.entity.MenuCategory
import com.bluparse.koranid.data.entity.TopHeadline
import kotlinx.android.synthetic.main.cell_category.*
import javax.inject.Inject

private const val CLASS_SPORT = "com.bluparse.features_sport.ui.list.SportActivity"

class MainActivity : BaseActivity(), MainContact.View {

    @Inject
    lateinit var presenter: MainPresenter

    @Inject
    lateinit var adapter: CategoryAdapter

    private var menuCategoryList: MutableList<MenuCategory> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initPresenter()

        initRecyclerViewCategory()

        generateMenuCategory()

        presenter.getTopHeadline("id", "sports")

//        button.setOnClickListener {
//            Intent().setClassName(packageName, CLASS_SPORT)
//                .also {
//                    startActivity(it)
//                }
//        }
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
        adapter.setItems(menuCategoryList)
    }

    private fun initPresenter() {
        presenter.attachView(this)
    }

    private fun initRecyclerViewCategory() {
        val layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        rv_category.layoutManager = layoutManager
        rv_category.adapter = adapter
    }

    override fun showResponseSuccess(response: TopHeadline?) {
        e("DATA : ", response.toString())
    }

    override fun showError(throwable: Throwable) {
        e("DATA ERROR: ", throwable.message)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()
    }
}
