package com.atguigu.guliedu.ucenter.controller.admin;

import com.atguigu.entity.R;
import com.atguigu.entity.ResultCode;
import com.atguigu.guliedu.ucenter.entity.Member;
import com.atguigu.guliedu.ucenter.service.MemberLoginLogService;
import com.atguigu.guliedu.ucenter.service.MemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@Api(description = "学员登录日志管理")
@RestController
@RequestMapping("/admin/ucenter/member-login-log")
public class MemberLoginLogAdminController {

    @Autowired
    private MemberLoginLogService memberLoginLogService;

    @ApiOperation(value = "某日的登录数量统计",notes = "某日的登录数量统计")
    @GetMapping("login-count/{day}")
    public R loginByDate(
            @ApiParam(name = "day",value = "登录日期",required = true)
            @PathVariable String day){

       Integer count = memberLoginLogService.loginCount1(day);
        return R.ok().data("count",count);
    }


}
