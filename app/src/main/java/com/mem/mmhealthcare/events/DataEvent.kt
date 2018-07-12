package com.mem.mmhealthcare.events

import com.mem.mmhealthcare.data.vos.HealthCareInfoVO

class DataEvent {

    class HealthCareLoadedEvent(val loadedHealthCareInfo: List<HealthCareInfoVO>)

    class EmptyDataLoadedEvent(val errorMsg: String? = "Empty Body Response")
}