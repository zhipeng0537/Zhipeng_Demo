package com.atguigu.guliedu.ucenter.service.impl;

import com.atguigu.guliedu.ucenter.entity.Member;
import com.atguigu.guliedu.ucenter.entity.QueryMember;
import com.atguigu.guliedu.ucenter.mapper.MemberMapper;
import com.atguigu.guliedu.ucenter.service.MemberService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;

/**
 * <p>
 * 会员表 服务实现类
 * </p>
 *
 * @author LiuZhiPeng
 * @since 2019-01-11
 */
@Service
public class MemberServiceImpl extends ServiceImpl<MemberMapper, Member> implements MemberService {

    @Override
    public boolean lockById(String memberId, boolean lock) {
        Member member = new Member();
        member.setMemberId(memberId);
        member.setIsAvailable(!lock);
        int i = baseMapper.updateById(member);
        return resoultBool(i);
    }

    @Override
    public Integer createCount1(String day) {
       Integer count = baseMapper.createCount1(day);

        return count;
    }

    @Override
    public void pageList(Page<Member> objectPage, QueryMember searchObject) {
        //判断查询是否为空
        if(searchObject == null){
            baseMapper.selectPage(objectPage,null);
            return;
        }
        //获取查询参数
        String keyWord = searchObject.getKeyWord();
        Boolean isAvailable = searchObject.getIsAvailable();
        Date begin = searchObject.getBegin();
        Date end = searchObject.getEnd();
        QueryWrapper<Member> queryWrapper = new QueryWrapper<>();
       // 判断keyWord
        if(!StringUtils.isEmpty(keyWord)){
            queryWrapper.and(i -> i.like("mobile",keyWord)//likeRight左边没有% 不会造成索引失效
                    .or()
                    .like("nickname",keyWord));
        }

        //判断isAvailable
        if(!StringUtils.isEmpty(isAvailable)){
            queryWrapper.eq("is_available",isAvailable);
        }
        //判断注册时间范围
        if(!StringUtils.isEmpty(begin)){
            queryWrapper.ge("create_time",begin);
        }
        if(!StringUtils.isEmpty(end)){
            queryWrapper.le("create_time",end);
        }
        //执行分页查询
        baseMapper.selectPage(objectPage,queryWrapper);

    }

    private static boolean resoultBool(Integer result){
        return null != result && result>=1;
    }


}
