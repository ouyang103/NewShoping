package com.atguigu.gmall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.atguigu.gmall.bean.*;
import com.atguigu.gmall.manage.mapper.*;
import com.atguigu.gmall.service.AttrService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author yufei
 * @create 2018-08-01 11:44
 */
@Service
public class AttrServiceImpl implements AttrService {

    @Autowired
    Attr1Mapper attr1Mapper;

    @Autowired
    Attr2Mapper attr2Mapper;

    @Autowired
    Attr3Mapper attr3Mapper;

    @Autowired
    AttrInfoMapper attrInfoMapper;

    @Autowired
    BaseAttrValueMapper baseAttrValueMapper;

    @Override
    public List<BaseCatalog1> getCatalog1() {
        return attr1Mapper.selectAll();
    }

    @Override
    public List<BaseCatalog2> getCatalog2(String getCatalogId) {

        BaseCatalog2 baseCatalog2 = new BaseCatalog2();
        baseCatalog2.setCatalog1Id(getCatalogId);

        return attr2Mapper.select(baseCatalog2);
    }

    @Override
    public List<BaseCatalog3> getCatalog3(String getCatalogId) {

        BaseCatalog3 baseCatalog3 = new BaseCatalog3();
        baseCatalog3.setCatalog2Id(getCatalogId);

        return attr3Mapper.select(baseCatalog3);
    }

    @Override
    public List<AttrInfo> getArrtListData(String ctg3Id) {

        AttrInfo attrInfo = new AttrInfo();
        attrInfo.setCatalog3Id(ctg3Id);

        return attrInfoMapper.select(attrInfo);
    }

    /**
     * 保存商城属性
     */
    @Override
    public void saveArr(AttrInfo attrInfo) {

        //判断如果传入的数据有主键就更新，没有就保存
        if(attrInfo.getId() != null) {
            //更新商品属性
            attrInfoMapper.updateByPrimaryKey(attrInfo);
            //删除原先的商品值
            BaseAttrValue baseAttrValue2 = new BaseAttrValue();

            baseAttrValue2.setAttrId(attrInfo.getId());

            baseAttrValueMapper.delete(baseAttrValue2);


            //重新插入新的值
            List<BaseAttrValue> attrValues = attrInfo.getAttrValues();

            for (BaseAttrValue baseAttrValue:attrValues) {
                baseAttrValue.setAttrId(attrInfo.getId());
                baseAttrValueMapper.insert(baseAttrValue);
            }
        } else {
            //保存商品属性信息
            attrInfoMapper.insertSelective(attrInfo);
            List<BaseAttrValue> attrValues = attrInfo.getAttrValues();

            for (BaseAttrValue baseAttrValue:attrValues) {
                baseAttrValue.setAttrId(attrInfo.getId());
                baseAttrValueMapper.insert(baseAttrValue);
            }
        }
    }

    @Override
    public void deleteArrByID(String arrId) {
        //删除商品属性
        attrInfoMapper.deleteByPrimaryKey(arrId);

        BaseAttrValue baseAttrValue = new BaseAttrValue();

        baseAttrValue.setAttrId(arrId);

        //删除商品属性值
        baseAttrValueMapper.delete(baseAttrValue);
    }

    @Override
    public List<BaseAttrValue> getAttrValueList(String attrId) {
        BaseAttrValue baseAttrValue = new BaseAttrValue();
        baseAttrValue.setAttrId(attrId);
        return baseAttrValueMapper.select(baseAttrValue);
    }

}
