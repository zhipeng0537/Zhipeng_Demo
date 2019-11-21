package com.atguigu.guliedu.ucenter.controller.admin;

import com.atguigu.entity.R;
import com.atguigu.entity.ResultCode;
import com.atguigu.guliedu.ucenter.entity.Member;
import com.atguigu.guliedu.ucenter.entity.QueryMember;
import com.atguigu.guliedu.ucenter.service.MemberService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Wrapper;
import java.util.List;
@CrossOrigin
@Api(description = "学员管理")
@RestController
@RequestMapping("/admin/ucenter/member")
public class MemberAdminController {

    @Autowired
    private MemberService memberService;

    @GetMapping
    public R list(){
        List<Member> list = memberService.list(null);
        return R.ok().data("items",list);
    }

    @DeleteMapping("{memberId}")
    public R deleceById(@PathVariable String memberId){
        boolean result = memberService.removeById(memberId);
        return R.ok();
    }

/*    @PutMapping("{memberId}")
    public R test1(@PathVariable String memberId){
        Member member = new Member();
        member.setMemberId(memberId);
        member.setIsAvailable(false);
        boolean b = memberService.updateById(member);
        deleceById(memberId);
        return R.ok();
    }*/
    @ApiOperation(value = "冻结学员",notes = "冻结学员,memberId . createTime .updateTime后台自动填充")
    @PutMapping("lock/{memberId}")
    public R lockById(
            @ApiParam(name = "memberId",value = "学员ID",required = true)
            @PathVariable String memberId){
        boolean result = memberService.lockById(memberId, true);
        if(result){
            return R.ok();
        }else {
            return R.error().message("未更新数据").code(ResultCode.NOT_MOD);
        }

    }
    @ApiOperation(value = "解冻学员",notes = "解冻学员,memberId . createTime .updateTime后台自动填充")
    @PutMapping("unlock/{memberId}")
    public R unlockById(
            @ApiParam(name = "memberId",value = "学员ID",required = true)
            @PathVariable String memberId){
        boolean result = memberService.lockById(memberId, false);
        if(result){
            return R.ok();
        }else {
            return R.error().message("未更新数据").code(ResultCode.NOT_MOD);
        }

    }

    @ApiOperation(value = "某日的注册人数",notes = "某日的注册人数")
    @GetMapping("register-count/{day}")
    public R createByDate(
            @ApiParam(name = "day",value = "注册日期",required = true)
            @PathVariable String day){

        Integer count = memberService.createCount1(day);
        return R.ok().data("count",count);
    }

    @ApiOperation(value = "分页学员列表")
    @PostMapping(value = "{page}/{limit}")
    public R pageList(
            @ApiParam(name = "page",value = "当前页码",required = true)
            @PathVariable Long page,
            @ApiParam(name = "limit",value = "每页记录数",required = true)
            @PathVariable Long limit,
            @ApiParam(name = "searchObject",value = "查询条件封装成的对象")
            @RequestBody(required = false) QueryMember searchObject){

        Page<Member> objectPage = new Page<>(page, limit);
        memberService.pageList(objectPage, searchObject);

        long total = objectPage.getTotal();
        List<Member> records = objectPage.getRecords();

        return R.ok().data("total",total).data("rows",records);
    }

    @ApiOperation(value = "批量注册学员Excel")
    @PostMapping("import")
    public R addUser(MultipartFile file,Integer mark){



        return R.ok();
    }

}
