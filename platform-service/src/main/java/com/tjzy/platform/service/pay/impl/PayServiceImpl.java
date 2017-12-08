package com.tjzy.platform.service.pay.impl;

import com.alibaba.fastjson.JSON;
import com.tjzy.platform.common.http.HttpClient;
import com.tjzy.platform.model.constant.PayConstant;
import com.tjzy.platform.model.pay.PayParams;
import com.tjzy.platform.model.pay.PayResponse;
import com.tjzy.platform.service.pay.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by lizhe on 2017/12/7 0007.
 * 目标定在月亮之上，即使失败，也可以落在众星之间。
 */
@Service
@Transactional
public class PayServiceImpl  implements PayService {

    @Autowired
    PayInOrderService payInOrderService;
    @Autowired
    PayInOrderDetailService payInOrderDetailService;
    @Autowired
    PayOutOrderDetailService payOutOrderDetailService;
    @Autowired
    PayOutOrderService payOutOrderService;
    @Autowired
    PayPayService payPayService;


    //支付
    @Override
    public PayResponse pay(PayParams payParams) {
        HttpClient httpClient = HttpClient.getInstance();
        String payJson = httpClient.httpPost(PayConstant.PAY_URL,payParams);
        return (PayResponse) JSON.parse(payJson);
    }

    //收入
    @Override
    public void income() {

    }

    @Override
    public void dayIncome() {

    }

    @Override
    public void yearIncome() {

    }

    @Override
    public void monthIncome() {

    }
    //支出
    @Override
    public void expenditure() {

    }

    @Override
    public void dayExpenditure() {

    }

    @Override
    public void monthExpenditure() {

    }

    @Override
    public void yearExpenditure() {

    }
    //营业额
    @Override
    public void turnover() {

    }

    @Override
    public void dayTurnover() {

    }

    @Override
    public void monthTurnover() {

    }

    @Override
    public void yearTurnover() {

    }
    //利润
    @Override
    public void profit() {

    }

    @Override
    public void dayProfit() {

    }

    @Override
    public void monthProfit() {

    }

    @Override
    public void yearProfit() {

    }
}
