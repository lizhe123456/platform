package com.tjzy.platform.model.constant;

/**
 * author:lizhe
 * date: 2017-12-05
 * for tomorrow
 * 类介绍:
 */
public final class Constant {

    public static final String BASE_PACKAGE = "com.tjzy.platform";


    public static final String MODEL_PACKAGE = BASE_PACKAGE + ".model";
    public static final String MAPPER_PACKAGE = BASE_PACKAGE + ".dao.mapper";
    public static final String SERVICE_PACKAGE = BASE_PACKAGE + ".service";
    public static final String SERVICE_IMPL_PACKAGE = BASE_PACKAGE + ".service.impl";
    public static final String CONTROLLER_PACKAGE = BASE_PACKAGE + ".web.controller";
    public static final String MAPPER_INTERFACE_REFERENCE = BASE_PACKAGE + ".dao.MyMapper";


    public static final String SUCCESS_RESULT = "SUCCESS";
    public static final String NOT_FOUND_RESULT = "接口 [%s] 不存在";
    public static final String INTERNAL_SERVER_ERROR_SIMPLE_RESULT = "接口 [%s] 内部错误，请联系管理员!";
    public static final String INTERNAL_SERVER_ERROR_DETAIL_RESULT = "接口 [%s] 出现异常，方法：%s.%s，异常摘要：%s";

}
