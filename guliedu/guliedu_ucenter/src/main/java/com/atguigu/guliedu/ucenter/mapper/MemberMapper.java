package com.atguigu.guliedu.ucenter.mapper;

import com.atguigu.guliedu.ucenter.entity.Member;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 会员表 Mapper 接口
 * </p>
 *
 * @author LiuZhiPeng
 * @since 2019-01-11
 */
public interface MemberMapper extends BaseMapper<Member> {

    Integer createCount1(String day);
}
