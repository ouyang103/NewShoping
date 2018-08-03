package com.atguigu.gmall.manage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author yufei
 * @create 2018-07-31 16:25
 */
@Controller
public class IndexController {

    /**
     * 跳转去主页
     * @return
     */
    @RequestMapping("index")
    public String index() {
        return "index";
    }

    /**
     * 属性信息管理引用attrList页面加载选项卡信息
     * @return
     */
    @RequestMapping("/attrListPage")
    public String attrListPage() {
        return "attrListPage";
    }
}
