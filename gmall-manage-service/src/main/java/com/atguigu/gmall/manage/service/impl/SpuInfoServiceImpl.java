package com.atguigu.gmall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.atguigu.gmall.bean.*;
import com.atguigu.gmall.manage.mapper.*;
import com.atguigu.gmall.service.SpuInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

/**
 * @author yufei
 * @create 2018-08-03 16:33
 */
@Service
@Transactional
public class SpuInfoServiceImpl implements SpuInfoService {

    @Autowired
    SpuInfoMapper spuInfoMapper;

    @Autowired
    BaseSaleAttrMapper baseSaleAttrMapper;

    @Autowired
    SpuSaleAttrMapper spuSaleAttrMapper;

    @Autowired
    SpuSaleAttrValueMapper spuSaleAttrValueMapper;

    @Autowired
    SpuImageMapper spuImageMapper;

    @Override
    public List<SpuInfo> getSpuListData(String ctg3Id) {
        SpuInfo spuInfo = new SpuInfo();
        spuInfo.setCatalog3Id(ctg3Id);
        return spuInfoMapper.select(spuInfo);
    }

    @Override
    public List<BaseSaleAttr> getSaleValeName() {
        return baseSaleAttrMapper.selectAll();
    }

    @Override
    public void saveSpu(SpuInfo spuInfo) {
        if(spuInfo.getId() ==  null) {
            spuInfoMapper.insertSelective(spuInfo);

            String spuId = spuInfo.getId();

            //保存图片信息
            List<SpuImage> spuImageList = spuInfo.getSpuImageList();

            for (SpuImage img:spuImageList) {
                img.setSpuId(spuId);
                spuImageMapper.insert(img);
            }

            //保存销售属性
            List<SpuSaleAttr> spuSaleAttrList = spuInfo.getSpuSaleAttrList();

            for (SpuSaleAttr spuSaleAttr:spuSaleAttrList) {
                spuSaleAttr.setSpuId(spuId);
                spuSaleAttrMapper.insert(spuSaleAttr);

                //保存销售属性值
                List<SpuSaleAttrValue> spuSaleAttrValueList = spuSaleAttr.getSpuSaleAttrValueList();
                for (SpuSaleAttrValue spuSaleAttrvalue:spuSaleAttrValueList) {
                    spuSaleAttrvalue.setSpuId(spuId);
                    spuSaleAttrValueMapper.insert(spuSaleAttrvalue);
                }
            }



        }
    }

    @Override
    public List<SpuSaleAttr> getSaleAttrListBySpuId(String spuId) {

        SpuSaleAttr spuSaleAttr = new SpuSaleAttr();

        spuSaleAttr.setSpuId(spuId);

        List<SpuSaleAttr> spuSaleAttrSelect = spuSaleAttrMapper.select(spuSaleAttr);

        for (SpuSaleAttr saleAttr : spuSaleAttrSelect) {
            SpuSaleAttrValue spuSaleAttrValue = new SpuSaleAttrValue();
            spuSaleAttrValue.setSpuId(saleAttr.getSpuId());
            spuSaleAttrValue.setSaleAttrId(saleAttr.getSaleAttrId());

            List<SpuSaleAttrValue> select = spuSaleAttrValueMapper.select(spuSaleAttrValue);

            saleAttr.setSpuSaleAttrValueList(select);
        }
        return spuSaleAttrSelect;
    }

    @Override
    public List<SpuImage> getSpuImageListBySpuId(String spuId) {

        SpuImage spuImage = new SpuImage();

        spuImage.setSpuId(spuId);

        return spuImageMapper.select(spuImage);
    }

    @Override
    public List<SkuInfo> getSkuSaleAttrValueListBySpu(String spuId) {
        return spuSaleAttrValueMapper.selectSkuSaleAttrValueListBySpu(spuId);
    }

    @Override
    public List<SpuSaleAttr> getSpuSaleAttrListCheckBySku(HashMap<String, String> stringStringHashMap) {
        return spuSaleAttrValueMapper.selectSpuSaleAttrListCheckBySku(stringStringHashMap);
    }
}
