package com.mem.mmhealthcare.adapters

import android.content.Context
import android.view.ViewGroup
import com.mem.mmhealthcare.R
import com.mem.mmhealthcare.data.vos.HealthCareInfoVO
import com.mem.mmhealthcare.viewholders.HealthCareViewHolder


class HealthCareAdapter(context: Context) : BaseRecyclerAdapter<HealthCareViewHolder, HealthCareInfoVO>(context) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HealthCareViewHolder {
        val itemView = mLayoutInflater.inflate(R.layout.view_holder_healthcare, parent, false)
        return HealthCareViewHolder(itemView)
    }

}