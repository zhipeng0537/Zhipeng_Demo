package com.atguigu.guliedu.ucenter.service;

import com.atguigu.guliedu.ucenter.entity.Member;
import com.atguigu.guliedu.ucenter.entity.QueryMember;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 会员表 服务类
 * </p>
 *
 * @author LiuZhiPeng
 * @since 2019-01-11
 */
public interface MemberService extends IService<Member> {

    boolean lockById(String memberId, boolean b);

    Integer createCount1(String day);

    void pageList(Page<Member> objectPage, QueryMember searchObject);
}
