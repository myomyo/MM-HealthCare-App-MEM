package com.mem.mmhealthcare.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import com.mem.mmhealthcare.viewholders.BaseViewHolder

abstract class BaseRecyclerAdapter<T, W>(context: Context): RecyclerView.Adapter<BaseViewHolder<W>>() {

    protected var mData: MutableList<W>? = null
    protected var mLayoutInflater: LayoutInflater

    init {
        mData = ArrayList()
        mLayoutInflater = LayoutInflater.from(context)
    }


    override fun getItemCount(): Int {
        return mData!!.size
    }

    override fun onBindViewHolder(holder: BaseViewHolder<W>, position: Int) {
        holder.setData(mData!![position])
    }

    fun setData(newData: MutableList<W>) {
        mData = newData
        notifyDataSetChanged()
    }

    fun appendData(newData: List<W>) {
        mData!!.addAll(newData)
        notifyDataSetChanged()
    }

    fun removeData(data: W) {
        mData!!.remove(data)
        notifyDataSetChanged()
    }

    fun addData(data: W) {
        mData!!.add(data)
        notifyDataSetChanged()
    }

    fun clearData() {
        mData = java.util.ArrayList()
        notifyDataSetChanged()
    }
}