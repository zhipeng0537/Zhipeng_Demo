package com.atguigu.guliedu.ucenter.controller;


import com.atguigu.entity.R;
import com.atguigu.guliedu.ucenter.entity.Member;
import com.atguigu.guliedu.ucenter.service.MemberService;

import com.atguigu.guliedu.ucenter.service.impl.MemberServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 会员表 前端控制器
 * </p>
 *
 * @author LiuZhiPeng
 * @since 2019-01-11
 */
@Api(description = "学员管理")
@RestController
@RequestMapping("/ucenter/member")
public class MemberController {
    @Autowired
    private MemberService memberService;

    //命名日志记录器
    private static final Logger DATA_LOGGER = LoggerFactory.getLogger("dataLogger");


    @ApiOperation(value = "学员注册",notes = "学员注册,memberId . createTime .updateTime后台自动填充")
    @PostMapping
    public R register(
            @ApiParam(name = "m",value = "学员信息的Json数据",required = true)
            @RequestBody Member member){ //@RequestBody   用 json 提交数据
        boolean result = memberService.save(member);
        DATA_LOGGER.info("module=Member`api=register`memberId={}",member.getMemberId());
        return R.ok().data("count",result);

    }



}

