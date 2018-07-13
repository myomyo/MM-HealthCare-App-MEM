package com.mem.mmhealthcare.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.mem.mmhealthcare.R
import com.mem.mmhealthcare.adapters.HealthCareAdapter
import com.mem.mmhealthcare.data.models.HealthCareModel
import com.mem.mmhealthcare.data.vos.HealthCareInfoVO
import com.mem.mmhealthcare.events.DataEvent
import kotlinx.android.synthetic.main.activity_main.*
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class MainActivity : BaseActivity() {

    private var mHealthCareAdapter: HealthCareAdapter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        mHealthCareAdapter = HealthCareAdapter(applicationContext)
        //add layout to recycler view
        rv_health_care.layoutManager = LinearLayoutManager(applicationContext)
        //add recycler view to adapter
        rv_health_care.adapter = mHealthCareAdapter
        HealthCareModel.getInstance().loadHealthCareInfo()

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onHealthCareLoadedEvent(healthCareLoadedEvent: DataEvent.HealthCareLoadedEvent){

        mHealthCareAdapter!!.setData(healthCareLoadedEvent.loadedHealthCareInfo as MutableList<HealthCareInfoVO>)
    }

}
