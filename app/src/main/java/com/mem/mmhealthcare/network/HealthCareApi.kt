package com.mem.mmhealthcare.network;

import com.mem.mmhealthcare.network.response.GetHealthCareInfoResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

interface HealthCareApi {

    @FormUrlEncoded
    @POST("GetHealthcareInfo.php")
    fun loadHealthCareInfo(
            @Field("access_token") accessToken: String): Call<GetHealthCareInfoResponse>
}
