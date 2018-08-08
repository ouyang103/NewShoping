package com.atguigu.gmall.service;

import com.atguigu.gmall.bean.*;

import java.util.HashMap;
import java.util.List;

/**
 * @author yufei
 * @create 2018-08-03 16:33
 */
public interface SpuInfoService {
    List<SpuInfo> getSpuListData(String ctg3Id);

    List<BaseSaleAttr> getSaleValeName();

    void saveSpu(SpuInfo spuInfo);

    List<SpuSaleAttr> getSaleAttrListBySpuId(String spuId);

    List<SpuSaleAttr> getSpuSaleAttrListCheckBySku(HashMap<String,String> stringStringHashMap);

    List<SpuImage> getSpuImageListBySpuId(String spuId);

    List<SkuInfo> getSkuSaleAttrValueListBySpu(String spuId);
}
