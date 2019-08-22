package com.bluparse.koranid.ui.main.home

import android.content.Intent
import android.os.Bundle
import android.util.Log.e
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityOptionsCompat.makeSceneTransitionAnimation
import androidx.core.view.ViewCompat.getTransitionName
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bluparse.core.base.BaseFragment
import com.bluparse.core.utils.ConstantIntent
import com.bluparse.core.utils.setGone
import com.bluparse.core.utils.setVisible
import com.bluparse.koranid.R
import com.bluparse.koranid.data.entity.ArticleHeadline
import com.bluparse.koranid.data.entity.MenuCategory
import com.bluparse.koranid.data.entity.TopHeadline
import com.bluparse.koranid.ui.detail.DetailNewsActivity
import com.bluparse.koranid.ui.main.CategoryAdapter
import com.bluparse.koranid.ui.main.TopHeadlineAdapter
import kotlinx.android.synthetic.main.base_loading_home_top_headline_shimmer.*
import kotlinx.android.synthetic.main.cell_category.*
import kotlinx.android.synthetic.main.cell_top_headline.*
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.row_item_headline.view.*
import javax.inject.Inject
import com.bluparse.core.R as core


private const val CLASS_SPORT = "com.bluparse.features_sport.ui.list.SportActivity"
private const val CLASS_ENTERTAINMENT = "com.bluparse.features_sport.ui.list.SportActivity"
private const val CLASS_BUSINESS = "com.bluparse.features_sport.ui.list.SportActivity"
private const val CLASS_TECH = "com.bluparse.features_sport.ui.list.SportActivity"
private const val CLASS_FOOD = "com.bluparse.features_sport.ui.list.SportActivity"


class HomeFragment : BaseFragment(), HomeContract.View, HomeAdapterListener {

    @Inject
    lateinit var presenter: HomePresenter

    @Inject
    lateinit var adapterCategory: CategoryAdapter

    @Inject
    lateinit var adapterTopHeadline: TopHeadlineAdapter

    private var menuCategoryList: MutableList<MenuCategory> = mutableListOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapterTopHeadline.setAdapterListener(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initPresenter()
        onActionListener()
        initRecyclerViewCategory()
        initRecyclerViewTopHeadline()
        presenter.getTopHeadline("id", "", true)
        generateMenuCategory()
    }

    private fun onActionListener() {
        swipe_refresh_layout.setOnRefreshListener {
            presenter.getTopHeadline("id", "sports", false)
            swipe_refresh_layout.isRefreshing = false
        }
    }

    private fun generateMenuCategory() {
        menuCategoryList.clear()
        menuCategoryList.apply {
            add(
                MenuCategory(
                    core.drawable.icon_sport,
                    getString(R.string.category_sport),
                    CLASS_SPORT
                )
            )
            add(
                MenuCategory(
                    core.drawable.icon_business,
                    getString(R.string.category_business),
                    CLASS_BUSINESS
                )
            )
            add(
                MenuCategory(
                    core.drawable.icon_entertainment,
                    getString(R.string.category_entertainment),
                    CLASS_ENTERTAINMENT
                )
            )
            add(
                MenuCategory(
                    core.drawable.icon_tech,
                    getString(R.string.category_tech),
                    CLASS_TECH
                )
            )
            add(
                MenuCategory(
                    core.drawable.icon_food,
                    getString(R.string.category_food),
                    CLASS_FOOD
                )
            )
        }
        adapterCategory.setItems(menuCategoryList)
    }

    private fun initPresenter() {
        presenter.attachView(this)
    }

    private fun initRecyclerViewCategory() {
        val layoutManager = LinearLayoutManager(activity, RecyclerView.HORIZONTAL, false)
        rv_category.layoutManager = layoutManager
        rv_category.adapter = adapterCategory
    }

    private fun initRecyclerViewTopHeadline() {
        val layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
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

    override fun showLoadingShimmer() {
        shimmer_home?.setVisible()
        rv_headline?.setGone()
    }

    override fun hideLoadingShimmer() {
        shimmer_home?.setGone()
        rv_headline?.setVisible()
    }

    override fun showError(throwable: Throwable) {
        e("DATA ERROR: ", throwable.message)
    }

    override fun onClickItem(
        articleHeadline: ArticleHeadline,
        itemView: View
    ) {
        val intent = Intent(activity, DetailNewsActivity::class.java)
        intent.putExtra(ConstantIntent.ITEM_NEWS, articleHeadline)
        intent.putExtra(
            activity?.getString(R.string.shared_element_transition_1),
            getTransitionName(itemView.iv_news_thumbnail)
        )

        val options = activity?.let { fragmentActivity ->
            getTransitionName(itemView.iv_news_thumbnail)?.let { ivNews ->
                makeSceneTransitionAnimation(
                    fragmentActivity,
                    itemView.iv_news_thumbnail,
                    ivNews
                )
            }
        }

        activity?.startActivity(intent, options?.toBundle())
    }
}
