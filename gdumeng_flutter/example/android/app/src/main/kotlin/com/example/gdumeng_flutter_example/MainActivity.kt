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

//      Toast.makeText(this, "this is activity", Toast.LENGTH_SHORT).show()
    }

//    override fun onResume() {
//        super.onResume()
//    }

//    override fun onPause() {
//        super.onPause()
//    }
}
