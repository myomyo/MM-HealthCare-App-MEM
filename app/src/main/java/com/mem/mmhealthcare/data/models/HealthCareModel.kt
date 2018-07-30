package com.mem.mmhealthcare.data.models

import com.mem.mmhealthcare.data.vos.HealthCareInfoVO
import com.mem.mmhealthcare.events.DataEvent
import com.mem.mmhealthcare.network.HealthCareDataAgent
import com.mem.mmhealthcare.utils.AppConstants
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class HealthCareModel {
    companion object {
        private var INSTANCE: HealthCareModel? = null

        fun getInstance(): HealthCareModel{
            if(INSTANCE == null)
                INSTANCE = HealthCareModel()

            val i = INSTANCE
            return i!!
        }

    }

    private constructor(){
        EventBus.getDefault().register(this)
    }

    private var mHealthData: HashMap<Int, HealthCareInfoVO> = HashMap()

    fun loadHealthCareInfo(){
        HealthCareDataAgent.getInstance().loadHealthCareInfo(AppConstants.ACCESS_TOKEN)
    }

    fun forceloadHealthCareInfo(){
        mHealthData = HashMap()
        HealthCareDataAgent.getInstance().loadHealthCareInfo(AppConstants.ACCESS_TOKEN)
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    fun onHealthCareLoadedEvent(healthCareEvent: DataEvent.HealthCareLoadedEvent){
        for(healthCare: HealthCareInfoVO in healthCareEvent.loadedHealthCareInfo){
            mHealthData[healthCare.healthCareId] = healthCare
        }
    }
    fun getHealthCareById(id : Int) : HealthCareInfoVO?{
        return mHealthData[id]
    }
}