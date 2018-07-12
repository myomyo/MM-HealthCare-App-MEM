package com.mem.mmhealthcare.delegates

import com.mem.mmhealthcare.data.vos.HealthCareInfoVO

interface HealthCareItemDelegate {

    fun onTabHealthCare(healthCare: HealthCareInfoVO)
}