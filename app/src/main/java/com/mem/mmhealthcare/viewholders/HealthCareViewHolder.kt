package com.mem.mmhealthcare.viewholders

import android.view.View
import com.bumptech.glide.Glide
import com.mem.mmhealthcare.data.vos.HealthCareInfoVO
import kotlinx.android.synthetic.main.view_holder_healthcare.view.*

class HealthCareViewHolder(itemView: View) : BaseViewHolder<HealthCareInfoVO>(itemView) {

    override fun setData(data: HealthCareInfoVO) {
        mData = data

        itemView.tv_title.text = data.title
        if (data.infoIype != null){
            itemView.tv_info_type.text = data.infoIype
            itemView.tv_info_type.visibility = View.VISIBLE
        } else{
            itemView.tv_info_type.visibility = View.GONE
        }

        itemView.tv_author.text = data.author!!.authorName

        Glide.with(itemView.context).load(data.image).into(itemView.iv_image)

    }

    override fun onClick(v: View?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}