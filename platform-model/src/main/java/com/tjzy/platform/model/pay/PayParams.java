package com.tjzy.platform.model.pay;

import com.tjzy.platform.model.constant.PayConstant;
import com.tjzy.platform.util.MD5Util;

import java.io.Serializable;

/**
 * Created by lizhe on 2017/12/7 0007.
 * 目标定在月亮之上，即使失败，也可以落在众星之间。
 */
public class PayParams implements Serializable {

    public String uid;

    public float price;

    public int istype;

    public String notify_url;

    public String return_url;

    public String orderid;

    public String orderuid;

    public String goodsname;

    public String key;

    public PayParams(float price, int istype, String notify_url, String return_url, String orderid) {
        this.price = price;
        this.istype = istype;
        this.notify_url = notify_url;
        this.return_url = return_url;
        this.orderid = orderid;
    }

    public PayParams(float price, int istype, String notify_url, String return_url, String orderid, String goodsname) {
        this.price = price;
        this.istype = istype;
        this.notify_url = notify_url;
        this.return_url = return_url;
        this.orderid = orderid;
        this.goodsname = goodsname;
    }



    public PayParams(float price, int istype, String notify_url, String return_url, String orderid, String orderuid, String goodsname) {
        this.price = price;
        this.istype = istype;
        this.notify_url = notify_url;
        this.return_url = return_url;
        this.orderid = orderid;
        this.orderuid = orderuid;
        this.goodsname = goodsname;
    }

    public PayParams getParams(PayParams payParams){
        payParams.uid = PayConstant.PAY_UID;
        payParams.key = MD5Util.MD5(payParams.goodsname + payParams.istype + payParams.notify_url +
                payParams.orderid + payParams.orderuid + payParams.price +
                payParams.return_url + PayConstant.PAY_TOKEN + payParams.uid).toLowerCase();
        return payParams;
    }

    @Override
    public String toString() {
        return "PayParams{" +
                "uid='" + uid + '\'' +
                ", price=" + price +
                ", istype=" + istype +
                ", notify_url='" + notify_url + '\'' +
                ", return_url='" + return_url + '\'' +
                ", orderid='" + orderid + '\'' +
                ", orderuid='" + orderuid + '\'' +
                ", goodsname='" + goodsname + '\'' +
                ", key='" + key + '\'' +
                '}';
    }

}
