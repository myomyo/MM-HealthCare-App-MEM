package com.mem.mmhealthcare.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import com.mem.mmhealthcare.R
import com.mem.mmhealthcare.viewholders.HealthCareViewHolder


class HealthCareAdapter(context: Context): RecyclerView.Adapter<HealthCareViewHolder>() {

    private var mLayoutInflater: LayoutInflater

    init {
        mLayoutInflater = LayoutInflater.from(context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HealthCareViewHolder {
        val itemView = mLayoutInflater.inflate(R.layout.view_holder_healthcare, parent, false)
        return HealthCareViewHolder(itemView)
    }

    override fun getItemCount(): Int {

        return 10
    }

    override fun onBindViewHolder(holder: HealthCareViewHolder, position: Int) {

        Log.d("adapter", " position :  $position")


    }
}