package com.jk.controller.tree;

import com.jk.pojo.tree.Tree;
import com.jk.service.tree.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("tree")
public class TreeController {

    @Autowired
    private TreeService treeService;


    //跳转到主页面
    @RequestMapping("toMainPage")
    public String toMainPage(){

        return "tree/mainPage";
    }

    //查询树列表queryTreeList
    @RequestMapping("queryTreeList")
    @ResponseBody
    public List<Tree> queryTreeList(){

        List<Tree> list=treeService.queryTreeList(0);

        return list;
    }



}
