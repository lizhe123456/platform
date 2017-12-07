package com.tjzy.platform.service.pay.impl;

import com.tjzy.platform.dao.mapper.PayOutOrderDetailMapper;
import com.tjzy.platform.model.pay.PayBaseServiceImpl;
import com.tjzy.platform.model.pay.PayOutOrderDetail;
import com.tjzy.platform.service.pay.PayOutOrderDetailService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by lizhe on 2017/12/7 0007.
 * 目标定在月亮之上，即使失败，也可以落在众星之间。
 */
@Service
@Transactional
public class PayOutOrderDetailServiceImpl extends PayBaseServiceImpl<PayOutOrderDetailMapper,PayOutOrderDetail>
        implements PayOutOrderDetailService {


}
