package com.worldtech.jumpthird.utils

import android.content.pm.PackageManager.NameNotFoundException
import android.app.Activity
import android.content.Intent
import android.content.Context
import android.content.pm.PackageInfo
import android.net.Uri
import android.widget.Toast
import java.lang.Exception

object CommonUtil {
    /**
     * 检查手机上是否安装了指定的软件
     *
     * @param context context
     * @param pkgName 应用包名
     * @return true:已安装；false：未安装
     */
    fun isPkgInstalled(context: Context, pkgName: String?): Boolean {
        var packageInfo: PackageInfo?
        try {
            packageInfo = context.packageManager.getPackageInfo(pkgName!!, 0)
        } catch (e: NameNotFoundException) {
            packageInfo = null
            e.printStackTrace()
        }
        return packageInfo != null
    }

    /**
     * 跳转至商品详情
     *
     * @param activity Activity
     * @param url      商品详情
     */
    fun gotoGoodsDetail(activity: Activity, url: String?) {
        try {
            //测试商品url
            val intent = Intent()
            intent.action = "Android.intent.action.VIEW"
            val uri = Uri.parse(url) // 商品地址
            intent.data = uri
            intent.setClassName(
                "com.taobao.taobao",
                "com.taobao.tao.detail.activity.DetailActivity"
            )
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            activity.startActivity(intent)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    /**
     * 打开优惠券页面
     * @param activity
     * @param url
     */
    fun gotoCoupon(activity: Activity, url: String?) {
        try {
            val intent = Intent()
            intent.action = "android.intent.action.View"
            intent.setClassName("com.taobao.taobao", "com.taobao.browser.BrowserActivity")
            val uri = Uri.parse(url) //clickUrl,领券地址
            intent.data = uri
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            activity.startActivity(intent)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    /**
     * 打开店铺主页
     * @param activity
     * @param url
     */
    fun gotoShop(activity: Activity, url: String?) {
        try {
            val intent = Intent()
            intent.action = "android.intent.action.VIEW"
            intent.data = Uri.parse(url)
            activity.startActivity(intent)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    /**
     * 调用第三方浏览器打开
     * @param context
     * @param url 要浏览的资源地址
     */
    fun openBrowser(context: Context, url: String?) {
        val intent = Intent()
        intent.action = Intent.ACTION_VIEW
        intent.data = Uri.parse(url)
        if (intent.resolveActivity(context.packageManager) != null) {
            val componentName = intent.resolveActivity(context.packageManager)
            context.startActivity(Intent.createChooser(intent, "请选择浏览器"))
        } else {
            Toast.makeText(context.applicationContext, "请下载浏览器", Toast.LENGTH_SHORT).show()
        }
    }
}