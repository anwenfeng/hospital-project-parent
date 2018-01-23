package com.jk.controller.user;

import com.jk.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    //跳转到用户列表页面
    @RequestMapping("toUserListPage")
    public String toUserListPage(){

        return "user/userListPage";
    }

    //查询用户信息并分页
    @RequestMapping("queryUserList")
    @ResponseBody
    public Map<String,Object> findUser(Integer startPos, Integer pageSize ){

        Map<String, Object> map=new HashMap<String, Object>();

        //查询数据总条数
        long dataTotal=userService.queryDataTotal();

        List<Map<String,Object>> list=userService.findUser(startPos,pageSize);


        map.put("total", dataTotal);

        map.put("rows", list);

        return map;

    }

}
