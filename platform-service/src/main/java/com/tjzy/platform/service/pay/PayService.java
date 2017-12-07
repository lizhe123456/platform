package com.tjzy.platform.service.pay;

import com.tjzy.platform.model.pay.PayParams;
import com.tjzy.platform.model.pay.PayResponse;

/**
 * Created by lizhe on 2017/12/7 0007.
 * 目标定在月亮之上，即使失败，也可以落在众星之间。
 */
public interface PayService{

    //付款
    PayResponse pay(PayParams payParams);
    //收入
    void income();

    void dayIncome();

    void yearIncome();

    void monthIncome();

    //支出
    void expenditure();

    void dayExpenditure();

    void monthExpenditure();

    void yearExpenditure();

    //营业额
    void turnover();

    void dayTurnover();

    void monthTurnover();

    void yearTurnover();

    //利润
    void profit();

    void dayProfit();

    void monthProfit();

    void yearProfit();
}
