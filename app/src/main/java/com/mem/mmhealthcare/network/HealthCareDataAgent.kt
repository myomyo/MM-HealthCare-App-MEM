package com.mem.mmhealthcare.network

import com.google.gson.Gson
import com.mem.mmhealthcare.events.DataEvent
import com.mem.mmhealthcare.events.ErrorEvent
import com.mem.mmhealthcare.network.response.GetHealthCareInfoResponse
import okhttp3.OkHttpClient
import org.greenrobot.eventbus.EventBus
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
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

    private val healthCareApi: HealthCareApi

    private constructor(){
        val okHttpClient = OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build()

        val retrofit = Retrofit.Builder()
                .baseUrl("http://padcmyanmar.com/padc-5/mm-healthcare/")
                .addConverterFactory(GsonConverterFactory.create(Gson()))
                .client(okHttpClient)
                .build()

        healthCareApi = retrofit.create(HealthCareApi::class.java)
    }

    fun loadHealthCareInfo(accessToken : String) {

        val healthCareResponse = healthCareApi.loadHealthCareInfo(accessToken)
        healthCareResponse.enqueue(object : Callback<GetHealthCareInfoResponse>{
            override fun onFailure(call: Call<GetHealthCareInfoResponse>?, t: Throwable?) {
                EventBus.getDefault().post(ErrorEvent.ApiErrorEvent(t))
            }

            override fun onResponse(call: Call<GetHealthCareInfoResponse>?, response: Response<GetHealthCareInfoResponse>?) {
                val healthCareResponse: GetHealthCareInfoResponse? = response!!.body()
                if (healthCareResponse != null && healthCareResponse.getCode() == 200 && healthCareResponse.getHealthCareInfoList().isNotEmpty()){

                    EventBus.getDefault().post(DataEvent.HealthCareLoadedEvent(healthCareResponse.getHealthCareInfoList()))
                } else{
                    if (healthCareResponse != null){
                        EventBus.getDefault().post(DataEvent.EmptyDataLoadedEvent(healthCareResponse.getMessage()))
                    } else{
                        EventBus.getDefault().post(DataEvent.EmptyDataLoadedEvent())
                    }
                }
            }
        })
    }
}