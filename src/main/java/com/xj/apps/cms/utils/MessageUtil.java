package com.xj.apps.cms.utils;

import java.util.Date;

public class MessageUtil {
    //返回失败的信息，一般用于增删改操作结果的返回
    public static Message error(String msg){
        Message message = new Message();
        message.setStatus(500);
        message.setMessage(msg);
        message.setTimestamp(new Date().getTime());
        return message;
    }
    //返回成功消息，一般用于增删改操作结果的返回
    public static Message success(String msg){
        Message message = new Message();
        message.setStatus(200);
        message.setMessage(msg);
        message.setTimestamp(new Date().getTime());
        return message;
    }
    //返回成功消息，一般用于增删改操作结果的返回
    public static Message success(String msg,Object data){
        Message message = new Message();
        message.setStatus(200);
        message.setMessage(msg);
        message.setData(data);
        message.setTimestamp(new Date().getTime());
        return message;
    }
    //返回成功消息，一般用于增删改操作结果的返回
    public static Message success(Object data){
        Message message = new Message();
        message.setStatus(200);
        message.setData(data);
        message.setTimestamp(new Date().getTime());
        return message;
    }
}
