package com.atguigu.guliedu.ucenter.controller;


import com.atguigu.entity.R;
import com.atguigu.guliedu.ucenter.entity.MemberLoginLog;
import com.atguigu.guliedu.ucenter.service.MemberLoginLogService;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 会员登录日志表 前端控制器
 * </p>
 *
 * @author LiuZhiPeng
 * @since 2019-01-11
 */
@RestController
@RequestMapping("/ucenter/member-login-log")
public class MemberLoginLogController {

    @Autowired
    private MemberLoginLogService memberLoginLogService;

    @GetMapping("{time}")
    public R selsectData(@PathVariable Date time){
        List<MemberLoginLog> list = memberLoginLogService.list(null);
        int count=0;
        SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd");

        for (MemberLoginLog memberLoginLog : list) {
            if(time!=null){
              /* if(fmt.format(memberLoginLog.getLoginTime()).equals(fmt.format(time))){
                 count++;
               }*/
               if(time.equals(memberLoginLog.getLoginTime())){
                   count++;
               }
               /* if(DateUtils.isSameDay(memberLoginLog.getLoginTime(),time)){
                    count++;
                }*/
            }

        }
        return R.ok().data("count",count);
    }

}

