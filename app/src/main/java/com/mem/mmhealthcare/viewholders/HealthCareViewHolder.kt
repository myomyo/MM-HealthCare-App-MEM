package com.mem.mmhealthcare.viewholders

import android.support.v7.widget.RecyclerView
import android.view.View

class HealthCareViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
    init {
        itemView!!.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}