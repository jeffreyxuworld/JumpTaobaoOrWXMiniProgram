package com.worldtech.jumpthird

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram
import com.tencent.mm.opensdk.openapi.WXAPIFactory
import com.worldtech.jumpthird.databinding.ActivityMainBinding
import com.worldtech.jumpthird.utils.CommonUtil

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var currentBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        currentBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(currentBinding.root)

        currentBinding.tvTaobaoShop.setOnClickListener(this)
        currentBinding.tvTaobaoCommodityPage.setOnClickListener(this)
        currentBinding.tvTaobaoCouponPage.setOnClickListener(this)
        currentBinding.tvWxMiniprogram.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.tv_taobao_shop -> if (CommonUtil.isPkgInstalled(this, "com.taobao.taobao")) {
                CommonUtil.gotoShop(
                    this,
                    "taobao://" + "shop.m.taobao.com/shop/shop_index.htm?shop_id=458028920"
                )
            } else {
                //没安装淘宝客户端
                CommonUtil.openBrowser(
                    this,
                    "https://" + "shop.m.taobao.com/shop/shop_index.htm?shop_id=458028920"
                )
            }
            R.id.tv_taobao_commodity_page -> if (CommonUtil.isPkgInstalled(
                    this,
                    "com.taobao.taobao"
                )
            ) {
                CommonUtil.gotoGoodsDetail(
                    this,
                    "taobao://" + "item.taobao.com/item.htm?id=522968001275"
                )
            } else {
                //没安装淘宝客户端
                CommonUtil.openBrowser(
                    this,
                    "https://" + "item.taobao.com/item.htm?id=522968001275"
                )
            }
            R.id.tv_taobao_coupon_page -> if (CommonUtil.isPkgInstalled(
                    this,
                    "com.taobao.taobao"
                )
            ) {
                CommonUtil.gotoCoupon(
                    this,
                    "taobao://" + "market.m.taobao.com/apps/aliyx/coupon/detail.html?sellerId=2200723171488&activityId=8a1a9c28cc9b40e58aa8a9d8b5562dab"
                )
            } else {
                //没安装淘宝客户端
                CommonUtil.openBrowser(
                    this,
                    "https://" + "market.m.taobao.com/apps/aliyx/coupon/detail.html?sellerId=2200723171488&activityId=8a1a9c28cc9b40e58aa8a9d8b5562dab"
                )
            }
            R.id.tv_wx_miniprogram -> jumpWechatMiniProgram()
        }
    }

    /**
     * 跳转微信小程序
     */
    private fun jumpWechatMiniProgram() {
        if (CommonUtil.isPkgInstalled(this, "com.tencent.mm")) {
            val appId: String = if (BuildConfig.DEBUG) {
                getString(R.string.weChat_key)
            } else {
                getString(R.string.weChat_dev_key)
            }
            val api = WXAPIFactory.createWXAPI(this, appId)
            //                    api.registerApp(appId);
            val req = WXLaunchMiniProgram.Req()
            req.userName = "" // 填小程序原始id
            //				req.path = "/pages/index/index";                  //拉起小程序页面的可带参路径，不填默认拉起小程序首页
//				req.miniprogramType = WXLaunchMiniProgram.Req.MINIPTOGRAM_TYPE_RELEASE;// 可选打开 开发版，体验版和正式版
            api.sendReq(req)
        }
    }

}