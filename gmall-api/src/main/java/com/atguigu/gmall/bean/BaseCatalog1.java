package com.atguigu.gmall.bean;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author yufei
 * @create 2018-08-01 11:29
 */
public class BaseCatalog1 implements Serializable {
    
    /**
    *一级查询id
    */
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  String id;
    
    /**
    *一级查询商品名称
    */
    @Column
    private String name;

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
