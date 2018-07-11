package com.mem.mmhealthcare.network

import com.google.gson.Gson
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class HealthCareDataAgent {
    companion object {
        private var INSTANCE: HealthCareDataAgent? = null

        fun getInstance(): HealthCareDataAgent {
            if(INSTANCE == null){
                INSTANCE = HealthCareDataAgent()
            }

            val i = INSTANCE
            return i!!
        }

    }

    init {
        val okHttpClient = OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build()

        val retrofit = Retrofit.Builder()
                .baseUrl("http://padcmyanmar.com/padc-3/mm-news/apis/")
                .addConverterFactory(GsonConverterFactory.create(Gson()))
                .client(okHttpClient)
                .build()
    }
}