package com.bluparse.network

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

/**
 * Created by Anggit PRayogo on 2019-08-20.
 * github : @anggit97
 */
class ApiKeyInterceptor @Inject constructor() : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val originalHttpUrl = original.url()

        val url = originalHttpUrl.newBuilder()
            .addQueryParameter("apiKey", BuildConfig.API_KEY)
            .build()

        // Request customization: add request headers
        val requestBuilder = original.newBuilder()
            .url(url)

        val request = requestBuilder.build()
        return chain.proceed(request)
    }
}