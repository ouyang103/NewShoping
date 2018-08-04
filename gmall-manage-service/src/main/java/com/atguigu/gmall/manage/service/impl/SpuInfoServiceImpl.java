package com.atguigu.gmall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.atguigu.gmall.bean.BaseSaleAttr;
import com.atguigu.gmall.bean.SpuInfo;
import com.atguigu.gmall.bean.SpuSaleAttr;
import com.atguigu.gmall.bean.SpuSaleAttrValue;
import com.atguigu.gmall.manage.mapper.BaseSaleAttrMapper;
import com.atguigu.gmall.manage.mapper.SpuInfoMapper;
import com.atguigu.gmall.manage.mapper.SpuSaleAttrMapper;
import com.atguigu.gmall.manage.mapper.SpuSaleAttrValueMapper;
import com.atguigu.gmall.service.SpuInfoService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author yufei
 * @create 2018-08-03 16:33
 */
@Service
public class SpuInfoServiceImpl implements SpuInfoService {

    @Autowired
    SpuInfoMapper spuInfoMapper;

    @Autowired
    BaseSaleAttrMapper baseSaleAttrMapper;

    @Autowired
    SpuSaleAttrMapper spuSaleAttrMapper;

    @Autowired
    SpuSaleAttrValueMapper spuSaleAttrValueMapper;

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
            spuInfoMapper.insert(spuInfo);

            //从数据库中查询出商品的spu
            SpuInfo spuInfo1 = spuInfoMapper.selectOne(spuInfo);

            //保存销售属性
            List<SpuSaleAttr> spuSaleAttrList = spuInfo.getSpuSaleAttrList();

            for (SpuSaleAttr spuSaleAttr:spuSaleAttrList) {
                spuSaleAttr.setSpuId(spuInfo1.getId());
                spuSaleAttrMapper.insert(spuSaleAttr);

                //保存销售属性值
                List<SpuSaleAttrValue> spuSaleAttrValueList = spuSaleAttr.getSpuSaleAttrValueList();
                for (SpuSaleAttrValue spuSaleAttrvalue:spuSaleAttrValueList) {
                    spuSaleAttrvalue.setSpuId(spuInfo1.getId());
                    spuSaleAttrValueMapper.insert(spuSaleAttrvalue);
                }
            }



        }
    }
}
