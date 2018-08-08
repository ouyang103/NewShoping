package com.atguigu.gmall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.atguigu.gmall.bean.*;
import com.atguigu.gmall.manage.mapper.*;
import com.atguigu.gmall.service.SkuInfoService;
import com.atguigu.gmall.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import redis.clients.jedis.Jedis;

import java.util.List;

/**
 * @author yufei
 * @create 2018-08-06 14:59
 */
@Service
@Transactional
public class SkuInfoServiceImpl implements SkuInfoService {

    @Autowired
    SkuInfoMapper skuInfoMapper;

    @Autowired
    SkuAttrValueMapper skuAttrValueMapper;

    @Autowired
    SkuImageMapper skuImageMapper;

    @Autowired
    SkuSaleAttrValueMapper skuSaleAttrValueMapper;

    @Autowired
    RedisUtil redisUtil;

    @Override
    public List<SkuInfo> getSkuInfoPage(String spuId) {
        SkuInfo skuInfo = new SkuInfo();
        skuInfo.setSpuId(spuId);
        return skuInfoMapper.select(skuInfo);
    }

    @Override
    public void saveSku(SkuInfo skuInfo) {
        skuInfoMapper.insert(skuInfo);

        String skuId = skuInfo.getId();

        List<SkuAttrValue> skuAttrValueList = skuInfo.getSkuAttrValueList();

        for (SkuAttrValue skuAttrValue : skuAttrValueList) {
            skuAttrValue.setSkuId(skuId);
            skuAttrValueMapper.insert(skuAttrValue);
        }

        List<SkuImage> skuImageList = skuInfo.getSkuImageList();
        for (SkuImage skuImage : skuImageList) {
            skuImage.setSkuId(skuId);
            skuImageMapper.insert(skuImage);
        }

        List<SkuSaleAttrValue> skuSaleAttrValueList = skuInfo.getSkuSaleAttrValueList();
        for (SkuSaleAttrValue skuSaleAttrValue : skuSaleAttrValueList) {
            skuSaleAttrValue.setSkuId(skuId);
            skuSaleAttrValueMapper.insert(skuSaleAttrValue);
        }
    }

    @Override
    public SkuInfo getSkuInfo(String skuId) {
        //redis缓冲查看是否有skuInfo数据
        Jedis jedis = redisUtil.getJedis();
        SkuInfo skuInfo = null;


        String key = "sku"+skuId+"info";
        String val = jedis.get(key);

        skuInfo = JSON.parseObject(val, SkuInfo.class);

        //判断skuInfo是否为空
        if(skuInfo == null) {
            skuInfo = getSkuByIdFormDb(skuId);

            //同步缓存
            jedis.set(key,JSON.toJSONString(skuInfo));
        }

        return skuInfo;
    }

    private SkuInfo getSkuByIdFormDb(String skuId) {
        //查询skuInfo的信息
        SkuInfo skuInfo = skuInfoMapper.selectByPrimaryKey(skuId);

        //查询skuImage图片信息
        SkuImage skuImage = new SkuImage();
        skuImage.setSkuId(skuId);
        List<SkuImage> selectSkuImage = skuImageMapper.select(skuImage);
        skuInfo.setSkuImageList(selectSkuImage);

        //查询spu销售属性值信息
        SkuSaleAttrValue skuSaleAttrValue = new SkuSaleAttrValue();
        skuSaleAttrValue.setSkuId(skuId);
        List<SkuSaleAttrValue> select = skuSaleAttrValueMapper.select(skuSaleAttrValue);
        skuInfo.setSkuSaleAttrValueList(select);

        return skuInfo;
    }

}
