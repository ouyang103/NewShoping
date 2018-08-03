package com.atguigu.gmall.bean;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author yufei
 * @create 2018-08-01 18:36
 */
@Table(name = "base_attr_info")
public class AttrInfo implements Serializable {

    /**
    *商品的属性id
    */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  String id;

    /**
    *商品的属性名称
    */
    @Column
    private  String AttrName;

    /**
    *三级分类的id
    */
    @Column
    private  String Catalog3Id;
    
    /**
    *备用字符
    */
    @Column
    private  String isEnabled;
    
    /**
    *接收属性值
    */
    @Transient
    private List<BaseAttrValue> attrValues;
    
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAttrName() {
        return AttrName;
    }

    public void setAttrName(String attrName) {
        AttrName = attrName;
    }

    public String getCatalog3Id() {
        return Catalog3Id;
    }

    public void setCatalog3Id(String catalog3Id) {
        Catalog3Id = catalog3Id;
    }

    public String getIsEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(String isEnabled) {
        this.isEnabled = isEnabled;
    }

    public List<BaseAttrValue> getAttrValues() {
        return attrValues;
    }

    public void setAttrValues(List<BaseAttrValue> attrValues) {
        this.attrValues = attrValues;
    }
}
