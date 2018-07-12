package com.mem.mmhealthcare.network.response

import com.google.gson.annotations.SerializedName
import com.mem.mmhealthcare.data.vos.HealthCareInfoVO

class GetHealthCareInfoResponse {

    @SerializedName("code")
    private val code: Int = 0

    @SerializedName("message")
    private val message: String = ""

    @SerializedName("healthcare-info")
    private var healthCareInfoList: List<HealthCareInfoVO>? = null

    fun getCode(): Int {
        return code
    }

    fun getMessage(): String? {
        return message
    }

    fun getHealthCareInfoList(): List<HealthCareInfoVO> {
        if (healthCareInfoList == null) {
            healthCareInfoList = ArrayList()
        }

        val healthCareList = healthCareInfoList
        return healthCareList!!
    }

}