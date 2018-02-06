package com.inviscidlabs.behancer.network

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


object BehanceAPI {
    private val BASE_URL = "http://www.behance.net/"



    val retrofittedBuilder: Retrofit by lazy {
        Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
    }

    val behanceService: BehanceService = retrofittedBuilder.create(BehanceService::class.java)


}