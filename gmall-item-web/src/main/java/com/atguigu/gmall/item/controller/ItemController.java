package com.atguigu.gmall.item.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.atguigu.gmall.bean.*;
import com.atguigu.gmall.service.SkuInfoService;
import com.atguigu.gmall.service.SpuInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author yufei
 * @create 2018-08-07 16:15
 */
@Controller
public class ItemController {

    @Reference
    SkuInfoService skuInfoService;

    @Reference
    SpuInfoService spuInfoService;

    @RequestMapping("{skuId}.html")
    public String toItem(@PathVariable("skuId") String skuId, ModelMap map) {

        SkuInfo skuInfo = skuInfoService.getSkuInfo(skuId);

        map.put("skuInfo",skuInfo);

        String spuId = skuInfo.getSpuId();

        //查询并拼接spu的sku和销售属性值id的关系
        List<SkuInfo> infos = spuInfoService.getSkuSaleAttrValueListBySpu(spuId);

        Map<String, String> stringStringHashMap1 = new HashMap<>();

        for (SkuInfo info : infos) {

            String v = info.getId();

            List<SkuSaleAttrValue> skuSaleAttrValueList = info.getSkuSaleAttrValueList();

            String k = "";

            for (SkuSaleAttrValue skuSaleAttrValue : skuSaleAttrValueList) {
                k+="|"+skuSaleAttrValue.getSaleAttrValueId();
            }
            stringStringHashMap1.put(k,v);
        }

        //将hash格式的map转换为json格式
        String skuJson = JSON.toJSONString(stringStringHashMap1);

        map.put("skuJson",skuJson);

        //销售属性列表
        HashMap<String, String> stringStringHashMap = new HashMap<>();
        stringStringHashMap.put("spuId",spuId);
        stringStringHashMap.put("skuId",skuId);

        List<SpuSaleAttr> saleAttrListBySpuId = spuInfoService.getSpuSaleAttrListCheckBySku(stringStringHashMap);

        map.put("spuSaleAttrListCheckBySku",saleAttrListBySpuId);

        return "item";
    }

}
