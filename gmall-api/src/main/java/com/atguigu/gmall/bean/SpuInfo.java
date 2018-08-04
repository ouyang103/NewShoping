package com.atguigu.gmall.bean;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author yufei
 * @create 2018-08-03 16:25
 */
@Table(name = "spu_info")
public class SpuInfo implements Serializable {
    
    /**
    *销售商品id
    */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  String id;
    
    /**
    *销售商品名称
    */
    @Column
    private  String spuName;
    
    /**
    *销售介绍
    */
    @Column
    private  String description;

    /**
    *三级查询id
    */
    @Column
    private  String catalog3Id;
    
    /**
    *备用字符
    */
    @Column
    private  String tmId;

    @Transient
    private List<SpuSaleAttr> spuSaleAttrList;
    @Transient
    private List<SpuImage> spuImageList;

    public List<SpuSaleAttr> getSpuSaleAttrList() {
        return spuSaleAttrList;
    }

    public void setSpuSaleAttrList(List<SpuSaleAttr> spuSaleAttrList) {
        this.spuSaleAttrList = spuSaleAttrList;
    }

    public List<SpuImage> getSpuImageList() {
        return spuImageList;
    }

    public void setSpuImageList(List<SpuImage> spuImageList) {
        this.spuImageList = spuImageList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSpuName() {
        return spuName;
    }

    public void setSpuName(String spuName) {
        this.spuName = spuName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCatalog3Id() {
        return catalog3Id;
    }

    public void setCatalog3Id(String catalog3Id) {
        this.catalog3Id = catalog3Id;
    }

    public String getTmId() {
        return tmId;
    }

    public void setTmId(String tmId) {
        this.tmId = tmId;
    }
}
