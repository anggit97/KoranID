package com.bluparse.koranid.data.entity
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue


/**
 * Created by Anggit Prayogo on 2019-07-30.
 */
@Parcelize
data class TopHeadline(
    @SerializedName("articles")
    val articles: @RawValue List<ArticleHeadline?>?,
    @SerializedName("status")
    val status: String?, // ok
    @SerializedName("totalResults")
    val totalResults: Int? // 70
) : Parcelable

@Parcelize
data class ArticleHeadline(
    @SerializedName("author")
    val author: String?, // Murhan
    @SerializedName("content")
    val content: String?,
    @SerializedName("description")
    val description: String?, // Curahan hati (curhat) adik Cut Meyriska soal Roger Danuarta dan kakaknya terungkap. Dia menulis soal rahasia Allah.
    @SerializedName("publishedAt")
    val publishedAt: String?, // 2019-07-30T00:18:28Z
    @SerializedName("source")
    val source: @RawValue Source?,
    @SerializedName("title")
    val title: String?, // Curhat Adik Cut Meyriska Soal Roger Danuarta dan Kakaknya Terungkap, Tulis Soal Rahasia Allah - Banjarmasin Post
    @SerializedName("url")
    val url: String?, // https://banjarmasin.tribunnews.com/2019/07/30/curhat-adik-cut-meyriska-soal-roger-danuarta-dan-kakaknya-terungkap-tulis-soal-rahasia-allah
    @SerializedName("urlToImage")
    val urlToImage: String? // https://cdn2.tstatic.net/banjarmasin/foto/bank/images/roger-danuarta-dan-cut-meyriska-resmi-tunangan.jpg
) : Parcelable

@Parcelize
data class Source(
    @SerializedName("id")
    val id: String?,
    @SerializedName("name")
    val name: String? // Tribunnews.com
) : Parcelable