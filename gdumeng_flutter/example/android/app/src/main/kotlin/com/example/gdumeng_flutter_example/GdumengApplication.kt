package com.example.gdumeng_flutter_example
import io.flutter.app.FlutterApplication


import android.app.Activity;
import android.widget.Toast
import android.content.Context
import android.app.Application;

import com.umeng.analytics.MobclickAgent;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.statistics.common.DeviceConfig;



class GdumengApplication : FlutterApplication() {
    @Override
    override fun onCreate() {
        super.onCreate()

        Toast.makeText(this, "you are GdumengApplication", Toast.LENGTH_SHORT).show()
        UMConfigure.init(this, "5cfdcbcb0cafb21ddd0003c6", "Android", UMConfigure.DEVICE_TYPE_PHONE, "")
    }

}