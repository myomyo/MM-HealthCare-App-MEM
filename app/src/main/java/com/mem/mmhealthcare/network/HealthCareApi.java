package com.mem.mmhealthcare.network;

import com.mem.mmhealthcare.utils.AppConstants;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

class HealthCareApi {

    @FormUrlEncoded
    @POST("v1/getHealthCare.php")
    fun loadMMHealthCareInfo(
            @Field("accessToken") accessToken: String :Call<>
    )
}
