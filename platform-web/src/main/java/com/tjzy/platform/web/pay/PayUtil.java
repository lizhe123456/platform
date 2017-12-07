package com.tjzy.platform.web.pay;

import com.tjzy.platform.model.constant.PayConstant;
import com.tjzy.platform.model.pay.PaySaPi;
import com.tjzy.platform.util.MD5Util;
import com.tjzy.platform.util.StringHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.UUID;

public class PayUtil {

	private static Logger logger = LoggerFactory.getLogger(PayUtil.class);

	public static String TOKEN = PayConstant.PAY_TOKEN;


	public static boolean checkPayKey(PaySaPi paySaPi) {
		String key = "";
		if (!StringHelper.isBlank(paySaPi.getOrderid())) {
			logger.info("支付回来的订单号：" + paySaPi.getOrderid());
			key += paySaPi.getOrderid();
		}
		if (!StringHelper.isBlank(paySaPi.getOrderuid())) {
			logger.info("支付回来的支付记录的ID：" + paySaPi.getOrderuid());
			key += paySaPi.getOrderuid();
		}
		if (!StringHelper.isBlank(paySaPi.getPaysapi_id())) {
			logger.info("支付回来的平台订单号：" + paySaPi.getPaysapi_id());
			key += paySaPi.getPaysapi_id();
		}
		if (!StringHelper.isBlank(paySaPi.getPrice())) {
			logger.info("支付回来的价格：" + paySaPi.getPrice());
			key += paySaPi.getPrice();
		}
		if (!StringHelper.isBlank(paySaPi.getRealprice())) {
			logger.info("支付回来的真实价格：" + paySaPi.getRealprice());
			key += paySaPi.getRealprice();
		}
		logger.info("支付回来的Key：" + paySaPi.getKey());
		key += TOKEN;
		logger.info("我们自己拼接的Key：" + MD5Util.encryption(key));
		return paySaPi.getKey().equals(MD5Util.encryption(key));
	}

	public static String getOrderIdByUUId() {
		int machineId = 1;// 最大支持1-9个集群机器部署
		int hashCodeV = UUID.randomUUID().toString().hashCode();
		if (hashCodeV < 0) {// 有可能是负数
			hashCodeV = -hashCodeV;
		}
		// 0 代表前面补充0;d 代表参数为正数型
		return machineId + String.format("%01d", hashCodeV);
	}

}
