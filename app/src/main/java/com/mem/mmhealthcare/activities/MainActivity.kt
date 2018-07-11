package com.mem.mmhealthcare.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.mem.mmhealthcare.R
import com.mem.mmhealthcare.adapters.HealthCareAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    private var mHealthCareAdapter: HealthCareAdapter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        mHealthCareAdapter = HealthCareAdapter(applicationContext)
        rv_health_care.adapter = mHealthCareAdapter
        rv_health_care.layoutManager = LinearLayoutManager(applicationContext)
    }
}
