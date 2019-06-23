package com.example.gdumeng_flutter

import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugin.common.MethodChannel.MethodCallHandler
import io.flutter.plugin.common.MethodChannel.Result
import io.flutter.plugin.common.PluginRegistry.Registrar
import android.app.Activity;
import android.widget.Toast
import android.content.Context
import android.app.Application;

import com.umeng.analytics.MobclickAgent;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.statistics.common.DeviceConfig;

class GdumengFlutterPlugin: MethodCallHandler {
    var mActivity: Activity

    constructor(mActivity: Activity) {
        this.mActivity = mActivity
    }

    companion object {
        @JvmStatic
        fun registerWith(registrar: Registrar) {
            val channel = MethodChannel(registrar.messenger(), "gdumeng_flutter")
            val plugin = GdumengFlutterPlugin(registrar.activity())
            channel.setMethodCallHandler(plugin)
        }
    }

    override fun onMethodCall(call: MethodCall, result: Result) {
        if (call.method == "getPlatformVersion") {
            result.success("Android ${android.os.Build.VERSION.RELEASE}")
        } else if (call.method == "makeup") {
            makeupAnalysc(call)
            result.success("")
        } else if (call.method == "beginPageView") {
            beginPageView(call)
            result.success(null)
        } else if (call.method == "endPageView") {
            endPageView(call)
            result.success(null)
        } else {
            result.notImplemented()
        }
    }

    private fun beginPageView(call: MethodCall) {
        var pageName = call.argument<String>("name") ?: "Undefined"
        MobclickAgent.onPageStart(pageName)
        MobclickAgent.onResume(mActivity)
    }

    private fun endPageView(call: MethodCall) {
        var pageName = call.argument<String>("name") ?: "Undefined"
        MobclickAgent.onPageEnd(pageName)
        MobclickAgent.onPause(mActivity)
    }

    private fun makeupAnalysc(call: MethodCall) {
        val channel = call.argument<String>("channel") ?: "Android"

        val appkey = call.argument<String>("key") ?: ""
        if (appkey.length > 0) {
//            Toast.makeText(mActivity, appkey, Toast.LENGTH_SHORT).show()
            try {
                UMConfigure.setLogEnabled(true)
                UMConfigure.init(mActivity, appkey, channel, UMConfigure.DEVICE_TYPE_PHONE, null)
                UMConfigure.setEncryptEnabled(false)
//                MobclickAgent.openActivityDurationTrack(false)
            } catch (e: Exception) {
                e.printStackTrace()
            }

        }

    }
}
