package com.atguigu.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall.bean.BaseCatalog1;
import com.atguigu.gmall.bean.BaseCatalog2;
import com.atguigu.gmall.bean.BaseCatalog3;
import com.atguigu.gmall.service.AttrService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author yufei
 * @create 2018-08-01 11:25
 */
@Controller
public class attrController {

    @Reference
    AttrService attrService;

    /**
     * 一级查询下拉列表信息
     * @return
     */
    @RequestMapping("getCatalog1")
    @ResponseBody
    public List<BaseCatalog1> getCatalog1() {

        List<BaseCatalog1> list = attrService.getCatalog1();

        return list;
    }

    /**
     * 二级查询下拉列表信息
     * @return
     */
    @ResponseBody
    @RequestMapping("getCatalog2")
    public List<BaseCatalog2> getCatalog2(String getCatalogId) {

        List<BaseCatalog2> list = attrService.getCatalog2(getCatalogId);

        return list;
    }

    /**
     * 三级查询下拉列表信息
     * @return
     */
    @RequestMapping("getCatalog3")
    @ResponseBody
    public List<BaseCatalog3> getCatalog3(String getCatalogId) {

        List<BaseCatalog3> list = attrService.getCatalog3(getCatalogId);

        return list;
    }
}
