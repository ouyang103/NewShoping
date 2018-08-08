package com.atguigu.gmall.bean;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author yufei
 * @create 2018-08-06 14:01
 */
public class SkuImage implements Serializable {
    /**
    *id
    */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  String id;
    /**
    *skuId
    */
    @Column
    private  String skuId;
    /**
    *imgName
    */
    @Column
    private  String imgName;
    /**
    *imgUrl
    */
    @Column
    private  String imgUrl;
    /**
    *spuImgId
    */
    @Column
    private  String spuImgId;
    /**
    *isDefault
    */
    @Column
    private  String isDefault = "0";

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSkuId() {
        return skuId;
    }

    public void setSkuId(String skuId) {
        this.skuId = skuId;
    }

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getSpuImgId() {
        return spuImgId;
    }

    public void setSpuImgId(String spuImgId) {
        this.spuImgId = spuImgId;
    }

    public String getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(String isDefault) {
        this.isDefault = isDefault;
    }
}
