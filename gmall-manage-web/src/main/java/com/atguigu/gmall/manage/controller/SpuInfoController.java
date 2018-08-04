package com.atguigu.gmall.manage.controller;

import ControllerUtils.BaseController;
import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall.bean.BaseSaleAttr;
import com.atguigu.gmall.bean.SpuInfo;
import com.atguigu.gmall.service.SpuInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author yufei
 * @create 2018-08-03 16:22
 */
@Controller
public class SpuInfoController extends BaseController {

    @Reference
    SpuInfoService spuInfoService;

    @RequestMapping("/getSpuListData")
    @ResponseBody
    public List<SpuInfo> getSpuListData(String ctg3Id) {
        return spuInfoService.getSpuListData(ctg3Id);
    }

    @RequestMapping("/getSaleValeName")
    @ResponseBody
    public List<BaseSaleAttr> getSaleValeName() {
        return spuInfoService.getSaleValeName();
    }

    @ResponseBody
    @RequestMapping("/saveSpu")
    public Object saveSpu(SpuInfo spuInfo) {
        start();
        try {
           spuInfoService.saveSpu(spuInfo);
            success(true);
        }catch (Exception e) {
            success(false);
            e.printStackTrace();
        }

        return end();
    }
}
