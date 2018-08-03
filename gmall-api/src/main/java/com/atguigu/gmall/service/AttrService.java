package com.atguigu.gmall.service;

import com.atguigu.gmall.bean.*;

import java.util.List;

/**
 * @author yufei
 * @create 2018-08-01 11:36
 */
public interface AttrService {
    List<BaseCatalog1> getCatalog1();

    List<BaseCatalog2> getCatalog2(String getCatalogId);

    List<BaseCatalog3> getCatalog3(String getCatalogId);

    List<AttrInfo> getArrtListData(String ctg3Id);

    void saveArr(AttrInfo attrInfo);

    void deleteArrByID(String arrId);

    List<BaseAttrValue> getAttrValueList(String attrId);
}
