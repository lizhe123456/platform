package com.tjzy.platform.model.constant;

import com.tjzy.platform.model.base.BaseResult;

/**
 * Created by lizhe on 2017/12/7 0007.
 * 目标定在月亮之上，即使失败，也可以落在众星之间。
 */
public class PayResult extends BaseResult{

    public PayResult(PayResultConstant payResultConstant, Object data){
        super(payResultConstant.getCode(), payResultConstant.getMessage(), data);
    }
}
