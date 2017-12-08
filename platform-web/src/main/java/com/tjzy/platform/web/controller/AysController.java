package com.tjzy.platform.web.controller;

import com.alibaba.fastjson.JSON;
import com.tjzy.platform.common.base.BaseController;
import com.tjzy.platform.model.bean.PlatformOrder;
import com.tjzy.platform.model.constant.PayResult;
import com.tjzy.platform.model.pay.PayParams;
import com.tjzy.platform.model.pay.PayResponse;
import com.tjzy.platform.model.pay.PaySaPi;
import com.tjzy.platform.service.pay.PayService;
import com.tjzy.platform.web.pay.PayUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * Created by lizhe on 2017/12/7 0007.
 * 目标定在月亮之上，即使失败，也可以落在众星之间。
 * 支付接口
 */
@Controller
@RequestMapping("/ayspay")
@SessionScope
public class AysController extends BaseController{

    /**
     * 相关表 pay_pay
     */

    @Autowired
    private PayService payService;

    PayParams params;

    //支付
    @RequestMapping("/pay")
    @ResponseBody
    public Object aliAys(HttpServletRequest request,@RequestParam(value = "istype") int istype) {
        PlatformOrder parameter = (PlatformOrder) JSON.parse(request.getParameter("order"));
        PayParams payParams = new PayParams(0.01f,1,"http://localhost:8080"+request.getRequestURI()+"/notify_url" ,"http://localhost:8080"+request.getRequestURI()+"/return_url",UUID.randomUUID().toString());
        params = payParams.getParams(payParams);
        PayResponse body = payService.pay(params);
        return body;
    }

    @GetMapping("/notify_url")
    public void notifyUrl(HttpServletRequest request, HttpServletResponse response, PaySaPi paySaPi) {
        // 保证密钥一致性
        if (PayUtil.checkPayKey(paySaPi)) {
            // TODO 做自己想做的
            PaySaPi paySaPi1 = paySaPi;
        } else {
            // TODO 该怎么做就怎么做
        }
    }

    @RequestMapping("/return_url")
    public ModelAndView returnPay(HttpServletRequest request, HttpServletResponse response, String orderid) {
        boolean isTrue = false;
        ModelAndView view = null;
        // 根据订单号查找相应的记录:根据结果跳转到不同的页面
        if (isTrue) {
            view = new ModelAndView("/正确的跳转地址");
        } else {
            view = new ModelAndView("/没有支付成功的地址");
        }
        return view;
    }

    @RequestMapping("/hehe")
    @ResponseBody
    public Object hehe(HttpServletRequest request, HttpServletResponse response, String orderid) {

        return "4sad65a4s6";
    }

}
