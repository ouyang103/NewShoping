package com.atguigu.gmall.manage.controller;

import ControllerUtils.BaseController;
import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall.bean.SkuImage;
import com.atguigu.gmall.bean.SkuInfo;
import com.atguigu.gmall.service.SkuInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author yufei
 * @create 2018-08-06 14:54
 */
@Controller
public class SkuInfoController extends BaseController {

    @Reference
    SkuInfoService skuInfoService;

    @ResponseBody
    @RequestMapping("saveSku")
    public Object saveSku(SkuInfo skuInfo) {

        start();

        try {

            skuInfoService.saveSku(skuInfo);
            success(true);
        }catch (Exception e){
            success(false);
            e.printStackTrace();
        }

        return end();
    }


    @ResponseBody
    @RequestMapping("getSkuInfoPage")
    public List<SkuInfo> getSkuInfoPage(String  spuId) {

        List<SkuInfo> list = skuInfoService.getSkuInfoPage(spuId);

        return list;
    }
}
