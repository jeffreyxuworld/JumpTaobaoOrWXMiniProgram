package com.worldtech.jumpthird;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.worldtech.jumpthird.utils.CommonUtil;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv_taobao_shop = findViewById(R.id.tv_taobao_shop);
        TextView tv_taobao_commodity_page = findViewById(R.id.tv_taobao_commodity_page);
        TextView tv_taobao_coupon_page = findViewById(R.id.tv_taobao_coupon_page);
        TextView tv_wx_miniprogram = findViewById(R.id.tv_wx_miniprogram);
        tv_taobao_shop.setOnClickListener(this);
        tv_taobao_commodity_page.setOnClickListener(this);
        tv_taobao_coupon_page.setOnClickListener(this);
        tv_wx_miniprogram.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.tv_taobao_shop: //跳转淘宝店铺页面
                if(CommonUtil.isPkgInstalled(this, "com.taobao.taobao")){
                    CommonUtil.gotoShop(this, "taobao://" + "shop.m.taobao.com/shop/shop_index.htm?shop_id=458028920");
                }else{
                    //没安装淘宝客户端
                    CommonUtil.openBrowser(this, "https://" +"shop.m.taobao.com/shop/shop_index.htm?shop_id=458028920");
                }
                break;
            case R.id.tv_taobao_commodity_page: //跳转淘宝商品页面
                if(CommonUtil.isPkgInstalled(this, "com.taobao.taobao")){
                    CommonUtil.gotoGoodsDetail(this, "taobao://" + "item.taobao.com/item.htm?id=522968001275");
                }else{
                    //没安装淘宝客户端
                    CommonUtil.openBrowser(this, "https://" + "item.taobao.com/item.htm?id=522968001275");
                }
                break;
            case R.id.tv_taobao_coupon_page: //跳转淘宝领取优惠券页面
                if(CommonUtil.isPkgInstalled(this, "com.taobao.taobao")){
                    CommonUtil.gotoCoupon(this, "taobao://" + "market.m.taobao.com/apps/aliyx/coupon/detail.html?sellerId=2200723171488&activityId=8a1a9c28cc9b40e58aa8a9d8b5562dab");
                }else{
                    //没安装淘宝客户端
                    CommonUtil.openBrowser(this, "https://" + "market.m.taobao.com/apps/aliyx/coupon/detail.html?sellerId=2200723171488&activityId=8a1a9c28cc9b40e58aa8a9d8b5562dab");
                }
                break;
            case R.id.tv_wx_miniprogram: //跳转微信小程序
                jumpWechatMiniProgram();
                break;
        }
    }


    /**
     * 跳转微信小程序
     */
    private void jumpWechatMiniProgram(){
        if(CommonUtil.isPkgInstalled(this,"com.tencent.mm")){
            String appId;
            if (BuildConfig.DEBUG) {
                appId = getString(R.string.weChat_key);
            }else{
                appId = getString(R.string.weChat_dev_key);
            }
            IWXAPI api = WXAPIFactory.createWXAPI(this, appId);
            //                    api.registerApp(appId);
            WXLaunchMiniProgram.Req req = new WXLaunchMiniProgram.Req();
            req.userName = ""; // 填小程序原始id
//				req.path = "/pages/index/index";                  //拉起小程序页面的可带参路径，不填默认拉起小程序首页
//				req.miniprogramType = WXLaunchMiniProgram.Req.MINIPTOGRAM_TYPE_RELEASE;// 可选打开 开发版，体验版和正式版
            api.sendReq(req);
        }
    }


}
