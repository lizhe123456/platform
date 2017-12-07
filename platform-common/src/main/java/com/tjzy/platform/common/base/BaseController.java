package com.tjzy.platform.common.base;

import com.tjzy.platform.model.constant.Constant;
import com.tjzy.platform.model.result.Result;
import com.tjzy.platform.model.result.ResultCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by lizhe on 2017/12/6 0006.
 * 目标定在月亮之上，即使失败，也可以落在众星之间。
 */
public class BaseController {

    protected static final Logger _log = LoggerFactory.getLogger(BaseController.class);

    /**
     * 处理成功的响应结果
     */
    protected Result handleSuc(){
        return new Result()
                .setCode(ResultCode.SUCCESS)
                .setMsg(Constant.SUCCESS_RESULT);
    }

    /**
     * 处理成功的响应结果
     * @param data 响应数据
     * @return
     */
    protected Result handleSuc(Object data){
        return handleSuc().setData(data);
    }

    /**
     * 处理失败的响应结果
     * @param msg 失败响应信息
     * @return
     */
    protected Result handleErr(String msg){
        return new Result()
                .setCode(ResultCode.FAIL)
                .setMsg(msg);
    }
}
