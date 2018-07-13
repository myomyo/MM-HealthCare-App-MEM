package com.mem.mmhealthcare.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.LinearLayoutManager
import com.mem.mmhealthcare.R
import com.mem.mmhealthcare.adapters.HealthCareAdapter
import com.mem.mmhealthcare.components.SmartScrollListener
import com.mem.mmhealthcare.data.models.HealthCareModel
import com.mem.mmhealthcare.data.vos.HealthCareInfoVO
import com.mem.mmhealthcare.delegates.HealthCareItemDelegate
import com.mem.mmhealthcare.events.DataEvent
import com.mem.mmhealthcare.events.ErrorEvent
import kotlinx.android.synthetic.main.activity_main.*
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class MainActivity : BaseActivity(), HealthCareItemDelegate {

    private var mHealthCareAdapter: HealthCareAdapter? = null
    private var mSmartScrollListener: SmartScrollListener? =null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

       rv_health_care.setEmptyView(vpEmptyHealthCare)
        rv_health_care.layoutManager = LinearLayoutManager(applicationContext) //add layout to recycler view

        mSmartScrollListener = SmartScrollListener(object: SmartScrollListener.OnSmartScrollListener{
            override fun onListEndReach() {
                Snackbar.make(rv_health_care, "Loading more data.", Snackbar.LENGTH_LONG).show()
                swipe_refresh_layout.isRefreshing = true
                HealthCareModel.getInstance().loadHealthCareInfo()
            }
        })
        rv_health_care.addOnScrollListener(mSmartScrollListener)

        mHealthCareAdapter = HealthCareAdapter(applicationContext, this)
        rv_health_care.adapter = mHealthCareAdapter //add recycler view to adapter
        swipe_refresh_layout.isRefreshing = true
        HealthCareModel.getInstance().loadHealthCareInfo()

        swipe_refresh_layout.setOnRefreshListener {
            val healthCareAdapterVal = mHealthCareAdapter
            healthCareAdapterVal!!.clearData()
            HealthCareModel.getInstance().loadHealthCareInfo()

        }

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onHealthCareLoadedEvent(healthCareLoadedEvent: DataEvent.HealthCareLoadedEvent){

        swipe_refresh_layout.isRefreshing = false
        mHealthCareAdapter!!.setData(healthCareLoadedEvent.loadedHealthCareInfo as MutableList<HealthCareInfoVO>)
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onErrorNewsLoadedEvent(apiErrorEvent: ErrorEvent.ApiErrorEvent) {
        swipe_refresh_layout.isRefreshing = false
        Snackbar.make(rv_health_care, "ERROR : " + apiErrorEvent.getMsg(), Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onEmptyNewsLoadedEvent(emptyDataLoadedEvent: DataEvent.EmptyDataLoadedEvent) {
        swipe_refresh_layout.isRefreshing = false
        Snackbar.make(rv_health_care, "ERROR : " + emptyDataLoadedEvent.errorMsg, Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
    }

    override fun onTabHealthCare(healthCare: HealthCareInfoVO?) {
        val intent = Intent(applicationContext, HealCareDetailsActivity::class.java)
        startActivity(intent)
    }

}
