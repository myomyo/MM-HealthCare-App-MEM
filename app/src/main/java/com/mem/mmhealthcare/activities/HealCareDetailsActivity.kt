package com.mem.mmhealthcare.activities

import android.os.Bundle
import android.view.View
import com.mem.mmhealthcare.R
import com.mem.mmhealthcare.R.drawable.logo
import com.mem.mmhealthcare.R.drawable.placeholder
import com.mem.mmhealthcare.data.models.HealthCareModel
import com.mem.mmhealthcare.data.vos.HealthCareInfoVO
import com.mem.mmhealthcare.utils.AppConstants
import com.mem.mmhealthcare.utils.GlideApp
import kotlinx.android.synthetic.main.activity_healthcare_details.*

class HealCareDetailsActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_healthcare_details)
        val healthCareId = intent.getIntExtra(AppConstants.HEALTHCARE_ID, -1)
        bindData(HealthCareModel.getInstance().getHealthCareById(healthCareId)!!)
    }

    private fun bindData(healthCare : HealthCareInfoVO){

        tv_author_name.text = healthCare.author!!.authorName
        tv_posted_date.text = healthCare.publishedDate
        tv_title_details.text = healthCare.title
        tv_desc_details.text = healthCare.shortDescription
        if(healthCare.infoIype != null){
            tv_info_type.text = healthCare.infoIype
            tv_info_type.visibility = View.VISIBLE
        } else {
            tv_info_type.visibility = View.GONE
        }


        GlideApp.with(iv_profile.context)
                .load(healthCare.author.authorPicture)
                .circleCrop()
                .placeholder(logo)
                .into(iv_profile)

        GlideApp.with(iv_image_details)
                .load(healthCare.image)
                .placeholder(placeholder)
                .into(iv_image_details)


    }
}