package com.tjzy.platform.model.exception;

/**
 * author:lizhe
 * date: 2017-12-05
 * for tomorrow
 * 类介绍: 业务异常, 该异常只做 INFO 级别的日志记录.
 */
@SuppressWarnings("serial")
public class ServiceException extends RuntimeException{
    public ServiceException(){

    }

    public ServiceException(String message){
        super(message);
    }

    public ServiceException(String message, Throwable cause){
        super(message,cause);
    }
}
