package com.atguigu.guliedu.ucenter.service;

import com.atguigu.guliedu.ucenter.entity.MemberLoginLog;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 会员登录日志表 服务类
 * </p>
 *
 * @author LiuZhiPeng
 * @since 2019-01-11
 */
public interface MemberLoginLogService extends IService<MemberLoginLog> {

    Integer loginCount(String day);
    Integer loginCount1(String day);
}
