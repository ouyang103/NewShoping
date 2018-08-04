package com.atguigu.gmall.bean;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author yufei
 * @create 2018-08-03 20:11
 */
@Table(name = "base_sale_attr")
public class BaseSaleAttr implements Serializable {

    /**
    *销售属性id
    */
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  String id;

    /**
    *销售属性名称
    */
    @Column
    private  String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
