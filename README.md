# JumpTaobaoOrWXMiniProgram
[![Platform Android](https://img.shields.io/badge/platform-Android-brightgreen)](https://developer.android.com/)

Android 原生跳转淘宝 APP 不同页面、微信小程序~

很多 APP，会有这样的需要，自己有个商城页面，但是跳转的是淘宝上的商品。这时候就会有相关跳到淘宝 APP 的不同页面需求。
比如：1、跳转商品详情；2、跳转店铺主页；3、跳转优惠券页面；

附上：淘宝客户端跳转，拼接链接规则文档

客户端加载链接时自己拼上 taobao:// 协议前缀

1、跳转商品详情：
item.taobao.com/item.htm?id=（商品id）

例 ：item.taobao.com/item.htm?id=522968001275

2、跳转店铺主页：
shop.m.taobao.com/shop/shop_index.htm?shop_id=（店铺id）

例：shop.m.taobao.com/shop/shop_index.htm?shop_id=458028920

3、跳转优惠券页面：
market.m.taobao.com/apps/aliyx/coupon/detail.html?sellerId=（商品id）&activityId=（活动id）

例：market.m.taobao.com/apps/aliyx/coupon/detail.html?sellerId=2200723171488&activityId=8a1a9c28cc9b40e58aa8a9d8b5562dab

《推理大师》
应用宝链接：
https://sj.qq.com/myapp/detail.htm?apkName=com.youkagames.murdermystery

《桌游圈》
应用宝链接：
https://sj.qq.com/myapp/detail.htm?apkName=com.youkagames.gameplatform

有时我们也会有需求需要跳转到微信小程序，在 Github 上的 Demo 也有实现。

简书文章链接：https://www.jianshu.com/p/e04ac7caae70

大家觉得对自己有点帮助的话，希望可以给文章点个喜欢，在 Github 上加个 Star。
