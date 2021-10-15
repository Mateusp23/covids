package com.example.corona.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.corona.R
import com.example.corona.model.Covid
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val arrayInfo = this.intent.getParcelableExtra<Covid>("Boletim")

        btn_back.setOnClickListener { finish() }

        tv_suspects_detail.text = arrayInfo?.suspects.toString()
        tv_confirmed_detail.text = arrayInfo?.confirmed.toString()
        tv_discarded_detail.text = arrayInfo?.discarded.toString()
        tv_monitoring_detail.text = arrayInfo?.monitoring.toString()
        tv_cured_detail.text = arrayInfo?.deads.toString()
        tv_isolation_house_detail.text = arrayInfo?.cured.toString()
        tv_isolation_hospital_detail.text = arrayInfo?.domicile.toString()
        tv_iso_hospital_detail.text = arrayInfo?.suspectHospital.toString()
        tv_deads_detail.text = arrayInfo?.confirmedHospital.toString()
        tv_date_detail.text = arrayInfo?.date
        tv_hour_detail.text = arrayInfo?.hour

        println(arrayInfo.toString())
    }
}