package com.atguigu.guliedu.ucenter.controller.exception;

import com.atguigu.entity.R;
import com.atguigu.entity.ResultCode;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 统一异常处理类
 * 全局异常处理器@ControllerAdvice
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 自定义异常
     * @param e
     * @return
     */
    @ExceptionHandler(EduException.class)//异常控制器注解
    @ResponseBody
    public R error(EduException e){
        e.printStackTrace();
        return R.error().code(e.getCode()).message(e.getMsg());
    }

    @ExceptionHandler(Exception.class)//异常控制器注解
    @ResponseBody
    public R error(Exception e){
        e.printStackTrace();
        return R.error().message("出错了");
    }

    /**
     * 特殊异常处理 EduException
     * @param e
     * @return
     */
    @ExceptionHandler(BadSqlGrammarException.class)//异常控制器注解
    @ResponseBody
    public R error(BadSqlGrammarException e){
        e.printStackTrace();
        return R.error().code(ResultCode.SQL_ERROR).message("SQL语法错误");
    }

}
