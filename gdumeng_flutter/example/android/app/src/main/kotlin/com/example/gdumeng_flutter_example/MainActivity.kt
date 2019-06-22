package com.example.gdumeng_flutter_example

import android.os.Bundle

import io.flutter.app.FlutterActivity
import io.flutter.plugins.GeneratedPluginRegistrant

import android.app.Activity;
import android.widget.Toast;
import android.content.Context;
import android.util.Log;
import android.app.Application;

import com.umeng.analytics.MobclickAgent;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.statistics.common.DeviceConfig;

class MainActivity: FlutterActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        GeneratedPluginRegistrant.registerWith(this)

//      UMConfigure.init(this, "5cfdcbcb0cafb21ddd0003c6", "Android", UMConfigure.DEVICE_TYPE_PHONE, null)
//      UMConfigure.setLogEnabled(true)
//      Toast.makeText(this, "this is activity", Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
        MobclickAgent.onResume(this)
        MobclickAgent.onPageStart("MainScreen");
    }

    override fun onPause() {
        super.onPause()
        MobclickAgent.onPause(this)
        MobclickAgent.onPageEnd("MainScreen");
    }

}
