package com.atguigu.gmall.service;

import com.atguigu.gmall.bean.BaseSaleAttr;
import com.atguigu.gmall.bean.SpuInfo;

import java.util.List;

/**
 * @author yufei
 * @create 2018-08-03 16:33
 */
public interface SpuInfoService {
    List<SpuInfo> getSpuListData(String ctg3Id);

    List<BaseSaleAttr> getSaleValeName();

    void saveSpu(SpuInfo spuInfo);
}
