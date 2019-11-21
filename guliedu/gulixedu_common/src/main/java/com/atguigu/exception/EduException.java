package com.atguigu.exception;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor //s所有参数都有的构造函数
@NoArgsConstructor
@ApiModel(value = "全局异常")
public class EduException extends RuntimeException {


    @ApiModelProperty(value = "错误码")
    private Integer code;

    @ApiModelProperty(value = "错误信息")
    private String msg;
}
