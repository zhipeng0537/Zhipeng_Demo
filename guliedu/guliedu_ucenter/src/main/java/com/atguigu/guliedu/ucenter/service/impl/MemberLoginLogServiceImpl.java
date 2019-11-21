package com.atguigu.guliedu.ucenter.service.impl;

import com.atguigu.guliedu.ucenter.entity.MemberLoginLog;
import com.atguigu.guliedu.ucenter.mapper.MemberLoginLogMapper;
import com.atguigu.guliedu.ucenter.service.MemberLoginLogService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 会员登录日志表 服务实现类
 * </p>
 *
 * @author LiuZhiPeng
 * @since 2019-01-11
 */
@Service
public class MemberLoginLogServiceImpl extends ServiceImpl<MemberLoginLogMapper, MemberLoginLog> implements MemberLoginLogService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MemberLoginLogServiceImpl.class);


    @Override
    public Integer loginCount(String day) {
        QueryWrapper<MemberLoginLog> objectQueryWrapper = new QueryWrapper<>();
        objectQueryWrapper.eq("DATE(login_time)",day);
        Integer integer = baseMapper.selectCount(objectQueryWrapper);
        return integer;

    }

    @Override
    public Integer loginCount1(String day) {

    try {
       int i = 9/0;
        LOGGER.debug("命中缓存");
    }catch (Exception e){
        LOGGER.error("缓存获取失败");
    }

        return baseMapper.selectLoginCount1(day);
    }

/*    @Override
    public Integer loginCount1(String day) {
       return baseMapper.selectLoginCount1(day);
    }*/
}
