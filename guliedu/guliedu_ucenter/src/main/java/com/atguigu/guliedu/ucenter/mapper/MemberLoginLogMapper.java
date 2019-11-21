package com.atguigu.guliedu.ucenter.mapper;

import com.atguigu.guliedu.ucenter.entity.MemberLoginLog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 会员登录日志表 Mapper 接口
 * </p>
 *
 * @author LiuZhiPeng
 * @since 2019-01-11
 */
public interface MemberLoginLogMapper extends BaseMapper<MemberLoginLog> {

    Integer selectLoginCount1(String day);
}
