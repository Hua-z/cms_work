package com.xj.apps.cms.config;

import com.xj.apps.cms.utils.Message;
import com.xj.apps.cms.utils.MessageUtil;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomerExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    public <E> Message handler(Exception exception){
        exception.printStackTrace();
        return MessageUtil.error(exception.getMessage());
    }
}
