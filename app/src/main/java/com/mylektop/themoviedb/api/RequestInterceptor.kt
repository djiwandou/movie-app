package com.mylektop.themoviedb.api

import com.mylektop.themoviedb.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

/**
 * Created by MyLektop on 28/01/2020
 */
internal class RequestInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val originalUrl = originalRequest.url
        val url = originalUrl.newBuilder()
            .addQueryParameter("api_key", BuildConfig.API_KEY)
            .addQueryParameter("language", "en-US")
            .build()
        val requestBuilder = originalRequest.newBuilder().url(url)
        val request = requestBuilder.build()

        return chain.proceed(request)
    }
}