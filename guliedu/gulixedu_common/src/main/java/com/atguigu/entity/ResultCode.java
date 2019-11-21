package com.atguigu.entity;

public interface ResultCode {


    int OK = 20000;//成功
    int ERROR = 20001;//失败
    int LOGIN_ERROR = 20002;//用户名或密码错误
    int ACCESS_ERROR = 20003;//权限不足
    int REMOTE_ERROR = 20004;//远程调用失败
    int REPEAT_ERROR = 20005;//重复操作
    int NOT_MOD = 20100;//未更新数据
    int SQL_ERROR = 20006;//sql错误
}
