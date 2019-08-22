package com.bluparse.koranid.ui.main.home

import android.view.View
import com.bluparse.koranid.data.entity.ArticleHeadline

/**
 * Created by Anggit PRayogo on 2019-08-22.
 * github : @anggit97
 */
interface HomeAdapterListener {
    fun onClickItem(
        articleHeadline: ArticleHeadline,
        itemView: View
    )
}