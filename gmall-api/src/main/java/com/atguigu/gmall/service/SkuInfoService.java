package com.atguigu.gmall.service;

import com.atguigu.gmall.bean.SkuImage;
import com.atguigu.gmall.bean.SkuInfo;
import com.atguigu.gmall.bean.SpuInfo;

import java.util.List;

/**
 * @author yufei
 * @create 2018-08-06 14:56
 */
public interface SkuInfoService {
    List<SkuInfo> getSkuInfoPage(String spuId);

    void saveSku(SkuInfo skuInfo);

    SkuInfo getSkuInfo(String skuId);
}
