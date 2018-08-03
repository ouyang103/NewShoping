package com.atguigu.gmall.bean;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author yufei
 * @create 2018-08-02 8:27
 */
@Table(name = "base_attr_value")
public class BaseAttrValue implements Serializable {
    
    /**
    *属性值的id
    */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  String id;
    
    /**
    *属性值的名称
    */
    @Column(name = "value_name")
    private  String valueName;

    /**
    *属性的id
    */
    @Column(name = "attr_id")
    private  String attrId;

    /**
    *备用字符
    */
    @Column(name = "is_enabled")
    private  String isEnabled;

    /**
    *临时的url地址
    */
    @Transient
    private  String urlParam;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getValueName() {
        return valueName;
    }

    public void setValueName(String valueName) {
        this.valueName = valueName;
    }

    public String getAttrId() {
        return attrId;
    }

    public void setAttrId(String attrId) {
        this.attrId = attrId;
    }

    public String getUrlParam() {
        return urlParam;
    }

    public void setUrlParam(String urlParam) {
        this.urlParam = urlParam;
    }

    public String getIsEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(String isEnabled) {
        this.isEnabled = isEnabled;
    }
}
