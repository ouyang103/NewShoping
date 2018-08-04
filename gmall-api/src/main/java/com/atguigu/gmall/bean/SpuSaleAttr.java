package com.atguigu.gmall.bean;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author yufei
 * @create 2018-08-03 20:56
 */
@Table(name = "spu_sale_attr")
public class SpuSaleAttr implements Serializable {
    /**
    *id
    */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  String id;
    
    /**
    *spuId
    */
    @Column
    private  String spuId;
    
    /**
    *saleAttrId
    */
    @Column
    private  String saleAttrId;
    
    /**
    *saleAttrName
    */
    @Column
    private  String saleAttrName;

    @Transient
    List<SpuSaleAttrValue> spuSaleAttrValueList;

    @Transient
    Map spuSaleAttrValueJson;

    public List<SpuSaleAttrValue> getSpuSaleAttrValueList() {
        return spuSaleAttrValueList;
    }

    public void setSpuSaleAttrValueList(List<SpuSaleAttrValue> spuSaleAttrValueList) {
        this.spuSaleAttrValueList = spuSaleAttrValueList;
    }

    public Map getSpuSaleAttrValueJson() {
        return spuSaleAttrValueJson;
    }

    public void setSpuSaleAttrValueJson(Map spuSaleAttrValueJson) {
        this.spuSaleAttrValueJson = spuSaleAttrValueJson;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSpuId() {
        return spuId;
    }

    public void setSpuId(String spuId) {
        this.spuId = spuId;
    }

    public String getSaleAttrId() {
        return saleAttrId;
    }

    public void setSaleAttrId(String saleAttrId) {
        this.saleAttrId = saleAttrId;
    }

    public String getSaleAttrName() {
        return saleAttrName;
    }

    public void setSaleAttrName(String saleAttrName) {
        this.saleAttrName = saleAttrName;
    }
}
