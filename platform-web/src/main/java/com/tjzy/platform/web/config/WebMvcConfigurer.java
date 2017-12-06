package com.tjzy.platform.web.config;

import com.alibaba.fastjson.JSON;
import com.tjzy.platform.model.constant.Constant;
import com.tjzy.platform.model.exception.ServiceException;
import com.tjzy.platform.model.result.Result;
import com.tjzy.platform.model.result.ResultCode;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by lizhe on 2017/12/6 0006.
 * 目标定在月亮之上，即使失败，也可以落在众星之间。
 */
@Configuration
public class WebMvcConfigurer extends WebMvcConfigurerAdapter{

    private final Logger _log = LoggerFactory.getLogger(WebMvcConfigurer.class);

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        super.configureMessageConverters(converters);
    }


    @Override
    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {
        exceptionResolvers.add(new HandlerExceptionResolver() {
            @Override
            public ModelAndView resolveException(javax.servlet.http.HttpServletRequest request, HttpServletResponse response, Object handler,
                                                 Exception e) {
                Result result = new Result();
                if (e instanceof ServiceException) {
                    result.setCode(ResultCode.FAIL).setMsg(e.getMessage());
                    _log.info(e.getMessage());
                }else if (e instanceof NoHandlerFoundException) {
                    result.setCode(ResultCode.NOT_FOUND).setMsg(String.format(Constant.NOT_FOUND_RESULT, request.getRequestURI()));
                }else if (e instanceof ServletException) {
                    result.setCode(ResultCode.FAIL).setMsg(e.getMessage());
                } else {
                    result.setCode(ResultCode.INTERNAL_SERVER_ERROR).setMsg(String.format(Constant.INTERNAL_SERVER_ERROR_SIMPLE_RESULT, request.getRequestURI()));
                    String msg;
                    if (handler instanceof HandlerMethod) {
                        HandlerMethod handlerMethod = (HandlerMethod) handler;
                        msg = String.format(Constant.INTERNAL_SERVER_ERROR_DETAIL_RESULT,
                                request.getRequestURI(),
                                handlerMethod.getBean().getClass().getName(),
                                handlerMethod.getMethod().getName(),
                                e.getMessage());
                    } else {
                        msg = e.getMessage();
                    }
                    _log.error(msg, e);
                }
                responseResult(response, result);
                return new ModelAndView();
            }
        });
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {

    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        if (!registry.hasMappingForPattern("/static/**")) {
            registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        }
    }

    private void responseResult(HttpServletResponse response, Result result) {
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-type","application/json;charset=UTF-8");
        response.setStatus(200);
        try {
            response.getWriter().write(JSON.toJSONString(result));
        } catch (IOException e) {
            _log.error(e.getMessage());
        }
    }
}
